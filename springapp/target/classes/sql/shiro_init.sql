CREATE DATABASE IF NOT EXISTS spring
    DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;

SHOW VARIABLES LIKE 'character%';
SHOW VARIABLES LIKE '%time_zone%';

DROP TABLE session;

CREATE TABLE IF NOT EXISTS session
(
    `ID`        int(11) NOT NULL AUTO_INCREMENT,
    `SESSIONID` text    NOT NULL,
    `SESSION`   text    NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE user;
CREATE TABLE IF NOT EXISTS user
(
    `ID`       int(11)      NOT NULL AUTO_INCREMENT,
    `NAME`     varchar(500) NOT NULL,
    `PASSWORD` varchar(500) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE role;
CREATE TABLE IF NOT EXISTS role
(
    `ID`   int(11)      NOT NULL AUTO_INCREMENT,
    `NAME` varchar(500) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE permissions;
CREATE TABLE IF NOT EXISTS permissions
(
    `ID`   int(11)      NOT NULL AUTO_INCREMENT,
    `NAME` varchar(500) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE user_role;
CREATE TABLE IF NOT EXISTS user_role
(
    `ID`      int(11) NOT NULL AUTO_INCREMENT,
    `USER_ID` int(11) NOT NULL,
    `ROLE_ID` int(11) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE user_session;
CREATE TABLE IF NOT EXISTS user_session
(
    `ID`      int(11) NOT NULL AUTO_INCREMENT,
    `USER_ID` int(11) NOT NULL,
    `SESSION_ID` int(11) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE role_permissions;
CREATE TABLE IF NOT EXISTS role_permissions
(
    `ID`             int(11) NOT NULL AUTO_INCREMENT,
    `ROLE_ID`        int(11) NOT NULL,
    `PERMISSIONS_ID` int(11) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO user(id, name, password) VALUES (1,'pcl','123456');
INSERT INTO user(id, name, password) VALUES (2,'lyf','123456');

INSERT INTO role(id, name) VALUES (1,'admin');
INSERT INTO role(id, name) VALUES (2,'inquirer');

INSERT INTO permissions(ID, NAME) VALUES (1,'select');
INSERT INTO permissions(id, name) VALUES (2,'create');
INSERT INTO permissions(id, name) VALUES (3,'delete');
INSERT INTO permissions(id, name) VALUES (4,'update');


INSERT INTO user_role(id, USER_ID, role_id) VALUES (1,1,1);
INSERT INTO user_role(ID, USER_ID, ROLE_ID) VALUES (2,2,2);
INSERT INTO user_role(id, USER_ID, role_id) VALUES (3,1,2);


INSERT INTO role_permissions(id, role_id, permissions_id) VALUES (1,1,1);
INSERT INTO role_permissions(id, role_id, permissions_id) VALUES (2,1,2);
INSERT INTO role_permissions(id, role_id, permissions_id) VALUES (3,1,3);
INSERT INTO role_permissions(id, role_id, permissions_id) VALUES (4,1,4);
INSERT INTO role_permissions(id, role_id, permissions_id) VALUES (5,2,1);