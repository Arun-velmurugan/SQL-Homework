

create or replace function total_marks(mark1 int,mark2 int,mark3 int)
returns int
language plpgsql
as $$
declare total int;
begin
total = mark1 + mark2 + mark3;
return total;
end;
$$;

create or replace procedure student_result(mark1 int,mark2 int, mark3 int)
language plpgsql
as $$
declare total int;
begin 
total = total_marks(mark1,mark2,mark3);
raise notice 'total mark is % ',total;

if total>=150 then
raise notice 'Result: PASS';

else
raise notice 'Reault: FAIL';

END IF;
end;
$$;

call student_result(90,98,95)