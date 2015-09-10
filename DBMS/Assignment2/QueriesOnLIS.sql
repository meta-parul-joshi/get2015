USE Library_Information_System;

SELECT * FROM members;

INSERT INTO Members VALUES (1,"Parul","Sector 13","Udaipur","F");
INSERT INTO Members VALUES (2,"Manish","Sector 14","Kota","M");
INSERT INTO Members VALUES (3,"Hemant","Sector 14","Kota","F");

SELECT * FROM members;

SELECT member_Id,member_name,category FROM members;

SELECT member_Id,member_name,category FROM members WHERE category = "F";

SELECT DISTINCT category FROM members;

SELECT member_name,category FROM members ORDER BY member_name DESC;

SELECT T.title_name, S.subject_name, P.publisher_name
FROM titles T
INNER JOIN subjects S ON T.subject_id = S.subject_id
INNER JOIN publishers P ON T.publisher_id = P.publisher_id;

SELECT category, count(category) from Members group by category;

INSERT INTO Members VALUES (6,"Keshav Sharma","Sector 14","Kota","M");

SELECT m.member_name 
FROM Members m 
INNER JOIN Members m1 ON m.category=m1.category 
AND m1.member_name="Keshav Sharma";

SET SQL_SAFE_UPDATES = 0;
UPDATE book_return 
SET return_date = "0000-00-00 00:00:00"
WHERE accession_number = "1";

SELECT accession_number AS Acc_no ,member_id AS Mem_id,issue_date AS Iss_d,return_date AS Ret_d FROM book_return;

SELECT m.member_name as m_name,b.accession_number AS Acc_no ,b.member_id AS Mem_id, b.issue_date AS Iss_d,b.return_date AS Ret_d 
FROM book_return b INNER JOIN members m  ON m.member_id = b.member_id ORDER BY issue_date , m.member_name;


