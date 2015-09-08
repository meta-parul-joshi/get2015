ALTER TABLE titles DROP FOREIGN KEY  `publisher_id_title` ;

TRUNCATE TABLE publishers;
SELECT* FROM publishers;
SELECT * FROM titles;

DELETE FROM titles WHERE publisher_Id = 1;
SELECT * FROM titles;


SET @first_publisher = "NK";
SET @first_publisher_Id = "1";
INSERT INTO publishers VALUES(@first_publisher_Id,@first_publisher);
select * FROM publishers;