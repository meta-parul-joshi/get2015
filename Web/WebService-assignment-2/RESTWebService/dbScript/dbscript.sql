drop database Employee;
create database Employee;
use Employee;
create table employee(
id int auto_increment primary key ,
name varchar(30),
email varchar(100),
address varchar(200)
);



select * from employee;

desc employee;