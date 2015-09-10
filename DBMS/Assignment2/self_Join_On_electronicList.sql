use electronicList;

SELECT c.id as categoryId, c.name as categoryName, IFNULL(parent1.name,"Top category") as parentName
FROM categories as c LEFT JOIN categories as parent1 ON parent1.id = c.parentId;

SELECT name FROM categories where parentId is null ;