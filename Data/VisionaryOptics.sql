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
    quantitiy int
);

create table CartProduct(
	cartProductId INT auto_increment Primary key,
    productId INT not null,
    cartId INT not null,
    foreign key(productId) references Products(productId),
    foreign key(cartId) references Cart(cartId)
);


