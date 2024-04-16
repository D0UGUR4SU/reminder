import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSidenavContent } from '@angular/material/sidenav';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatSidenavContent,
    HttpClientModule
  ],
  providers: [],
  bootstrap: []
})
export class AppModule { }
