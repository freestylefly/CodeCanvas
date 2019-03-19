
DROP DATABASE IF EXISTS jt35;
CREATE DATABASE jt35 DEFAULT CHARACTER SET utf8;
USE jt35;

DROP TABLE IF EXISTS t_user;
CREATE TABLE USER(
   id INT PRIMARY KEY AUTO_INCREMENT,
   userName VARCHAR(40) NOT NULL UNIQUE,
   PASSWORD VARCHAR(50) NOT NULL,
   gender TINYINT,
   registeTime DATETIME NOT NULL
);

INSERT INTO USER VALUES(1001, 'admin', '9999', 1, '1990-5-30');
INSERT INTO USER(username, PASSWORD, gender, registeTime) 
	VALUES('apple', '9999', 0, '1990-6-30');
INSERT INTO USER(username, PASSWORD, gender, registeTime) 
	VALUES('cherry', '9999', 0, '1990-7-30');
INSERT INTO USER(username, PASSWORD, gender, registeTime) 
	VALUES('peach', '9999', 2, '1990-8-30');

/*
	select * from user order by id;

*/









