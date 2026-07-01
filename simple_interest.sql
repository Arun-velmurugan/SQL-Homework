create or replace function calculate(principal int,rate int, times int)
returns int
language plpgsql
as $$
declare
si int;
begin 
si := (principal*rate*times)/100;
return si;
end;
$$;

create or replace procedure simple_intrst(principal int,rate int,times int)
language plpgsql
as $$
declare 
si int;
begin 
si := calculate(principal,rate,times);
raise notice 'principal Amount %:',principal;
raise notice 'Simple Amount %:',si;
raise notice 'Total Amount %:',principal+si;
end;
$$;

call simple_intrst(10000,5,2)
