import { Injectable } from '@angular/core';
import { Book } from './book';
import { HttpClient } from '@angular/common/http';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private books: Array<Book> = [];

  constructor(private http: HttpClient, private login: LoginService) { }

  public getBooks(): Array<Book>
  {
    this.books = [];
    this.http.get("http://localhost:8080/rest/cart?username="+this.login.getUsername()).subscribe((data: Array<Object>) => {
      data.forEach(e => {
        this.books.push(new Book(e["book_id"], e["book_name"], e["author_id"], e["genre"], e["pagenum"], e["price"], e["rating"]));
      });
    });
    return this.books;
  }

  public addToCart(book: Book)
  {
    this.http.post("http://localhost:8080/rest/addtocart", "{username: "+this.login.getUsername()+", book_id: "+book.getId()+"}").subscribe(data => console.log(data));
  }
}
