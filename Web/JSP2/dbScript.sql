CREATE DATABASE IF NOT EXISTS user_information;

USE user_information;

CREATE TABLE IF NOT EXISTS registration (
username varchar(30) PRIMARY KEY,
password varchar(30),
email varchar(50) UNIQUE KEY
);

SELECT * FROM registration;

DROP DATABASE user_information;