SELECT member_name, LENGTH(member_name) AS Length FROM members WHERE
LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM Members);

SELECT COUNT(issue_date) FROM book_issue;


SELECT s.subject_id, s.subject_name, COUNT(bo.accession_number) as booksPurchased  
FROM book AS bo
INNER JOIN Titles as t ON bo.title_id = t.title_Id
INNER JOIN Subjects as s ON t.subject_id = s.subject_Id GROUP BY s.subject_Id;


SELECT t.title_name, b.price FROM book AS b
iNNER JOIN titles AS t ON t.title_Id = b.title_Id
WHERE b.price > (SELECT MIN(price) FROM book) ;

SELECT t.title_name 
FROM book_issue as bi
INNER JOIN members as m ON bi.member_Id = m.member_Id
INNER JOIN book as bo ON bi.accession_number= bo.accession_number
INNER JOIN titles as t ON bo.title_Id = t.title_Id
WHERE m.category  != "F";


SELECT a.author_name FROM BOOK B
INNER JOIN titles t ON t.title_Id = b.title_Id
INNER JOIN title_author ta ON ta.title_Id = t.title_Id
INNER JOIN author a ON a.author_Id = ta.author_Id;

SELECT t.title_name 
FROM book_issue as bi
INNER JOIN book as bo ON bi.accession_number= bo.accession_number
INNER JOIN titles as t ON bo.title_Id = t.title_Id
GROUP BY (bo.accession_number) HAVING COUNT(bo.accession_number)>2;

Select count(IF(category="S",category,null)) as Total_Student,
count(IF(category="F",category,null)) as Total_Faculty,
count(IF(category="M",category,null)) as Total_Mentors
from members;

SELECT *,datediff(due_date,issue_date) From book_issue
WHERE datediff(due_date,issue_date)/30 >= 2 ;

SELECT m.member_Id,m.member_name,
t.title_name,
b.accession_number,
bi.issue_date,bi.due_date,
datediff(now(),bi.issue_date)/30 
FROM book_issue bi 
INNER JOIN members m ON bi.member_Id = m.member_Id
INNER JOIN book b ON b.accession_number = bi.accession_number
INNER JOIN titles t ON t.title_ID = b.title_Id
LEFT JOIN book_return br ON br.accession_number = bi.accession_number
AND bi.member_Id  = br.member_Id 
AND (datediff(br.return_date,br.issue_date)/30>2)
WHERE (datediff(now(),bi.issue_date)/30)>2;