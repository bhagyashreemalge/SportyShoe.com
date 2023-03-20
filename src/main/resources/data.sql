use sportyshoes;

drop table if exists Admin;
drop table if exists Product;
drop table if exists User;
create table Admin (id integer not null auto_increment, contactNo varchar(255), emailId varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table Product (id integer not null auto_increment, category varchar(255), imgurl varchar(255), name varchar(255), pdescription varchar(255), price integer, primary key (id)) engine=InnoDB;
create table User (id integer not null auto_increment, contactNo varchar(255), emailId varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;

SELECT * FROM sportyshoes.product;

INSERT INTO product (name, pdescription, price, category, imgurl) VALUES ('Nike123', 'While Color Nike123',1000,'sports','https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80');
INSERT INTO product (name, pdescription, price, category, imgurl) VALUES ('Nike1010', 'Black Color NikeUltimate',1500,'sports','https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80');
INSERT INTO product (name, pdescription, price, category, imgurl) VALUES ('NikeUltimate1', 'Red Color NikeUltimate',1200,'sports','https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80');
INSERT INTO product (name, pdescription, price, category, imgurl) VALUES ('Nikepremium', 'While Color NikePremium',2000,'sports','https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80');
INSERT INTO product (name, pdescription, price, category, imgurl) VALUES ('NikeStar', 'While Color Nikestar',800,'sports','https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80');

SELECT * FROM sportyshoes.user;

INSERT INTO user (username, emailId, password, contactNo) VALUES ('Bhagyashree', 'bhagyashree@gmail.com','password123','9937357334');
INSERT INTO user (username, emailId, password, contactNo) VALUES ('rajee', 'rajee@gmail.com','password1234','9937357335');
INSERT INTO user (username, emailId, password, contactNo) VALUES ('nishtha', 'bhagyashree@gmail.com','password1235','9937357336');

SELECT * FROM sportyshoes.admin;

INSERT INTO admin (username, emailId, password, contactNo) VALUES ('admin1', 'admin1@gmail.com','adminpassword','9964735648');
INSERT INTO admin (username, emailId, password, contactNo) VALUES ('admin2', 'admin2@gmail.com','adminpassword','9976546372');