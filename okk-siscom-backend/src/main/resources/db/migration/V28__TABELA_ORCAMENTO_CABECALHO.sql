CREATE TABLE ORCAMENTO_CABECALHO
(
    ID             NUMBER         NOT NULL,
    DATA_ORCAMENTO DATE           NOT NULL,
    VALOR          DECIMAL(10, 2) NOT NULL,
    DATA_INSERT    TIMESTAMP      NOT NULL,
    DATA_UPDATE    TIMESTAMP      NOT NULL,
    CLIENTE_ID     NUMBER         NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE (ID)
);