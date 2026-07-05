create table bank_account(
id serial primary key,
name varchar(100) not null,
balance decimal not null
)

insert into bank_account(name,balance) values('Arun',500000),('Aravinthan',200000),('Surya','300000')

select * from bank_account

BEGIN;

update bank_account 
set balance = 400000
where id = 2


ROLLBACK