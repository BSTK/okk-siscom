CREATE TABLE VENDA_DETALHE
(
    QUANTIDADE         NUMBER         NOT NULL,
    VALOR_UNITARIO     DECIMAL(10, 2) NOT NULL,
    VALOR_TOTAL        DECIMAL(10, 2) NOT NULL,
    DATA_INSERT        TIMESTAMP      NOT NULL,
    DATA_UPDATE        TIMESTAMP      NOT NULL,
    VENDA_CABECALHO_ID NUMBER         NOT NULL,
    PRODUTO_ID         NUMBER         NOT NULL,
    PRIMARY KEY (VENDA_CABECALHO_ID, PRODUTO_ID),
    FOREIGN KEY (VENDA_CABECALHO_ID) REFERENCES VENDA_CABECALHO (ID),
    FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO (ID)
);