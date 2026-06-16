create table departments(dept_id serial primary key,dept_name VARCHAR(100))

create table employees(emp_id serial primary Key,emp_name VARCHAR(100),dept_id int,salary decimal,
Foreign Key (dept_id)
references departments(dept_id)
)

INSERT INTO departments(dept_name) values('HR'),('DEVELOPER'),('MANAGER'),('MARKETING'),('SALES')

INSERT INTO employees(emp_name,dept_id,salary)values('Vishwa',1,40000),('Surya',2,35000),('Aravinthan',3,50000),('Avinash',4,70000),('kamalesh',5,30000)

Insert into employees(emp_name,dept_id,salary)values('Balaji',1,45000)

select e.emp_name,d.dept_name,e.salary
from employees e,departments d
where e.dept_id=d.dept_id
AND e.salary>30000 and d.dept_name = 'HR'