/* Search for book based on name */
select * from book WHERE UPPER(book_name) like UPPER('%book%')

/* Insert into cart */
insert into cart values ((select cart_id from bookstore_user inner join cart on cart.u_id = bookstore_user.u_id where bookstore_user.username = 'userone'), 3, 1)

/* Search book by id */
select * from book where book_id = '1'

/* Search book by isbn */
select * from book where UPPER(isbn) LIKE UPPER('%search%')

/* Get all books */
select * from books

/* Get user cart id */
select distinct cart_id from bookstore_user inner join cart on cart.u_id = bookstore_user.u_id where bookstore_user.username = 'userone'

/* Get all books in cart belonging to user */
select * from book join cart on book.book_id = cart.book_id where cart.cart_id = (select distinct cart_id from cart join bookstore_user on cart.u_id = bookstore_user.u_id where bookstore_user.username = 'userone')

/* Check if user is valid and password matches */
select case when exists (
select * from bookstore_user where username = 'userone' and password = 'passwordonse')
then cast(1 as bit)
else cast(0 as bit) end

/* Get author id from name */
select distinct author_id from author where 'Author One' = author_name

/* Get publisher id from name */
select distinct publisher_id from publisher where publisher_name = 'Ones publisher'

/* Add new author */
INSERT INTO author VALUES(DEFAULT, 'author name')

/* Add new publisher */
INSERT INTO author VALUES(DEFAULT,'name','address','email',1111111111,12345)

/* Add new book */
INSERT INTO book VALUES (DEFAULT,name,author_id,isbn,genre,publisher_id,pagenum,price,0.0)

/* Get all collection */
select * from collection