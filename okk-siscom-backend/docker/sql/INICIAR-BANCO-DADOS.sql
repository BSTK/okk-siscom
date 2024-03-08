ALTER SESSION SET CONTAINER = ORCLPDB1;

CREATE USER "okksiscomdb" IDENTIFIED BY "okksiscomdb";

GRANT CONNECT, RESOURCE TO "okksiscomdb";
GRANT CREATE SESSION, CREATE VIEW, CREATE TABLE, ALTER SESSION, CREATE SEQUENCE, CREATE PROCEDURE, CREATE TRIGGER TO "okksiscomdb";
GRANT CREATE SYNONYM, CREATE DATABASE LINK, UNLIMITED TABLESPACE TO "okksiscomdb";
COMMIT;
