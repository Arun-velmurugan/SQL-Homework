Create Database school
create table student(id int AUTO_INCREMENT primary key,name varchar(50) not null, email varchar(50) not null unique,course varchar(30) not null,
fee double not null)

SET SQL_SAFE_UPDATES = 0;