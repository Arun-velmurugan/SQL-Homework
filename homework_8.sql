
create table attendance(
attendance_id serial primary key,
emp_id int,
attendance_date Date,
status Varchar(20));

insert into attendance(emp_id,attendance_date,status) Values(101,'2026-07-01','Present'),
(101, '2026-07-02', 'Absent'),
(101, '2026-07-03', 'Late'),
(102, '2026-07-01', 'Present'),
(102, '2026-07-02', 'Absent'),
(102, '2026-07-03', 'Absent'),
(103, '2026-07-01', 'Late'),
(103, '2026-07-02', 'Present'),
(103, '2026-07-03', 'Absent');

create or replace procedure count_absent_days()
language plpgsql
as $$
Declare rec RECORD;
begin
 For rec in 
 	select emp_id,count(*) as absent_days
	 from attendance where status = 'Absent'
	 Group by emp_id
	Loop
	  Raise notice 'Employee ID: %,Absent Days: %',
	  			rec.emp_id,rec.absent_days;
	End Loop;
End;
$$;


create or replace function update_attendance()
returns int
language plpgsql
as $$
declare updated_rows int;
begin
update attendance set status = 'Present'
where status = 'Late';
Get Diagnostics updated_rows = Row_Count;
return updated_rows;
End;
$$;


SELECT emp_id, COUNT(CASE WHEN status = 'Absent' THEN 1 END) AS absent_days, 
CASE WHEN COUNT(CASE WHEN status = 'Absent' THEN 1 END) <= 2 THEN 'Good' 
WHEN COUNT(CASE WHEN status = 'Absent' THEN 1 END) BETWEEN 3 AND 5 THEN 'Average' 
ELSE 'Poor' END AS attendance_summary 
FROM attendance 
GROUP BY emp_id 
ORDER BY emp_id;

call count_absent_days()
select update_attendance()