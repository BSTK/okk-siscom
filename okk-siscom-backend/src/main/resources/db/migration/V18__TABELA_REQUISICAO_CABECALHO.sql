CREATE SEQUENCE SEQUENCE_REQUISICAO_CABECALHO START WITH 1 INCREMENT BY 1;

-- TODO: FAZER RELACIONAMENTO COM TABELA DE USUÁRIO
CREATE TABLE REQUISICAO_CABECALHO
(
    ID              NUMBER NOT NULL,
    DATA_REQUISICAO DATE   NOT NULL,
    DATA_INSERT     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    DATA_UPDATE     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);