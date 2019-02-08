
DROP DATABASE IF EXISTS jt35;
CREATE DATABASE jt35 DEFAULT CHARACTER SET utf8;
USE jt35;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
   u_id INT PRIMARY KEY AUTO_INCREMENT,
   u_userName VARCHAR(40) NOT NULL UNIQUE,
   u_password VARCHAR(50) NOT NULL,
   u_gender TINYINT,
   u_registeTime DATETIME NOT NULL
);

INSERT INTO t_user VALUES(1001, 'admin', '9999', 1, '1990-5-30');
INSERT INTO t_user(u_username, u_password, u_gender, u_registeTime) 
	VALUES('apple', '9999', 0, '1990-6-30');
INSERT INTO t_user(u_username, u_password, u_gender, u_registeTime) 
	VALUES('cherry', '9999', 0, '1990-7-30');
INSERT INTO t_user(u_username, u_password, u_gender, u_registeTime) 
	VALUES('peach', '9999', 2, '1990-8-30');

/*
	select * from t_user order by u_id;

*/









