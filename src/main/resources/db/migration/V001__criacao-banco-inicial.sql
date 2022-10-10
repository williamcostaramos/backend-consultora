-- categoria
CREATE TABLE consultora.categoria
(
    id   INTEGER auto_increment NOT NULL,
    nome varchar(100)           NOT NULL,
    CONSTRAINT pk_categoria_id PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


-- cliente

CREATE TABLE `cliente`
(
    `id`                   int                                     NOT NULL AUTO_INCREMENT,
    `nome`                 varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
    `cpf`                  varchar(11) COLLATE utf8mb4_general_ci  NOT NULL,
    `estado_civil`         int                                     NOT NULL,
    `data_nascimento`      date                                    NOT NULL,
    `has_filhos`           tinyint(1)                              NOT NULL DEFAULT '0',
    `qtd_filhos`           int                                              DEFAULT NULL,
    `endereco_cep`         varchar(11) COLLATE utf8mb4_general_ci           DEFAULT NULL,
    `endereco_logradouro`  varchar(255) COLLATE utf8mb4_general_ci          DEFAULT NULL,
    `endereco_bairro`      varchar(100) COLLATE utf8mb4_general_ci          DEFAULT NULL,
    `endereco_cidade`      varchar(100) COLLATE utf8mb4_general_ci          DEFAULT NULL,
    `endereco_complemento` varchar(255) COLLATE utf8mb4_general_ci          DEFAULT NULL,
    `codigo`               varchar(36) COLLATE utf8mb4_general_ci  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE consultora.fornecedor
(
    id   INTEGER auto_increment NOT NULL,
    nome varchar(100)           NOT NULL,
    cnpj varchar(20)            NOT NULL,
    CONSTRAINT pk_fornecedor_id PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;

CREATE TABLE consultora.produto
(
    id                INTEGER        NOT NULL,
    nome              varchar(100)   NOT NULL,
    quantidade        INTEGER        NOT NULL,
    preco_compra      DECIMAL(10, 2) NOT NULL,
    preco_venda       decimal(10, 2) NOT NULL,
    porcentagem_lucro FLOAT          NOT NULL,
    forma_pagamento   INTEGER        NOT NULL,
    status_pagamento  INTEGER        NOT NULL,
    categoria_id      INTEGER        NOT NULL,
    fornecedor_id     INTEGER        NOT NULL,
    data_cadastro     TIMESTAMP      NOT NULL,
    data_atualizacao  TIMESTAMP      NULL,
    CONSTRAINT pk_produto_id PRIMARY KEY (id),
    CONSTRAINT fk_produto_categoria_id FOREIGN KEY (categoria_id) REFERENCES consultora.categoria (id),
    CONSTRAINT fk_produto_fornecedor_id FOREIGN KEY (fornecedor_id) REFERENCES consultora.fornecedor (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;


CREATE TABLE consultora.estoque
(
    id               INTEGER auto_increment NOT NULL,
    qtd_atual        INTEGER                NOT NULL,
    qtd_comprada     INTEGER                NOT NULL,
    qtd_minima       INTEGER                NOT NULL,
    data_compra      DATE                   NOT NULL,
    data_cadastro    TIMESTAMP              NOT NULL,
    data_atualizacao TIMESTAMP              NULL,
    produto_id       INTEGER                NOT NULL,
    CONSTRAINT pk_estoque_id PRIMARY KEY (id),
    CONSTRAINT fk_estoque_produto_id FOREIGN KEY (produto_id) REFERENCES consultora.produto (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;


CREATE TABLE consultora.venda
(
    id               INTEGER auto_increment NOT NULL,
    data_compra      TIMESTAMP              NOT NULL,
    subtotal         DECIMAL(10, 2)         NOT NULL,
    taxa_frete       DECIMAL(10, 2)         NULL,
    data_pagamento   TIMESTAMP              NULL,
    forma_pagamento  INT                    NOT NULL,
    status_pagamento INT                    NOT NULL,
    cliente_id       INTEGER                NOT NULL,
    CONSTRAINT pk_venda_id PRIMARY KEY (id),
    CONSTRAINT fk_venda_cliente_id FOREIGN KEY (cliente_id) REFERENCES consultora.cliente (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;

CREATE TABLE consultora.item_venda
(
    id             INTEGER auto_increment NOT NULL,
    quantidade     INTEGER                NOT NULL,
    valor_unitario DECIMAL(10, 2)         NOT NULL,
    valor_total    decimal(10, 2)         NOT NULL,
    produto_id     INTEGER                NOT NULL,
    venda_id       INTEGER                NOT NULL,
    CONSTRAINT pk_item_venda_id PRIMARY KEY (id),
    CONSTRAINT fk_item_venda_produto_id FOREIGN KEY (produto_id) REFERENCES consultora.produto (id),
    CONSTRAINT fk_item_venda_venda_id FOREIGN KEY (venda_id) REFERENCES consultora.venda (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci;






