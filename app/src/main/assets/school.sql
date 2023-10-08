--
-- File generated with SQLiteStudio v3.3.3 on Tue Jun 22 11:34:00 2021
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: dbconf
DROP TABLE IF EXISTS dbconf;

CREATE TABLE dbconf (
    id         BIGINT (20)     NOT NULL,
    dkey        VARCHAR (50)    NOT NULL
                                UNIQUE,
    dvalue        VARCHAR (255)   DEFAULT NULL,
    PRIMARY KEY (
        id
    )
);

INSERT INTO dbconf (id,dkey, dvalue) VALUES (1, "version", 1);
COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
