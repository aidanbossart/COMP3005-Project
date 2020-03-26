import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { BookviewComponent } from './bookview/bookview.component';
import { BookcardComponent } from './bookcard/bookcard.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    BookviewComponent,
    BookcardComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
