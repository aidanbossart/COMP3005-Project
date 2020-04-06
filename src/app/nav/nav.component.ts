import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private searchForm;

  constructor(private formBuilder: FormBuilder, private router: Router) {
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
