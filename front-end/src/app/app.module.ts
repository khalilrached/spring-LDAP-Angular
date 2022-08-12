import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { myFirstComp } from './myFirstComp/myFirstComp.component';
import { loginForm } from './loginForm/loginForm.component';

@NgModule({
  declarations: [
    AppComponent,
    myFirstComp,
    loginForm
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
