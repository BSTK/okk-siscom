CREATE TABLE RECEBIMENTO
(
    ID                NUMBER         NOT NULL,
    NUMERO_DOCUMENTO  VARCHAR2(20)   NOT NULL,
    VALOR_TOTAL       DECIMAL(10, 2) NOT NULL,
    VALOR_JUROS       DECIMAL(10, 2) NOT NULL,
    VALOR_MULTA       DECIMAL(10, 2) NOT NULL,
    VALOR_DESCONTO    DECIMAL(10, 2) NOT NULL,
    VALOR_RECEBIDO    DECIMAL(10, 2) NOT NULL,
    DATA_EMISSAO      DATE           NOT NULL,
    DATA_LANCAMENTO   DATE           NOT NULL,
    DATA_VENCIMENTO   DATE           NOT NULL,
    DATA_RECEBIMENTO  DATE           NOT NULL,
    DATA_INSERT       TIMESTAMP      NOT NULL,
    DATA_UPDATE       TIMESTAMP      NOT NULL,
    TIPO_PAGAMENTO_ID NUMBER         NOT NULL,
    CLIENTER_ID       NUMBER         NOT NULL,
    BANCO_ID          NUMBER         NOT NULL,
    PLANO_CONTA_ID    NUMBER         NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (TIPO_PAGAMENTO_ID) REFERENCES TIPO_PAGAMENTO (ID),
    FOREIGN KEY (CLIENTER_ID) REFERENCES CLIENTER (ID),
    FOREIGN KEY (BANCO_ID) REFERENCES BANCO (ID),
    FOREIGN KEY (PLANO_CONTA_ID) REFERENCES PLANO_CONTA (ID)
);