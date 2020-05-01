CREATE DATABASE IF NOT EXISTS shoestore CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci';
use shoestore;

CREATE TABLE Categories
(
	CategoryId INTEGER NOT NULL PRIMARY KEY auto_increment,
	Name VARCHAR(255) NULL
);

CREATE TABLE Products
(
	ProductId INTEGER NOT NULL PRIMARY KEY auto_increment,
	Name VARCHAR(255) CHARACTER SET 'utf8mb4'  NULL ,
    Image VARCHAR(255) NULL,
    Quantity INTEGER NULL,
    Price DOUBLE NULL,
    ManufacturedDate DATE NULL,
    Status VARCHAR(20) CHARACTER SET 'utf8mb4' NULL,
    CategoryId INTEGER NOT NULL,
    Description TEXT CHARACTER SET 'utf8mb4' null
);

CREATE TABLE CartDetails
(
	CartDetailId INTEGER NOT NULL PRIMARY KEY auto_increment,
	CartId INTEGER NOT NULL,
    ProductId INTEGER NOT NULL,
    Quantity INTEGER NULL,
    Price DOUBLE NULL,
	Note VARCHAR(255) CHARACTER SET 'utf8mb4' null
);

CREATE TABLE Carts
(
	CartId INTEGER NOT NULL PRIMARY KEY auto_increment,
    CustomerId VARCHAR(50) NOT NULL,
    CreateDate DATE NULL,
    Total DOUBLE NULL,
    Status VARCHAR(30) CHARACTER SET 'utf8mb4' NULL
);

CREATE TABLE Customers 
(
	CustomerId NVARCHAR(50) NOT NULL PRIMARY KEY,
    Name VARCHAR(50) CHARACTER SET 'utf8mb4'  NULL,
    Gender BOOLEAN NULL,
    DOB DATE NULL,
    Email VARCHAR(255) NULL,
    Phone VARCHAR(30) NULL,
    Password NVARCHAR(30) NULL,
    RoleId Integer NOT NULL,
    RegistereroledDate DATE NULL
);
CREATE TABLE Role
(
	RoleId INTEGER NOT NULL PRIMARY KEY auto_increment,
    Name NVARCHAR(50) NULL
);
-- insert role
insert into role values(1,'admin');
insert into role values(1,'user');

-- insert customer
insert into customers values('admin','Nguyễn Huy Hoàng',1,'1996-05-06','hoangnhph09158@gmail.com','0985224906','$2a$10$zj4GUovwPqhlhQ.tSOp66OW15Ms52R9n8Wu8JTQJ5L9ziRXaLREYK',1,'2020-04-28');
insert into customers values('dongnt','Nguyễn Thành Đồng',1,'2000-01-01','dongnt@gmail.com','0934521678','$2a$10$UKPVDGebr1xjtTpnhbXu1e6Uss66Ac9GAUci6YpJUz0EtZddy0Z7a',2,'2020-04-28');
-- insert categories
insert into categories values(1,'Men');
insert into categories values(2,'Women');
-- insert product
insert into products values(1,'edge-xt-shoes','edge-xt-shoes.jpg',15,180.0,'2020-05-01','in stock',1,'running');
insert into products values(2,'4d-run-1.0-ltd-shoes','4d-run-1.0-ltd-shoes.jpg',15,200,'2020-05-01','in stock',2,'running');
insert into products values(3,'sl20-shoes','sl20-shoes.jpg',15,180.0,'2020-05-01','in stock',1,'running');
insert into products values(4,'alphaboost-shoes','alphaboost-shoes.jpg',40,180.0,'2020-05-01','in stock',1,'running');
insert into products values(5,'edge-gameday-shoes','edge-gameday-shoes.jpg',50,180.0,'2020-05-01','in stock',2,'running');
insert into products values(6,'response-trail-shoes','response-trail-shoes.jpg',20,220.0,'2020-05-01','in stock',1,'running');

-- insert cart
insert into carts values(1,'admin','2020-04-28',30,null);
insert into carts values(2,'dongnt','2020-04-28',769,null);

-- insert cartdetails
insert into cartdetails values(1,1,1,1,180.0,null);
insert into cartdetails values(2,2,2,1,200.0,null);

ALTER TABLE Products ADD CONSTRAINT fk_Products_Categories FOREIGN KEY(CategoryId) REFERENCES Categories(CategoryId);
ALTER TABLE CartDetails ADD CONSTRAINT fk_CartDetails_Products FOREIGN KEY(ProductId) REFERENCES Products(ProductId);
ALTER TABLE CartDetails ADD CONSTRAINT fk_CartDetails_Carts FOREIGN KEY(CartId) REFERENCES Carts(CartId);
ALTER TABLE Carts ADD CONSTRAINT fk_Carts_Customers FOREIGN KEY(CustomerId) REFERENCES Customers(CustomerId);
ALTER TABLE Customers ADD CONSTRAINT fk_Customers_Role FOREIGN KEY(RoleId) REFERENCES Role(RoleId);
