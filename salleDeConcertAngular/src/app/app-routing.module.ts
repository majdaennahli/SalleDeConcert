import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EvenementListComponent } from './components/evenement/evenement-list/evenement-list.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { StaffListComponent } from './components/staff/staff-list/staff-list.component';
import { StaffEditComponent } from './components/staff/staff-edit/staff-edit.component';
import { LocalListComponent } from './components/local/local-list/local-list.component';
import { LocalEditComponent } from './components/local/local-edit/local-edit.component';
import { ClientListComponent } from './components/customer/client-list/client-list.component';
import { ArtisteListComponent } from './components/artiste/artiste-list/artiste-list.component';
import { ArtisteEditComponent } from './components/artiste/artiste-edit/artiste-edit.component';
import { ClientHomeComponent } from './components/customer/client-home/client-home.component';
import { ClientEditComponent } from './components/customer/client-edit/client-edit.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'evenement', component: EvenementListComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'staff', component: StaffListComponent },
  { path: 'staff/edit', component: StaffEditComponent },
  { path: 'staff/edit/:id', component: StaffEditComponent },
  { path: 'local', component: LocalListComponent },
  { path: 'local/edit', component: LocalEditComponent },
  { path: 'local/edit/:id', component: LocalEditComponent },
  { path: 'client', component: ClientListComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'artiste', component: ArtisteListComponent },
  { path: 'artiste/edit', component: ArtisteEditComponent },
  { path: 'artiste/edit/:id', component: ArtisteEditComponent },
  { path: 'client/home', component: ClientHomeComponent },
  { path: 'client/edit', component: ClientEditComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
