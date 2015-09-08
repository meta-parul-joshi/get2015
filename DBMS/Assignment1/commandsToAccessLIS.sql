USE Library_Information_System;
SHOW TABLES;
ALTER TABLE book_issue MODIFY COLUMN issue_date TIMESTAMP NOT NULL DEFAULT NOW();
DELIMITER $$

CREATE TRIGGER set_default_duedate 
BEFORE INSERT ON Book_Issue
FOR EACH ROW
BEGIN
 SET NEW.due_date = NOW() + INTERVAL 15 DAY;
END$$

DELIMITER ;

ALTER TABLE book_return DROP FOREIGN KEY  `member_id_return` ;

ALTER TABLE book_issue DROP FOREIGN KEY  `member_id_issue` ;

DROP TABLE members;

SHOW TABLES;
CREATE TABLE IF NOT EXISTS Members(
member_Id INT NOT NULL AUTO_INCREMENT,
member_name VARCHAR(30),
address_line1 VARCHAR(30),
address_linr2 VARCHAR(30),
category VARCHAR(15),
PRIMARY KEY (member_Id)
);
SHOW TABLES;

ALTER TABLE book_return
ADD CONSTRAINT `member_id_return` FOREIGN KEY (member_Id) REFERENCES Members(member_Id);

ALTER TABLE book_issue 
ADD CONSTRAINT `member_id_ISSUE` FOREIGN KEY (member_Id) REFERENCES Members(member_Id);