create table employee(
	emp_id SERIAL PRIMARY KEY,
    emp_name VARCHAR(100),
    salary DECIMAL(10,2),
    department VARCHAR(50)
)

insert into employee(emp_name,salary,department) values('Vishwa',30000,'Medical'),('Sabari',40000,'studio'),('nishanth',40000,'IT')

create view employee_name_view 
as select emp_id,emp_name,salary from employee


select * from employee_name_view

update employee_name_view 
set salary = 50000
where emp_id = 1

drop view employee_name_view