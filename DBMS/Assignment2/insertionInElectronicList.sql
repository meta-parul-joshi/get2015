-- insert top category
INSERT INTO categories (id,name) VALUES (1,"Mobiles & Tabletes");

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Mobiles",1);

-- insert last category
INSERT INTO categories (name,parentId) VALUES ("Smart phones",2);
INSERT INTO categories (name,parentId) VALUES ("Featured phones",2);

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Tablets",1);

-- insert last category
INSERT INTO categories (name,parentId) VALUES ("2G",5);
INSERT INTO categories (name,parentId) VALUES ("3G",5);

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Accessories",1);
INSERT INTO categories (name,parentId) VALUES ("Cases and covers",1);

-- insert top category
INSERT INTO categories (name) VALUES ("Computer");

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Desktop",10);
INSERT INTO categories (name,parentId) VALUES ("Laptop",10);
INSERT INTO categories (name,parentId) VALUES ("Laptop Accessories",10);

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Keyboard",13);
INSERT INTO categories (name,parentId) VALUES ("Mouse",13);
INSERT INTO categories (name,parentId) VALUES ("Headphone",13);

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Printers",10);

-- insert last category
INSERT INTO categories (name,parentId) VALUES ("Inkjet",17);
INSERT INTO categories (name,parentId) VALUES ("Laser",17);

-- insert top category
INSERT INTO categories (name) VALUES ("Home Appliances");

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("TVs",20);

-- insert last category
INSERT INTO categories (name,parentId) VALUES ("LED",21);
INSERT INTO categories (name,parentId) VALUES ("LCD",21);
INSERT INTO categories (name,parentId) VALUES ("PLASMA",21);

-- insert sub category
INSERT INTO categories (name,parentId) VALUES ("Air conditinors",20);
INSERT INTO categories (name,parentId) VALUES ("Washing machines",20);

-- insert last category
INSERT INTO categories (name,parentId) VALUES ("Full Automatic",26);

-- insert last sub category
INSERT INTO categories (name,parentId) VALUES ("Top load",27);
INSERT INTO categories (name,parentId) VALUES ("Front Load",27);

-- insert last category
INSERT INTO categories (name,parentId) VALUES ("Semi Automatic",26);