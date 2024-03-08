CREATE TABLE VENDA_CABECALHO
(
    ID                               NUMBER         NOT NULL,
    DATA_VENDA                       DATE           NOT NULL,
    VALOR                            DECIMAL(10, 2) NOT NULL,
    VALOR_DESCONTO                   DECIMAL(10, 2) NOT NULL,
    VALOR_TOTAL                      DECIMAL(10, 2) NOT NULL,
    NUMERO_PARCELAS                  INTEGER        NOT NULL,
    NUMERO_NOTA_FISCAL               VARCHAR2(10)   NOT NULL,
    DATA_VENCIMENTO_PRIMEIRA_PARCELA DATE           NOT NULL,
    DATA_INSERT                      TIMESTAMP      NOT NULL,
    DATA_UPDATE                      TIMESTAMP      NOT NULL,
    CLIENTE_ID                       NUMBER         NOT NULL,
    CARTAO_ID                        NUMBER         NOT NULL,
    FUNCIONARIO_ID                   NUMBER         NOT NULL,
    TIPO_PAGAMENTO_ID                NUMBER         NOT NULL,
    CFOP_ID                          NUMBER         NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE (ID),
    FOREIGN KEY (CARTAO_ID) REFERENCES CARTAO (ID),
    FOREIGN KEY (FUNCIONARIO_ID) REFERENCES FUNCIONARIO (ID),
    FOREIGN KEY (TIPO_PAGAMENTO_ID) REFERENCES TIPO_PAGAMENTO (ID),
    FOREIGN KEY (CFOP_ID) REFERENCES CFOP (ID)
);