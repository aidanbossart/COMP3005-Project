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

insert into payment values (DEFAULT, '1234123412341234', 'Debit Card', '12/22');
insert into payment values (DEFAULT, '2345234523452345', 'Credit Card', '10/23');
insert into payment values (DEFAULT, '3456345634563456', 'Credit Card', '9/21');

insert into author values (DEFAULT, 'Author One');
insert into author values (DEFAULT, 'Author Two');
insert into author values (DEFAULT, 'Author Three');
insert into author values (DEFAULT, 'Author Four');


insert into shipment values (DEFAULT, 'ordered','1111 one road');
insert into shipment values (DEFAULT, 'En route', '2222 two road');
insert into shipment values (DEFAULT, 'En route', '3333 three road');

insert into publisher values (DEFAULT, 'Ones publisher', '0000 zero road', 'onespub@gmail.com','6131111111','1987');
insert into publisher values (DEFAULT, 'Twos publisher', '4444 four road', 'twospub@gmail.com','6132222222','2987');

insert into book values (DEFAULT, 'Book One', '1', '1234', 'Genre One', '1', '100','10.1','4.5');
insert into book values (DEFAULT, 'Book Two', '2', '2345', 'Genre Two', '1', '200','20.2','3.6');
insert into book values (DEFAULT, 'Book Three', '3', '3456', 'Genre Three', '1', '300','30.3','2.9');
insert into book values (DEFAULT, 'Book Four', '4', '4567', 'Genre Four', '2', '400','40.4','4.4');

insert into collection values (DEFAULT, 1, 'One Two');
insert into collection values (1, 3, 'One Two');
insert into collection values (DEFAULT, 2, 'One Two');
insert into collection values (DEFAULT, 3, 'Three Four');
insert into collection values (DEFAULT, 4, 'Three Four');

insert into book_order values (DEFAULT, 1,1,1);
insert into book_order values (DEFAULT, 2,2,2);
insert into book_order values (DEFAULT, 3,3,3);

insert into bookstore_user values (DEFAULT, 'userone', 'passwordone', 1,1,'1111 one road');
insert into bookstore_user values (DEFAULT, 'usertwo', 'passwordtwo', 2,2,'2222 two road');
insert into bookstore_user values (DEFAULT, 'userthree', 'passwordthree', 3,3,'3333 three road');

insert into cart values (DEFAULT, '1', 1, 1);
insert into cart values (DEFAULT, '2', 1, 1);
insert into cart values (DEFAULT, '4', 1, 1);


insert into owner values ('1', '3');