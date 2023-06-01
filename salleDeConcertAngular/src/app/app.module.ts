import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthentificationInterceptor } from './interceptors/authentification.interceptor';
import { MenuComponent } from './components/menu/menu.component';
import { ArtisteListComponent } from './components/artiste/artiste-list/artiste-list.component';
import { EvenementListComponent } from './components/evenement/evenement-list/evenement-list.component';
import { StaffListComponent } from './components/staff/staff-list/staff-list.component';
import { StaffEditComponent } from './components/staff/staff-edit/staff-edit.component';
import { ClientListComponent } from './components/customer/client-list/client-list.component';
import { LocalEditComponent } from './components/local/local-edit/local-edit.component';
import { LocalListComponent } from './components/local/local-list/local-list.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MenuComponent,
    ArtisteListComponent,
    EvenementListComponent,
    StaffListComponent,
    StaffEditComponent,
    ClientListComponent,
    LocalEditComponent,
    LocalListComponent,
    EvenementEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthentificationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
