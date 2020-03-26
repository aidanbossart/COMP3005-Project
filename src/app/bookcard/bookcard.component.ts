import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bookcard',
  templateUrl: './bookcard.component.html',
  styleUrls: ['./bookcard.component.css']
})
export class BookcardComponent implements OnInit {
  @Input() private name:string;
  @Input() private author: string;
  @Input() private description: string;

  constructor() {

  }

  public getName()
  {
    return this.name;
  }

  public getAuthor()
  {
    return this.author;
  }

  public getDescription()
  {
    return this.description;
  }

  ngOnInit() {
  }

}
