 -- Inserting values in zipcodeNumber table
INSERT INTO zipcodeNumber(zipcode) VALUES (311001);
INSERT INTO zipcodeNumber(zipcode) VALUES (311002);
INSERT INTO zipcodeNumber(zipcode) VALUES (311003);
 
 -- Inserting values in cityInfo table
INSERT INTO cityInfo(zipcode,cityName) VALUES (311001,"Bareilly");
INSERT INTO cityInfo(cityName) VALUES ("Jaipur");
INSERT INTO cityInfo(cityName) VALUES ("Noida");
INSERT INTO cityInfo(zipcode,cityName) VALUES (311002,"Bhilwara");
 
 -- Inserting values in stateInfo table
INSERT INTO stateInfo(zipcode,stateName) VALUES (311001,"UP");
INSERT INTO stateInfo(stateName) VALUES ("Rajasthan");
INSERT INTO stateInfo(stateName) VALUES ("Delhi");
 
 
 -- Query to find the zip code city name and stateName
 SELECT z.zipcode,cityName,stateName from zipcodeNumber z, cityInfo c, stateInfo s 
 where ( ( z. zipcode = c.zipcode ) && ( z.zipcode = s.zipcode ) ) ORDER BY stateName asc , cityName asc;

-- DROP DATABASE zipcodeInfo;