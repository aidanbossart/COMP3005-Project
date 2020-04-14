import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { BookService } from '../book.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  adminForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private bookService: BookService) {
    this.adminForm = this.formBuilder.group({
      name: '',
      author: '',
      publisher: '',
      isbn: '',
      pagenum: '',
      price: '',
      genre: ''
    })
  }

  onSubmit(data)
  {
    this.bookService.addBook(data).subscribe(result => console.log(result));
  }

  ngOnInit() {
  }

}