-- Creating Database zipcodeInfo
CREATE DATABASE zipcodeInfo;
USE zipcodeInfo;

-- creating table Zipcode
 CREATE TABLE zipcodeNumber
(
zipcode int PRIMARY KEY AUTO_INCREMENT
);

-- Creating table cityInfo
CREATE TABLE cityInfo
(
zipcode int AUTO_INCREMENT,
cityName varchar(20),
PRIMARY KEY (zipcode,cityName),
FOREIGN KEY (zipcode) REFERENCES zipcodeNumber(zipcode) 
);

-- Creating table stateInfo
CREATE TABLE stateInfo
(
zipcode int AUTO_INCREMENT ,
stateName varchar(20),
PRIMARY KEY (zipcode,stateName),
FOREIGN KEY (zipcode) REFERENCES zipcodeNumber(zipcode) 
);
 

 
 
 
 
 
 