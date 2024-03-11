CREATE TABLE NOTA_FISCAL_DETALHE
(
    ID                       NUMBER         NOT NULL,
    QUANTIDADE               NUMBER         NOT NULL,
    VALOR_UNITARIO           DECIMAL(10, 2) NOT NULL,
    DATA_INSERT              TIMESTAMP      NOT NULL,
    DATA_UPDATE              TIMESTAMP      NOT NULL,
    NOTA_FISCAL_CABECALHO_ID NUMBER         NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (NOTA_FISCAL_CABECALHO_ID) REFERENCES NOTA_FISCAL_CABECALHO (ID)
);