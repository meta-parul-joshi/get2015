CREATE DATABASE IF NOT EXISTS Library_Information_System;

USE Library_Information_System;

CREATE TABLE IF NOT EXISTS Members(
member_Id INT NOT NULL AUTO_INCREMENT,
member_name VARCHAR(30),
address_line1 VARCHAR(30),
address_line2 VARCHAR(30),   
category CHAR(1) CHECK(category IN('M','F')),
PRIMARY KEY (member_Id)
);

CREATE TABLE IF NOT EXISTS subjects(
subject_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
subject_name VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS publishers(
publisher_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
publisher_name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS author(
author_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
author_name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS titles(
title_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
title_name VARCHAR(20),
subject_Id INT NOT NULL,
publisher_Id INT NOT NULL,
FOREIGN KEY (subject_Id)
REFERENCES  subjects(subject_Id) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `publisher_id_title` FOREIGN KEY (publisher_Id)
REFERENCES publishers(publisher_Id)
ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS Book(
accession_number INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
price INT NOT NULL,
status BIT(1) CHECK(BIT IN('1','0')),
title_Id INT NOT NULL,
FOREIGN KEY (title_Id)
REFERENCES titles(title_Id)
ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS title_author(
title_Id INT NOT NULL,
author_Id INT NOT NULL,
FOREIGN KEY (title_Id)
REFERENCES titles(title_Id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (author_Id)
REFERENCES author(author_Id)
ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS book_return(
return_date TIMESTAMP,
accession_number INT NOT NULL,
member_Id INT NOT NULL,
issue_date TIMESTAMP,
PRIMARY KEY(return_date,accession_number,member_Id),
FOREIGN KEY (accession_number)
REFERENCES Book(accession_number) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `member_id_return` FOREIGN KEY (member_Id)
REFERENCES Members(member_Id)
ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS book_issue(
issue_date TIMESTAMP,
accession_number INT NOT NULL,
member_Id INT NOT NULL,
due_date TIMESTAMP,
PRIMARY KEY(issue_date,accession_number,member_Id),
FOREIGN KEY (accession_number)
REFERENCES Book(accession_number) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `member_id_issue` FOREIGN KEY (member_Id) 
REFERENCES Members(member_Id)
ON DELETE CASCADE ON UPDATE CASCADE);
