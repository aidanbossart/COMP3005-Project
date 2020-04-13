import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private searchForm;

  constructor(private formBuilder: FormBuilder, private router: Router, protected login: LoginService) {
    this.searchForm = this.formBuilder.group({
      search: ''
    });
   }

  ngOnInit() {
  }

  onSubmit(searchData)
  {
    this.router.navigate(["/search"], {queryParams: {search: searchData.search}});
  }

}
