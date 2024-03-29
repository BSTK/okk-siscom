CREATE SEQUENCE SEQUENCE_ENDERECO START WITH 1 INCREMENT BY 1;

CREATE TABLE ENDERECO
(
    ID          NUMBER        NOT NULL,
    RUA         VARCHAR2(50)  NOT NULL,
    NUMERO      VARCHAR2(10)  NOT NULL,
    COMPLEMENTO VARCHAR2(50),
    CEP         VARCHAR2(8)   NOT NULL,
    BAIRRO      VARCHAR2(50)  NOT NULL,
    CIDADE      VARCHAR2(100) NOT NULL,
    UF          CHAR(2)       NOT NULL,
    DATA_INSERT TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    DATA_UPDATE TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);