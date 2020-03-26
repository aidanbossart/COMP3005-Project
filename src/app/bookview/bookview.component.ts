import { Component, OnInit, Input } from '@angular/core';
import { Book } from '../book';

@Component({
  selector: 'app-bookview',
  templateUrl: './bookview.component.html',
  styleUrls: ['./bookview.component.css']
})
export class BookviewComponent implements OnInit {
  @Input() private books: Array<Book>;

  constructor() { }

  ngOnInit() {
  }

  public getBooks()
  {
    return this.books;
  }
}
