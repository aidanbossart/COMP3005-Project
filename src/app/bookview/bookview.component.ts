import { Component, OnInit, Input } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { catchError, map, tap } from 'rxjs/operators';
import { BookcardComponent } from '../bookcard/bookcard.component';

@Component({
  selector: 'app-bookview',
  templateUrl: './bookview.component.html',
  styleUrls: ['./bookview.component.css']
})
export class BookviewComponent implements OnInit {
  @Input() search: string = null;
  private books: Array<Book> = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    if(this.search == null)
    {
      console.log("getting all");
      this.searchAllBooks();
    }
    else
    {
      console.log("searching by title");
      this.searchByName();
    }
  }

  private searchAllBooks()
  {
    this.bookService.getAllBooks().subscribe((data: Array<Object>) => {
      data.forEach(e => {
        this.books.push(new Book(e["book_id"], e["book_name"], e["author_id"], e["genre"], e["pagenum"], e["price"], e["rating"]));
      });
    });
  }

  private searchByName()
  {
    this.bookService.getBooksByName(this.search).subscribe((data: Array<Object>) => {
      data.forEach(e => {
        this.books.push(new Book(e["book_id"], e["book_name"], e["author_id"], e["genre"], e["pagenum"], e["price"], e["rating"]));
      });
    });
  }

  public getBooks()
  {
    return this.books;
  }


}
