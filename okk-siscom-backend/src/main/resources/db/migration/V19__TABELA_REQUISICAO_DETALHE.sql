CREATE TABLE REQUISICAO_DETALHE
(
    QUANTIDADE              NUMBER         NOT NULL,
    VALOR_UNITARIO          DECIMAL(10, 2) NOT NULL,
    VALOR_TOTAL             DECIMAL(10, 2) NOT NULL,
    DATA_INSERT             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    DATA_UPDATE             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    REQUISICAO_CABECALHO_ID NUMBER         NOT NULL,
    PRODUTO_ID              NUMBER         NOT NULL,
    PRIMARY KEY (REQUISICAO_CABECALHO_ID, PRODUTO_ID),
    FOREIGN KEY (REQUISICAO_CABECALHO_ID) REFERENCES REQUISICAO_CABECALHO (ID),
    FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO (ID)
);