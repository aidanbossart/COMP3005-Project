import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Book } from '../book';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  books: Array<Book>;

  constructor(private cartService: CartService) {
    this.books = this.cartService.getBooks();
  }

  ngOnInit() {
  }

  public getBooks()
  {
    return this.cartService.getBooks();
  }
}
