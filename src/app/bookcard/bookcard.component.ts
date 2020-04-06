import { Component, OnInit, Input, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CartService } from '../cart.service';
import { Book } from '../book';

@Component({
  selector: 'app-bookcard',
  templateUrl: './bookcard.component.html',
  styleUrls: ['./bookcard.component.css']
})
export class BookcardComponent implements OnInit {
  @Input() private book: Book;
  public cartForm;

  constructor(private cart: CartService, private formBuilder: FormBuilder) {
    this.cartForm = this.formBuilder.group({
      username: ''
    });
  }

  public getName()
  {
    return this.book.getName();
  }

  public getAuthor()
  {
    return this.book.getAuthor();
  }

  public getGenre()
  {
    return this.book.getGenre();
  }

  ngOnInit() {
  }

  public addToCart()
  {
    this.cart.addToCart(this.book);
  }
}
