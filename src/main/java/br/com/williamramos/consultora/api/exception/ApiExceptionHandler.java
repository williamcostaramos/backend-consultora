package br.com.williamramos.consultora.api.exception;

import br.com.williamramos.consultora.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionErroSistema(Exception e, WebRequest request) {
        Problem problem = createProblem(HttpStatus.INTERNAL_SERVER_ERROR.value(), TypeProblem.ERROR_SISTEMA.getUrl(), TypeProblem.ERROR_SISTEMA.getDescricao(), e.getMessage(), TypeProblem.ERROR_SISTEMA.getDescricao());
        return this.handleExceptionInternal(e, problem, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handlerEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex, WebRequest request) {
        Problem problem = createProblem(HttpStatus.NOT_FOUND.value(), TypeProblem.RECURSO_NAO_ENCONTRADO.getUrl(), TypeProblem.RECURSO_NAO_ENCONTRADO.getDescricao(), ex.getMessage(), TypeProblem.RECURSO_NAO_ENCONTRADO.getDescricao());
        return this.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (body == null) {
            body = createProblem(status.value(), status.name(), status.getReasonPhrase(), ex.getMessage(), ex.getMessage());
        } else if (body instanceof String) {
            body = createProblem(status.value(), status.name(), status.getReasonPhrase(), (String) body, (String) body);
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Problem problem = handleProblemMessage(ex.getBindingResult(), status);
        return this.handleExceptionInternal(ex, problem, headers, status, request);
    }

    private Problem createProblem(int status, String type, String title, String detail, String userMessage) {
        Problem problem = new Problem();
        problem.status(status).type(type).title(title).detail(detail).userMessage(userMessage).timestamp(LocalDateTime.now());
        return problem;
    }

    private List<FieldProblem> fieldProblems(BindingResult ex, String detail) {

        List<FieldProblem> fieldProblems = ex.getAllErrors().stream().map(erro -> {
            FieldProblem fieldProblem = new FieldProblem();
            String mensagem = messageSource.getMessage(erro, Locale.getDefault());
            if (erro instanceof FieldError) {
                String fieldErro = ((((FieldError) erro).getField()));
                fieldProblem.setField(fieldErro);
                fieldProblem.setUserMessage(mensagem);
            } else {
                fieldProblem.setField(erro.getObjectName());
                fieldProblem.setUserMessage(mensagem);
            }
            return fieldProblem;

        }).collect(Collectors.toList());
        return fieldProblems;
    }

    private Problem handleProblemMessage(BindingResult ex, HttpStatus status) {
        String campos = ex.getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String detail = String.format("O(s) campos %s estão invalidos. Faça o preenchimento correto e tente novamente", campos);
        return new Problem(status.value(), TypeProblem.DADOS_INVALIDOS.getUrl(), TypeProblem.DADOS_INVALIDOS.getDescricao(), detail, detail, this.fieldProblems(ex, detail));
    }

}
