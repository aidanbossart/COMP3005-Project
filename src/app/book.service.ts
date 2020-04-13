import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  public getAllBooks()
  {
    return this.http.get("http://localhost:8080/rest/books/all");
  }

  public getBooksByName(name: string)
  {
    return this.http.get("http://localhost:8080/rest/books/by/title?search="+encodeURIComponent(name));
  }

  public getBookById(id)
  {
    return this.http.get("http://localhost:8080/rest/books/by/id?id="+encodeURIComponent(id));
  }
}