CREATE DATABASE University;

USE University;

CREATE TABLE user (
  userId int AUTO_INCREMENT PRIMARY KEY,
  name varchar(50),
  email varchar(50) NOT NULL,  
  pwd varchar(50) NOT NULL
);

INSERT INTO user (name, email, pwd)
VALUES ('Braulio', 'brav88@hotmail.com', 'Admin$1234');