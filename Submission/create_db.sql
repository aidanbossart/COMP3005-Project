
create table address
	(address		varchar(40), 
	 postal_code		varchar(6),
	 country		varchar(20), 
	 province_state		varchar(20),
	 primary key (address)
	);

create table payment
	(payment_id		integer, 
	 cardnum		bigint, 
	 cardtype		varchar(12), 
	 expiry			varchar(5),
	 primary key (payment_id)
	);

create table author
	(author_id		integer,
	 author_name	varchar(15),
	 primary key (author_id)
	);


create table shipment
	(shipment_id		integer,
	 status			varchar(10),
	 address		varchar(40),
	 primary key (shipment_id),
	 foreign key (address) references address(address)
	);

create table publisher
	(publisher_id		integer, 
	 publisher_name			varchar(15),
	 address		varchar(40),
	 email			varchar(40),
	 phone			varchar(11),
	 banknum		integer,
	 primary key (publisher_id),	
	 foreign key (address) references address(address)
	);

create table book
	(book_id		integer,
	 book_name			varchar(20), 
	 author_id		integer,
	 isbn			integer,
	 genre			varchar(15),
	 publisher_id		integer,
	 pagenum		integer,
	 price			numeric(5,2),
	 rating			numeric(3,2),
	 primary key (book_id),
	 foreign key (author_id) references author(author_id),
	 foreign key (publisher_id) references publisher(publisher_id)
	);

create table collection
	(collection_id		integer, 
     	 book_id		integer,
	 collection_name	varchar(15), 
	 primary key (collection_id),
	 foreign key (book_id) references book(book_id)
	);


create table book_order
	(order_id		integer, 
	 payment_id		integer,
	 shipping_id		integer, 
	 book_id		integer,
	 primary key (order_id),
	 foreign key (payment_id) references payment(payment_id),
	 foreign key (shipping_id) references shipment(shipment_id),
	 foreign key (book_id) references book(book_id)
	);

create table cart
	(cart_id		integer,
	 book_id		integer,
	 primary key (cart_id),
	 foreign key (book_id) references book(book_id)
	);


create table bookstore_user
	(
	 u_id			integer,
	 username       	varchar(15),
	 password 		varchar(15),
	 cart_id		integer,
	 order_id		integer,
	 payment_id		integer,
	 address		varchar(40),
	 primary key (u_id),
	 foreign key (cart_id) references cart(cart_id),
	 foreign key (order_id) references book_order(order_id),
	 foreign key (payment_id) references payment(payment_id),
	 foreign key (address) references address(address) 
	);

create table owner
	(o_id integer,
	 u_id integer, 
	 primary key (o_id),
	 foreign key (u_id) references bookstore_user(u_id)
	);














