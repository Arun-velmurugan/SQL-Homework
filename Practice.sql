create table vehicle_details(vehicle_id serial primary key,vehicle_name varchar(100),vehicle_number varchar(70) unique,capacity int)

insert into vehicle_details(vehicle_name,vehicle_number,capacity) values
('Ashok Leyland Bus', 'TN01AB1234', 50),
('Tata Truck', 'TN02CD5678', 20),
('Mahindra Van', 'TN03EF9012', 12),
('Eicher Bus', 'TN04GH3456', 45),
('Volvo Bus', 'TN05IJ7890', 55),
('Mini Bus', 'TN06KL2345', 30)


create table delivery_details(delivery_id serial primary key,product_name varchar,shop_name varchar,delivery_area varchar,status varchar)

insert into delivery_details(product_name,shop_name,delivery_area,status) values
('Rice Bag', 'Sri Murugan Stores', 'Mayiladuthurai', 'Delivered'),
('Cooking Oil', 'Annapoorna Mart', 'Kumbakonam', 'Pending'),
('Laptop', 'Tech World', 'Chennai', 'Out for Delivery'),
('Mobile Phone', 'Poorvika Mobiles', 'Thanjavur', 'Delivered'),
('Groceries', 'Reliance Fresh', 'Nagapattinam', 'Pending'),
('Medicine Kit', 'Apollo Pharmacy', 'Sirkazhi', 'Delivered')

create view completed_deliveries
as select * from delivery_details
where status = 'Delivered'

create index idx_delivery_area
on delivery_details(delivery_area)


Begin;

insert into delivery_details(product_name,shop_name,delivery_area,status) values
('Air Conditioner', 'Viveks', 'Chennai', 'Pending'),
('Printer', 'Canon Store', 'Trichy', 'Out for Delivery'),
('Office Chair', 'Furniture World', 'Madurai', 'Delivered');

commit;

Begin;

Delete from delivery_details
where delivery_id = 3


rollback;



select * from delivery_details

create user Arun with password 'Arun123'

Grant select on delivery_details to arun

select * from delivery_details




