use electronicList;

SELECT c.id as categoryId, c.name as categoryName, IFNULL(parent1.name,"Top category") as parent1,
parent2.name as parent2,parent3.name as parent3 
FROM categories as c LEFT OUTER JOIN categories as parent1 ON parent1.id = c.parentId
LEFT OUTER JOIN categories as parent2 ON parent2.id = parent1.parentId
LEFT OUTER JOIN categories parent3 ON parent3.id = parent2.parentId;


SELECT name FROM categories where parentId is null ;