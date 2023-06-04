import { StaffEditComponent } from './components/staff/staff-edit/staff-edit.component';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthentificationInterceptor } from './interceptors/authentification.interceptor';
import { MenuComponent } from './components/menu/menu.component';
import { EvenementListComponent } from './components/evenement/evenement-list/evenement-list.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { ClientListComponent } from './components/customer/client-list/client-list.component';
import { LocalListComponent } from './components/local/local-list/local-list.component';
import { LocalEditComponent } from './components/local/local-edit/local-edit.component';
import { StaffListComponent } from './components/staff/staff-list/staff-list.component';
import { ArtisteListComponent } from './components/artiste/artiste-list/artiste-list.component';
import { ArtisteEditComponent } from './components/artiste/artiste-edit/artiste-edit.component';
import { ClientEditComponent } from './components/customer/client-edit/client-edit.component';
import { ClientHomeComponent } from './components/customer/client-home/client-home.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { NgModule } from '@angular/core';
import { AffichageEvenementComponent } from './components/evenement/affichage-evenement/affichage-evenement.component';
import { ReservationComponent } from './components/reservation/reservation.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MenuComponent,
    EvenementListComponent,
    InscriptionComponent,
    ClientListComponent,
    LocalListComponent,
    LocalEditComponent,
    StaffListComponent,
    StaffEditComponent,
    ArtisteListComponent,
    ArtisteEditComponent,
    ClientEditComponent,
    ClientHomeComponent,
    AdminHomeComponent,
    EvenementEditComponent,
    EvenementEditComponent,
    AffichageEvenementComponent,
    ReservationComponent,
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
