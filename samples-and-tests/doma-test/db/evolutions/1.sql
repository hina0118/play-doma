# Users schema

# --- !Ups

CREATE TABLE User (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    fullname varchar(255) NOT NULL,
    isAdmin boolean NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);
CREATE SEQUENCE UserSeq;

# --- !Downs

DROP TABLE User;
DROP SEQUENCE UserSeq;