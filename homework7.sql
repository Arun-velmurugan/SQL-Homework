create table department(dept_id int primary key,dept_name VARCHAR(100),location VARCHAR(100))

insert into department(dept_id,dept_name,location)  Values(10,'HR','Chennai'),(20,'IT','Madurai'),(30,'Finance','Trichy'),(40,'Sales','Coimbatore')

create table employee(emp_id int primary key,emp_name varchar(100),age smallint,salary decimal,dept_id int,job_role varchar(100),Foreign Key(dept_id) References department(dept_id))

insert into employee(emp_id,emp_name,age,salary,dept_id,job_role) Values(101,'Arun',23,25000,20,'Developer'),(102,'Bala',30,40000,10,'Recruiter'),(103,'Charan',27,35000,20,'Tester'),(104,'Divya',35,50000,30,'Accountant'),(105,'Eswar',29,28000,40,'Sales Executive'),(106,'Farhana',26,32000,20,'Developer'),(107,'Gokul',31,45000,30,'Analyst'),(108,'Hari',24,22000,10,'Assistant')

select e.emp_name,d.dept_name
from employee e
join department d
on e.dept_id = d.dept_id

select e.emp_name,e.salary,d.location
from employee e
join department d
on e.dept_id = d.dept_id


select e.* from employee e
join department d
on e.dept_id = d.dept_id
where d.dept_name = 'IT'

select e.* from employee e
join department d
on e.dept_id = d.dept_id
where d.location = 'Chennai'

select e.emp_name,e.salary,d.dept_name
from employee e
join department d
on e.dept_id = d.dept_id
where e.salary>30000

select count(*),dept_name from employee e
join department d
on e.dept_id = d.dept_id
group by d.dept_name

select count(*),dept_name from employee e
join department d
on d.dept_id = e.dept_id
group by dept_name
having count(*)>1