Do $$
declare num int:=10;
Begin

if num%2=0 then
	raise notice '% is Even:',num;
Else
	raise notice '% is Odd:',num;
End if;

End;
$$;



Do $$
declare
num1 int:=20;
num2 int:=45;
num3 int:=30;
Begin

	if num1>num2 and num1>num3 then
		raise notice '% is greatest',num1;
		
	Elsif num2>num1 and num2>num3 then
		raise notice '% is greatest',num2;

	Else
		raise notice '% is greatest',num3;
	End if;

End;
$$;


Do $$
declare 
age int :=18;
Begin

	if age>=18 then
		raise notice 'you are eligible to vote';
	Else
		raise notice 'you are not eligible to vote';
	End if;
	
End;
$$;


Do $$
Begin

	For i in 1..10 loop
		raise notice 'Num: %',i;
	End loop;
	
End;
$$;


Do $$

declare
total int:=0;

Begin

	for i in 1..10 loop
		total := total + i;
	End loop;

	raise notice 'Sum = %',total;
	
End;
$$;


Do $$
declare
num int:=8;

Begin

	for i in 1..10 loop
		raise notice '% X % = %', i, num, i*num; 
	End loop;

End;
$$;

Do $$
declare 
num int:=5;
fact int:=1;

Begin

	for i in 1..num loop
		fact := fact * i;
	End loop;

	Raise notice 'Factorial of % is %',num,fact;

End;
$$;

Do $$
declare
num int:=20;
Begin

	for i in 1..num loop
		if i%2=0 then 
			raise notice '%',i;
		End if;
	End loop;

End;
$$;


Do $$
Begin

	for i in 2..20 by 2 loop
		raise notice '%',i;
	end loop;

End;
$$;

Do $$
declare 
num int:=2;
Begin

	while num<=20 loop
		Raise notice '%',num;
	num = num+2;
	End loop;
	
End;
$$;


Do $$

Begin

	for i in 1..20 by 2 loop
		raise notice '%',i;
	End loop;

	
	
End;
$$;

Do $$
declare
num int:= 1;
Begin

	while num<=20 loop 
		raise notice '%',num;
		num:=num+2;
	End loop;

End;
$$;
	