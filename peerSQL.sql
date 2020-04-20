CREATE TABLE peer.users(
userID INT AUTO_INCREMENT PRIMARY KEY,
userName VARCHAR(255) UNIQUE,
`password` VARCHAR(255),
firstName VARCHAR(255), 
lastName VARCHAR(255)
);

CREATE TABLE peer.products(
productID INT AUTO_INCREMENT PRIMARY KEY,
productName VARCHAR(255),
price DOUBLE,
stock INT
);

CREATE TABLE peer.orders(
orderID INT AUTO_INCREMENT PRIMARY KEY,
productID INT,
userID INT,
quantity INT, 
price DOUBLE,
constraint FOREIGN KEY (productID) references products(productID),
constraint FOREIGN KEY (userID) references users(userID)
);

INSERT INTO peer.users VALUES(0, "hello1", "hi123", "Tinu", "Ologb");
INSERT INTO peer.users VALUES(0, "hello2", "hi321", "Hannah", "Bob");
UPDATE peer.users set lastName="James" WHERE userID=1;


DELETE FROM peer.users WHERE userID=1;
SELECT * FROM peer.users;

