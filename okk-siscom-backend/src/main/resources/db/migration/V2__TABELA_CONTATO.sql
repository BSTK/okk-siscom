CREATE TABLE CONTATO
(
    ID          NUMBER    NOT NULL,
    NOME        VARCHAR2(100),
    EMAIL       VARCHAR2(50),
    TELEFONE    VARCHAR2(15),
    OBSERVACAO  VARCHAR2(500),
    DATA_INSERT TIMESTAMP NOT NULL,
    DATA_UPDATE TIMESTAMP NOT NULL,
    PRIMARY KEY (ID)
);