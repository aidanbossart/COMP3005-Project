import { Injectable } from '@angular/core';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private books: Array<Book> = [];

  constructor() { }

  public getBooks(): Array<Book>
  {
    return this.books;
  }

  public addToCart(book: Book)
  {
    this.books.push(book);
  }
}
