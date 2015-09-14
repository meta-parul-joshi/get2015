USE Library_Information_System;

-- Question-1

CREATE VIEW MemberBooksIssueDetails
AS
SELECT m.member_name, bi.issue_date,bi.accession_number,bi.member_Id,bi.due_date 
FROM Book_issue bi
INNER JOIN Members m
ON m.member_id = bi.member_id;

SELECT * FROM MemberBooksIssueDetails;

-- Question-2

CREATE VIEW MemberCategoryDetails
AS
SELECT m1.member_name, m1.member_id, 
CASE m1.category 
WHEN 'F' THEN "Faculty"
WHEN 'M' THEN "Mentor"
ELSE "Others" 
END 
AS categoryDescription 
FROM Members m1;
 
SELECT * FROM MemberCategoryDetails;

-- Question-3

CREATE VIEW returnDetailsOfBook
AS
SELECT s.subject_name, m.member_name, m.category, bi.issue_date, bi.due_date, br.return_date  
FROM Book_return br
RIGHT JOIN Book_issue bi ON br.member_id = bi.member_id 
INNER JOIN Members m ON m.member_id = bi.member_id
INNER JOIN Book b ON bi.accession_number = b.accession_number
INNER JOIN titles t ON t.title_id = b.title_id
INNER JOIN Subjects s ON s.subject_id = t.subject_id
;


SELECT * FROM returnDetailsOfBook;