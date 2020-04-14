import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Book } from '../book';
import { switchMap } from 'rxjs/operators';
import { BookService } from '../book.service';

@Component({
  selector: 'app-bookpage',
  templateUrl: './bookpage.component.html',
  styleUrls: ['./bookpage.component.css']
})
export class BookpageComponent implements OnInit {
  private book: Book;

  constructor(private route: ActivatedRoute, private bookService: BookService) { }

  public getBook()
  {
    return this.book;
  }

  async ngOnInit() {
    await this.loadBook();
    console.log(this.book);
  }

  async loadBook()
  {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.bookService.getBookById(params.get('id')).subscribe((e: Object) => this.book = new Book(e["book_id"], e["book_name"], e["author_id"], e["genre"], e["pagenum"], e["price"], e["rating"]));
    });
  }

}
