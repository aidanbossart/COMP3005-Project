import { Component } from '@angular/core';
import { Book } from './book';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  books: Array<Book> = [ new Book(10001, "Test", "John Doe", "Mystery", 100, 25.99, 9.5), new Book(10001, "Test", "John Doe", "Mystery", 100, 25.99, 9.5)]

  public getBooks()
  {
    return this.books;
  }
}
