ALTER TABLE titles DROP FOREIGN KEY  `publisher_id_title` ;

Delete From publishers;
SELECT* FROM publishers;


DELETE FROM titles WHERE publisher_Id = 1;
SELECT * FROM titles;


SET @first_publisher = "NK";
SET @first_publisher_Id = "1";
INSERT INTO publishers VALUES(@first_publisher_Id,@first_publisher);
select * FROM publishers;