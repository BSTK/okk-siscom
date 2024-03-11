CREATE TABLE FECHAMENTO
(
    ID                   NUMBER         NOT NULL,
    MES                  CHAR(2)        NOT NULL,
    ANO                  CHAR(4)        NOT NULL,
    VALOR_SALDO_ANTERIOR DECIMAL(10, 2) NOT NULL,
    VALOR_RECEBIMENTOS   DECIMAL(10, 2) NOT NULL,
    VALOR_PAGAMENTOS     DECIMAL(10, 2) NOT NULL,
    VALOR_SALDO_CONTA    DECIMAL(10, 2) NOT NULL,
    VALOR_SALDO_REAL     DECIMAL(10, 2) NOT NULL,
    DATA_INSERT          TIMESTAMP      NOT NULL,
    DATA_UPDATE          TIMESTAMP      NOT NULL,
    PRIMARY KEY (ID)
);