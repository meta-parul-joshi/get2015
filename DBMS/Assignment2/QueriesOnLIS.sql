USE Library_Information_System;

SELECT * FROM members;

INSERT INTO Members VALUES (3,"Parul","Sector 13","Udaipur","F");
INSERT INTO Members VALUES (4,"Manish","Sector 14","Kota","M");
INSERT INTO Members VALUES (5,"Hemant","Sector 14","Kota","F");

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


SELECT b.accession_number,b.member_id,b.issue_date,IFNULL(r.return_date,"  ")  as returnDate 
FROM book_issue b
LEFT outer JOIN book_return r ON b.accession_number = r.accession_number AND b.member_Id= r.member_Id;

SELECT b.issue_date,b.accession_number,b.member_id,IFNULL(r.return_date,"") as Return_Date ,m.member_name
FROM book_issue b
LEFT OUTER Join book_return r ON 
b.accession_number = r.accession_number AND 
b.member_id= r.member_id 
INNER JOIN members m ON m.member_id = b.member_id ORDER BY m.member_name , issue_date; 


