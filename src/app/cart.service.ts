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
    return this.books;
  }

  public addToCart(book: Book)
  {
    this.books.push(book);
    this.http.post("http://localhost:8080/rest/addtocart", "{username: "+this.login.getUsername()+", book_id: "+book.getId()+"}").subscribe(data => console.log(data));
  }
}
