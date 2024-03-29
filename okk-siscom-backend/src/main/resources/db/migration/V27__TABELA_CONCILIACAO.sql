CREATE SEQUENCE SEQUENCE_CONCILIACAO START WITH 1 INCREMENT BY 1;

CREATE TABLE CONCILIACAO
(
    ID          NUMBER         NOT NULL,
    MES         CHAR(2)        NOT NULL,
    ANO         CHAR(4)        NOT NULL,
    VALOR       DECIMAL(10, 2) NOT NULL,
    HISTORICO   VARCHAR2(100),
    DATA_INSERT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    DATA_UPDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);