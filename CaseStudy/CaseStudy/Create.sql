CREATE DATABASE IF NOT EXISTS Vehicle_management_system;
use Vehicle_management_system;

CREATE TABLE IF NOT EXISTS Vehicle 
(
vehicle_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
make VARCHAR(100),
model VARCHAR(100),
engineInCC INT,
fuelCapacity INT,
milage INT,
price DECIMAL,
roadTax DECIMAL,
created_by VARCHAR(100),
created_time TIMESTAMP DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS Car 
(
vehicle_id INT NOT NULL PRIMARY KEY, 
air_Bag BOOLEAN,
air_Conditioner BOOLEAN,
powerSteering BOOLEAN,
CONSTRAINT `car_vehicle_id` FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Bike 
(
vehicle_id INT NOT NULL PRIMARY KEY, 
self_Start BOOLEAN,
helmet_price DECIMAL,
CONSTRAINT `bike_vehicle_id`
FOREIGN KEY (vehicle_id) 
REFERENCES vehicle(vehicle_id) 
ON DELETE CASCADE
);
            
            
