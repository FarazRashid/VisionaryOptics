create database VisionaryOptics;
use VisionaryOptics;

create table Customer(
	customerId INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    phoneNumber varchar(13) NOT NULL,
    email varchar(255) NOT NULL
);

create table Cart(
	cartId int auto_increment primary key,
    totalAmount INT
);

create table CustomerCart(
	customerCartId INT auto_increment Primary Key,
	customerId INT,
    cartId INT,
    foreign key (customerId) references Customer(customerId),
	foreign key (cartId) references Cart(cartId)
);

create table Products(
	productId INT auto_increment Primary key,
    type varchar(255) NOT NULL,
	category varchar(255) NOT NULL,
    price INT not null,
    description varchar(255) not null,
    quantity int
);


create table CartProduct(
	cartProductId INT auto_increment Primary key,
    cartId INT not null,
	productId INT not null,
    foreign key(productId) references Products(productId),
    foreign key(cartId) references Cart(cartId)
);

INSERT INTO Customer (name, password, address, phoneNumber, email) VALUES
('Ahmad Hassan', 'ahmad1234', 'Johar Town', '+923249086713', 'ahmadHassan@gmail.com'),
('Fatima Ali', 'fatima5678', 'Gulberg', '+923335678901', 'fatimaAli@yahoo.com'),
('Ali Khan', 'ali786', 'Model Town', '+923112345678', 'aliKhan@hotmail.com'),
('Saba Ahmed', 'saba999', 'DHA Lahore', '+923004567890', 'sabaAhmed@gmail.com'),
('Imran Malik', 'imran777', 'Township', '+923157890123', 'imranMalik@gmail.com');

INSERT INTO Cart (totalAmount) VALUES
(0),
(0),
(0);

INSERT INTO CustomerCart (customerId, cartId) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO Products (type, category, price, description, quantity) VALUES
('Eyeglasses', 'Reading Glasses', 20, 'Classic reading glasses for clear vision', 50),
('Contact Lenses', 'Daily Disposable', 35, 'Daily disposable contact lenses for convenience', 150),
('Lens Care', 'Cleaning Solution', 10, 'Lens cleaning solution for maintaining hygiene', 100),
('Glasses Protection', 'Lens Cases', 5, 'Protective cases for storing glasses', 200),
('Sunglasses', 'Sports Sunglasses', 70, 'Sports sunglasses with polarized lenses', 80),
('Glasses', 'Fashion Eyeglasses', 60, 'Trendy fashion eyeglasses for everyday style', 75),
('Sunglasses', 'Aviator Sunglasses', 45, 'Classic aviator sunglasses for a cool look', 90),
('Eyeglasses', 'Computer Glasses', 25, 'Computer glasses to reduce eye strain', 60),
('Glasses Protection', 'Lens Cleaning Wipes', 8, 'Disposable wipes for quick and easy lens cleaning', 150),
('Sunglasses', 'Polarized Sport Sunglasses', 80, 'Polarized sunglasses for outdoor sports activities', 40);

INSERT INTO CartProduct (cartId, productId) VALUES
(1, 1),
(1, 2),
(1, 3);

UPDATE Cart
SET totalAmount = (
    SELECT SUM(Products.price)
    FROM CartProduct
    INNER JOIN Products ON CartProduct.productId = Products.productId
    WHERE CartProduct.cartId = 1
)
WHERE cartId = 1;

ALTER TABLE CartProduct
ADD COLUMN quantity INT NOT NULL DEFAULT 1;

UPDATE CartProduct
SET quantity = 1
WHERE cartId = 1;

