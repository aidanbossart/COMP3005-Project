create table address
	(address		varchar(40), 
	 postal_code	varchar(6),
	 country		varchar(20), 
	 province_state	varchar(20),
	 primary key (address)
	);

create table payment
	(payment_id		serial, 
	 cardnum		bigint, 
	 cardtype		varchar(12), 
	 expiry			varchar(5),
	 primary key (payment_id)
	);

create table author
	(author_id		serial,
	 author_name	varchar(15),
	 primary key (author_id)
	);


create table shipment
	(shipment_id	serial,
	 status			varchar(10),
	 address		varchar(40),
	 primary key (shipment_id),
	 foreign key (address) references address(address)
	);

create table publisher
	(publisher_id	serial, 
	 publisher_name	varchar(15),
	 address		varchar(40),
	 email			varchar(40),
	 phone			varchar(11),
	 banknum		integer,
	 primary key (publisher_id),	
	 foreign key (address) references address(address)
	);

create table book
	(book_id		serial,
	 book_name		varchar(20), 
	 author_id		serial,
	 isbn			integer,
	 genre			varchar(15),
	 publisher_id	serial,
	 pagenum		integer,
	 price			numeric(5,2),
	 rating			numeric(3,2),
	 primary key (book_id),
	 foreign key (author_id) references author(author_id),
	 foreign key (publisher_id) references publisher(publisher_id)
	);

create table collection
	(collection_id		serial, 
     	 book_id		serial,
	 collection_name	varchar(15), 
	 primary key (collection_id, book_id),
	 foreign key (book_id) references book(book_id)
	);


create table book_order
	(order_id		serial, 
	 payment_id		serial,
	 shipping_id	serial, 
	 book_id		serial,
	 primary key (order_id),
	 foreign key (payment_id) references payment(payment_id),
	 foreign key (shipping_id) references shipment(shipment_id),
	 foreign key (book_id) references book(book_id)
	);

create table bookstore_user
	(
	 u_id			serial,
	 username       varchar(15),
	 password 		varchar(15),
	 order_id		serial,
	 payment_id		serial,
	 address		varchar(40),
	 primary key (u_id),
	 foreign key (order_id) references book_order(order_id),
	 foreign key (payment_id) references payment(payment_id),
	 foreign key (address) references address(address) 
	);

create table cart
	(cart_id		serial,
	 book_id		serial,
     u_id           serial,
	 num			integer,
	 primary key (cart_id, book_id),
	 foreign key (book_id) references book(book_id),
     foreign key (u_id) references bookstore_user(u_id)
	);

create table owner
	(o_id 			serial,
	 u_id 			serial, 
	 primary key (o_id),
	 foreign key (u_id) references bookstore_user(u_id)
	);