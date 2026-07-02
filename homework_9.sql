
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title TEXT,
    author TEXT,
    copies INT
);

INSERT INTO books(title, author, copies)
VALUES
('Java Programming', 'James Gosling', 10),
('Database Systems', 'Elmasri', 5),
('Python Basics', 'Guido', 2),
('C Programming', 'Dennis Ritchie', 0);


create or replace function issue_book(p_book_id int)
returns varchar
language plpgsql
as $$
Begin

if(Select copies from books where book_id = p_book_id)>0 then
update books 
set copies = copies - 1
where book_id = p_book_id;

Return 'Book issued';

Else

Return 'Book Not Available';

End if;
End;
$$;

select issue_book(1)


alter table books
add column status varchar

create or replace procedure update_book_status()
language plpgsql
as $$
declare rec RECORD;
begin
for rec in
select book_id,copies from books
loop
if rec.copies = 0 then
update books 
set status = 'out of stock'
where book_id = rec.book_id;
End if;

End loop;
end;
$$;

call update_book_status()


select * from books


select book_id,title,copies,

case 
when copies > 5 then 'available'
when copies Between 1 and 5 then 'Limited'
Else 'Out of Stock'

End as Availability
from books