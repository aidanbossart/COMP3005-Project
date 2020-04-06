import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { BookviewComponent } from './bookview/bookview.component';
import { BookcardComponent } from './bookcard/bookcard.component';
import { HomeComponent } from './home/home.component';

import { HttpClientModule } from '@angular/common/http';

import { RouterModule, Routes } from '@angular/router';
import { SearchComponent } from './search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CartComponent } from './cart/cart.component';
import { LoginComponent, LoginModalContent } from './login/login.component';
import { BookpageComponent } from './bookpage/bookpage.component';

const appRoutes: Routes = [
  { path: "home", component: HomeComponent},
  { path: "search", component: SearchComponent},
  { path: "cart", component: CartComponent},
  { path: "book/:id", component: BookpageComponent},
  { path: "", redirectTo: "/home", pathMatch: "full"},
  { path: '**', redirectTo: "/home", pathMatch: "full"},
  { path: 'error', redirectTo: "/home", pathMatch: "full"}
]

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    BookviewComponent,
    BookcardComponent,
    HomeComponent,
    SearchComponent,
    CartComponent,
    LoginComponent,
    BookpageComponent,
    LoginModalContent
  ],
  entryComponents: [LoginModalContent],
  imports: [
    BrowserModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {useHash: true}),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
