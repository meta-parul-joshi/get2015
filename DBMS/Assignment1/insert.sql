INSERT INTO members VALUES(1,"PARUL","PATHIK NAGAR","BHILWARA","F");
INSERT INTO members VALUES(2,"KAJAL","SITAPURA","JAIPUR","F");
SELECT* FROM members;

INSERT INTO subjects VALUES(1,"SQL");
INSERT INTO subjects VALUES(2,"JAVA");
SELECT* FROM subjects;

INSERT INTO publishers VALUES(1,"NK");
INSERT INTO publishers VALUES(2,"TMH");
SELECT* FROM publishers;

INSERT INTO author VALUES(1,"MANISH");
INSERT INTO author VALUES(2,"HEMANT");
SELECT* FROM author;

INSERT INTO titles VALUES(1,"Complete reference",1,1);
INSERT INTO titles VALUES(2,"Reference",2,2);
SELECT* FROM titles;
INSERT INTO Book VALUES(1,100,1,1);
INSERT INTO Book VALUES(2,200,0,2);
SELECT* FROM Book;

INSERT INTO title_author VALUES(1,1);
INSERT INTO title_author VALUES(2,2);
SELECT* FROM title_author;

INSERT INTO book_issue (accession_number,member_Id)VALUES(1,1);
INSERT INTO book_issue (accession_number,member_Id)VALUES(2,2);
SELECT* FROM book_issue;

INSERT INTO book_return (return_date,accession_number,member_Id,issue_date)VALUES("2015-09-23 17:02:35",1,1,"2015-09-08 17:02:35");
INSERT INTO book_return (return_date,accession_number,member_Id,issue_date)VALUES("2015-09-23 17:02:35",2,2,"2015-09-08 17:02:35");
SELECT* FROM book_return;


SET SQL_SAFE_UPDATES = 0;
UPDATE members 
SET address_linr2 = "Jaipur";
SELECT* FROM members;

SET SQL_SAFE_UPDATES = 0;
UPDATE members 
SET address_line1 = "EPIP SITAPURA"
WHERE category = "F";
SELECT* FROM members;