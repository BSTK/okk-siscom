CREATE SEQUENCE SEQUENCE_PAGAMENTO START WITH 1 INCREMENT BY 1;

CREATE TABLE PAGAMENTO
(
    ID                NUMBER         NOT NULL,
    NUMERO_DOCUMENTO  VARCHAR2(20)   NOT NULL,
    VALOR_TOTAL       DECIMAL(10, 2) NOT NULL,
    VALOR_JUROS       DECIMAL(10, 2) NOT NULL,
    VALOR_MULTA       DECIMAL(10, 2) NOT NULL,
    VALOR_DESCONTO    DECIMAL(10, 2) NOT NULL,
    VALOR_PAGO        DECIMAL(10, 2) NOT NULL,
    DATA_EMISSAO      DATE           NOT NULL,
    DATA_LANCAMENTO   DATE           NOT NULL,
    DATA_VENCIMENTO   DATE           NOT NULL,
    DATA_PAGAMENTO    DATE           NOT NULL,
    DATA_INSERT TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    DATA_UPDATE TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    TIPO_PAGAMENTO_ID NUMBER         NOT NULL,
    FORNECEDOR_ID     NUMBER         NOT NULL,
    BANCO_ID          NUMBER         NOT NULL,
    PLANO_CONTA_ID    NUMBER         NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (TIPO_PAGAMENTO_ID) REFERENCES TIPO_PAGAMENTO (ID),
    FOREIGN KEY (FORNECEDOR_ID) REFERENCES FORNECEDOR (ID),
    FOREIGN KEY (BANCO_ID) REFERENCES BANCO (ID),
    FOREIGN KEY (PLANO_CONTA_ID) REFERENCES PLANO_CONTA (ID)
);