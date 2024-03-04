CREATE TABLE CLIENTE
(
    ID                          NUMBER      NOT NULL,
    NOME                        VARCHAR(50) NOT NULL,
    CPF                         VARCHAR(11) NOT NULL,
    RG                          VARCHAR(15) NOT NULL,
    RG_ORGAO_EXPEDITOR          VARCHAR(10) NOT NULL,
    DATA_NASCIMENTO             DATE        NOT NULL,
    EMAIL                       VARCHAR(50) NOT NULL,
    TELEFONE                    VARCHAR(15),
    PROFISSAO                   VARCHAR(100),
    EMPRESA                     VARCHAR(100),
    EMPRESA_TELEFONE_CONTATO    VARCHAR(15),
    EMPRESA_EMAIL               VARCHAR(50),
    RENDA                       DOUBLE PRECISION,
    REFERENCIA                  VARCHAR(50),
    REFERENCIA_TELEFONE_CONTATO VARCHAR(15),
    REFERENCIA_EMAIL            VARCHAR(50),
    DATA_INSERT                 TIMESTAMP   NOT NULL,
    DATA_UPDATE                 TIMESTAMP   NOT NULL,
    PRIMARY KEY (ID)
);