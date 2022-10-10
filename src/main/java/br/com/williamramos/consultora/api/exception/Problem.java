package br.com.williamramos.consultora.api.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Problem {
    private int status;
    private String type;
    private String title;
    private String detail;
    private LocalDateTime timestamp;
    private String userMessage;
    private List<FieldProblem> fields = new ArrayList<>();

    public Problem(int status, String type, String title, String detail, String userMessage, List<FieldProblem> fields) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.userMessage=userMessage;
        this.fields = fields;
        this.timestamp = LocalDateTime.now();
    }

    public Problem() {
    }

    public int getStatus() {
        return status;
    }

    public Problem status(int status) {
        this.status = status;
        return this;
    }

    public String getType() {
        return type;
    }

    public Problem type(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Problem title(String title) {
        this.title = title;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public Problem userMessage(String userMessage) {
        this.userMessage = userMessage;
        return this;
    }

    public Problem detail(String detail) {
        this.detail = detail;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Problem timestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public List<FieldProblem> getFields() {
        return fields;
    }

    public Problem fields(List<FieldProblem> fields) {
        this.fields = fields;
        return this;
    }
}
