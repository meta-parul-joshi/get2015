-- Creating Database zipcodeInfo
CREATE DATABASE IF NOT EXISTS zipcodeInfo;

USE zipcodeInfo;

-- Creating table stateInfo
CREATE TABLE IF NOT EXISTS stateInfo
(
    stateId INT NOT NULL AUTO_INCREMENT PRIMARY kEY,
    stateName varchar(100)
);

-- Creating table cityInfo
CREATE TABLE IF NOT EXISTS cityInfo
(
    cityId INT NOT NULL AUTO_INCREMENT,
    cityName varchar(100),
    stateId INT NOT NULL,
    PRIMARY KEY (cityId),
    FOREIGN KEY (stateId) REFERENCES stateInfo(stateId) 
);

-- creating table Zipcode
CREATE TABLE IF NOT EXISTS zipcodeNumber
(
    zipId INT NOT NULL AUTO_INCREMENT,
    zipcode INT NOT NULL,
    cityId INT NOT NULL,
    PRIMARY KEY (zipId),
    FOREIGN KEY (cityId) REFERENCES cityInfo(cityId)
);


 

 
 
 
 
 
 