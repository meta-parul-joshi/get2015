
 -- Inserting values in stateInfo table
INSERT INTO stateInfo(stateId,stateName) VALUES (1,"UP");
INSERT INTO stateInfo(stateName) VALUES ("Rajasthan");
INSERT INTO stateInfo(stateName) VALUES ("Delhi");
 
  -- Inserting values in cityInfo table
INSERT INTO cityInfo(cityId,cityName,stateId) VALUES (1,"Bareilly",1);
INSERT INTO cityInfo(cityName,stateId) VALUES ("Jaipur",2);
INSERT INTO cityInfo(cityName,stateId) VALUES ("Noida",3);
INSERT INTO cityInfo(cityName,stateId) VALUES ("Bhilwara",2);
INSERT INTO cityInfo(cityName,stateId) VALUES ("Ajmer",2);

 -- Inserting values in zipcodeNumber table
INSERT INTO zipcodeNumber(zipId,zipcode,cityid) VALUES (1,576589,1);
INSERT INTO zipcodeNumber(zipcode,cityid) VALUES (302020,2);
INSERT INTO zipcodeNumber(zipcode,cityid) VALUES (300001,4);
INSERT INTO zipcodeNumber(zipcode,cityid) VALUES (300201,5);
INSERT INTO zipcodeNumber(zipcode,cityid) VALUES (302022,3);
 
 SELECT * FROM stateInfo;
 SELECT * FROM cityInfo;
 SELECT * FROM zipcodenumber;

 -- Query to find the zip code city name and stateName
SELECT stateName,cityName,z.zipcode  From zipcodeNumber z 
INNER JOIN cityInfo c on z.cityId = c.cityId
INNER JOIN stateInfo s ON c.stateId = s.stateId
ORDER BY stateName asc , cityName asc;

 -- DROP DATABASE zipcodeInfo;