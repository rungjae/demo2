CREATE TABLE users(
    seq bigint NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    passwd varchar(80) NOT NULL,
    login_count int NOT NULL DEFAULT 0,
    last_login_at datetime DEFAULT NULL,
    create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (seq),
CONSTRAINT unq_user_email UNIQUE(email)
);

CREATE TABLE TEST(
    ID INT PRIMARY KEY,
    NAME VARCHAR(255)
);

INSERT INTO users(email, passwd, login_count, last_login_at, create_at) VALUES ('liu.a@aa.com','1234',0,now(),now() );
INSERT INTO users(email, passwd, login_count, last_login_at, create_at) VALUES ('liu.b@aa.com','12345',0,now(),now() );