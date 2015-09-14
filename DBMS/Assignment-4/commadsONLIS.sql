USE Library_Information_System;

-- Question-1

SELECT member_name
FROM members 
WHERE category = 
(
    SELECT category 
    FROM members
    WHERE member_name = "Keshav Sharma"
);

-- Question-2

SELECT * FROM book_issue;
SELECT * FROM book_return;

SELECT bi.issue_date , t.title_name , m.member_name , bi.due_date 
FROM book_issue bi 
INNER JOIN Members m ON m.member_id = bi.member_id
INNER JOIN Book b ON bi.accession_number = b.accession_number
INNER JOIN titles t ON t.title_id = b.title_id
WHERE 
NOT EXISTS 
( 
    SELECT member_id , issue_date , accession_number 
    FROM book_return
    WHERE issue_date = bi.issue_date
    AND member_id = bi.member_id
    AND accession_number = bi.accession_number
);

-- Question-3

SELECT bi.issue_date,t.title_name,m.member_name,bi.due_date
FROM book_issue bi
INNER JOIN BOOK B ON bi.accession_number = b.accession_number
INNER JOIN titles t ON t.title_id = b.title_id 
INNER JOIN members m ON m.member_id = bi.member_id
WHERE EXISTS 
(
    SELECT member_id,issue_date,accession_number 
    FROM book_return 
    WHERE DATEDIFF(return_date,bi.due_date)>0 
    AND member_id = bi.member_id 
    AND accession_number = bi.accession_number
);


-- Question-4

SELECT accession_number , title_Id , purchased_date , price , status  FROM book WHERE PRICE = 
(
    SELECT MAX(price) 
    FROM book
);

-- Question-5

SELECT MAX(price) as secondPrice 
FROM book 
WHERE price != 
(
    SELECT MAX(price) 
    FROM book
);

