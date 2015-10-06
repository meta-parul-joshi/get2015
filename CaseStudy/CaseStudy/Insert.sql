use Vehicle_management_system;

show tables;

INSERT INTO Vehicle(vehicle_id,make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) 
VALUES (1,"make1","model1",10,11,12,750000,5000,"user1");

INSERT INTO Vehicle(make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) 
VALUES ("make2","model2",20,21,22,600000,2000,"user2");

INSERT INTO Vehicle(make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) 
VALUES ("make3","model3",30,31,32,850000,7000,"user3");

INSERT INTO Vehicle(make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) 
VALUES ("make4","model4",8,10,20,50000,1000,"user4");

INSERT INTO Vehicle(make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) 
VALUES ("make5","model5",9,11,21,50000,1000,"user5");

INSERT INTO Vehicle(make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) 
VALUES ("make6","model6",8,10,20,50000,1000,"user6");

INSERT INTO Car(vehicle_id,air_Bag,air_Conditioner,powerSteering) 
VALUES (1,true,true,true);

INSERT INTO Car(vehicle_id,air_Bag,air_Conditioner,powerSteering) 
VALUES (2,false,true,true);


INSERT INTO Car(vehicle_id,air_Bag,air_Conditioner,powerSteering) 
VALUES (3,true,true,false);

INSERT INTO Bike(vehicle_id,self_Start,helmet_price) 
VALUES (4,true,1200);

INSERT INTO Bike(vehicle_id,self_Start,helmet_price) 
VALUES (5,false,1500);

INSERT INTO Bike(vehicle_id,self_Start,helmet_price) 
VALUES (6,false,1500);

SELECT * FROM vehicle;
SELECT * FROM car;
SELECT * FROM bike;
