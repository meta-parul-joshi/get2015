-- creating database electroniclist
CREATE DATABASE IF NOT EXISTS electronicList;
USE electronicList;

-- Creating table categories 
CREATE TABLE categories
(
id INT AUTO_INCREMENT  NOT NULL  PRIMARY KEY , 
name VARCHAR(30) NOT NULL,
parentId INT NULL,
FOREIGN KEY (parentid)  REFERENCES categories (id)
);