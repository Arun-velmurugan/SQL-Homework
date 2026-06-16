create table customers(customer_id serial primary key, customer_name VARCHAR(100), city VARCHAR(50))

create table orders(order_id serial primary key, customer_id int,amount decimal,
Foreign  Key(customer_id)
References customers(customer_id))

INSERT INTO customers(customer_name, city)
VALUES
('Arunraj','Virudhachalam'),
('Aravinthan','Chennai'),
('Sabari','Madurai'),
('Surya','Bangalore'),
('Vishwa','Erode')

INSERT INTO orders(customer_id, amount)
VALUES
(1,1000),
(2,2000),
(3,5000),
(4,3000),
(5,10000),
(1,8000)

INSERT INTO orders(customer_id, amount)
VALUES(1,15000)

Select o.order_id,c.customer_name,c.city,o.amount
from customers c,orders o
where c.customer_id = o.customer_id
and o.amount>5000

select * from orders where amount >(select avg(amount) from orders)