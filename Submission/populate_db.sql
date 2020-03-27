delete from address;
delete from cart;
delete from publisher;
delete from bookstore_user;
delete from book;
delete from owner;
delete from shipment;
delete from book_order;
delete from payment;
delete from collection;
delete from author;

insert into address values ('0000 zero road', 'A1B2C3', 'Canada', 'Ontario');
insert into address values ('1111 one road', 'B2C3D4', 'USA','Washington');
insert into address values ('2222 two road', 'C3D4E5', 'Africa','Free State');
insert into address values ('3333 three road', 'D4E5F6', 'Canada', 'Quebec');
insert into address values ('4444 four road', 'E5F6G7', 'USA', 'Washington');

insert into payment values ('111', '1234123412341234', 'Debit Card', '12/22');
insert into payment values ('222', '2345234523452345', 'Credit Card', '10/23');
insert into payment values ('333', '3456345634563456', 'Credit Card', '9/21');

insert into author values ('1', 'Author One');
insert into author values ('2', 'Author Two');
insert into author values ('3', 'Author Three');
insert into author values ('4', 'Author Four');


insert into shipment values ('123','ordered','1111 one road');
insert into shipment values ('367','En route', '2222 two road');
insert into shipment values ('589','En route', '3333 three road');

insert into publisher values ('1', 'Ones publisher', '0000 zero road', 'onespub@gmail.com','6131111111','1987');
insert into publisher values ('2', 'Twos publisher', '4444 four road', 'twospub@gmail.com','6132222222','2987');

insert into book values ('1', 'Book One', '1', '1234', 'Genre One', '1', '100','10.1','4.5');
insert into book values ('2', 'Book Two', '2', '2345', 'Genre Two', '1', '200','20.2','3.6');
insert into book values ('3', 'Book Three', '3', '3456', 'Genre Three', '1', '300','30.3','2.9');
insert into book values ('4', 'Book Four', '4', '4567', 'Genre Four', '2', '400','40.4','4.4');

insert into collection values ('11', '1', 'One Two');
insert into collection values ('12', '2', 'One Two');
insert into collection values ('34', '3', 'Three Four');
insert into collection values ('35', '4', 'Three Four');

insert into cart values ('1', '1');
insert into cart values ('2', '2');
insert into cart values ('3', '4');

insert into book_order values ('11', '111','123','1');
insert into book_order values ('22', '222','367','2');
insert into book_order values ('33', '333','589','3');

insert into bookstore_user values ('1', 'userone', 'passwordone', '1','11','111','1111 one road');
insert into bookstore_user values ('2', 'usertwo', 'passwordtwo', '2','22','222','2222 two road');
insert into bookstore_user values ('3', 'userthree', 'passwordthree', '3','33','333','3333 three road');


insert into owner values ('1', '3');









