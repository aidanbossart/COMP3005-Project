import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private username: string;
  private authenticated: boolean;
  constructor(private http: HttpClient) { }

  public setUsername(username: string)
  {
    this.username = username;
  }

  public getUsername(): string
  {
    return this.username;
  }

  public getAuthenticated(): boolean
  {
    return this.authenticated;
  }

  public authenticate(data)
  {
    this.http.post("http://localhost:8080/rest/authenticate", data).subscribe(result => {
      console.log(result);
      this.authenticated = JSON.parse(result["authenticated"]);
      console.log(this.authenticated);
      if(this.authenticated == true)
      {
        this.username = data["username"];
      }
      else
      {
        console.log(typeof this.authenticated);
        console.log("Failed to login.");
      }
    });
  }
}
