CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    salary DECIMAL(10,2)
);

INSERT INTO employees VALUES
(101,'Arun',15000),
(102,'Karthik',18000),
(103,'Rahul',12000);



CREATE OR REPLACE FUNCTION check_insert_salary()
RETURNS TRIGGER
LANGUAGE plpgsql
AS
$$
BEGIN

    IF NEW.salary < 10000 THEN
        NEW.salary := 10000;
    END IF;

    RETURN NEW;

END;
$$;

CREATE TRIGGER before_insert_employee
BEFORE INSERT
ON employees
FOR EACH ROW
EXECUTE FUNCTION check_insert_salary();


CREATE OR REPLACE FUNCTION check_update_salary()
RETURNS TRIGGER
LANGUAGE plpgsql
AS
$$
BEGIN

    IF NEW.salary < 10000 THEN
        RAISE EXCEPTION 'Salary cannot be less than 10000';
    END IF;

    RETURN NEW;

END;
$$;

CREATE TRIGGER before_update_employee
BEFORE UPDATE
ON employees
FOR EACH ROW
EXECUTE FUNCTION check_update_salary();


CREATE OR REPLACE PROCEDURE employee_menu(

    p_choice INT,
    p_emp_id INT,
    p_emp_name VARCHAR,
    p_salary NUMERIC

)
LANGUAGE plpgsql
AS
$$
BEGIN

    IF p_choice = 1 THEN

        INSERT INTO employees(emp_id,emp_name,salary)
        VALUES(p_emp_id,p_emp_name,p_salary);

        RAISE NOTICE 'Employee Inserted Successfully';

    ELSIF p_choice = 2 THEN

        UPDATE employees
        SET salary = p_salary
        WHERE emp_id = p_emp_id;

        RAISE NOTICE 'Salary Updated Successfully';

    ELSIF p_choice = 3 THEN

        DELETE FROM employees
        WHERE emp_id = p_emp_id;

        RAISE NOTICE 'Employee Deleted Successfully';

    ELSIF p_choice = 4 THEN

        RAISE NOTICE 'Employee Records';

    ELSIF p_choice = 5 THEN

        RAISE NOTICE 'Program Exited';

    ELSE

        RAISE NOTICE 'Invalid Choice';

    END IF;

END;
$$;



CALL employee_menu(
1,
104,
'Priya',
8000
);

CALL employee_menu(
2,
101,
NULL,
20000
);

CALL employee_menu(
2,
101,
NULL,
9000
);

CALL employee_menu(
3,
103,
NULL,
NULL
);

SELECT * FROM employees;