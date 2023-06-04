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

import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AdminGuardService } from './services/guard/admin-guard.service';
import { ClientGuardService } from './services/guard/client-guard.service';
import { LoggoffGuardService } from './services/guard/loggoff-guard.service';
import { ReservationComponent } from './components/reservation/reservation.component';
import { AffichageEvenementComponent } from './components/evenement/affichage-evenement/affichage-evenement.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [LoggoffGuardService],
  },
  {
    path: 'evenement',
    component: EvenementListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'affichage-evenement',
    component: AffichageEvenementComponent,
  },
  {
    path: 'reservation',
    component: ReservationComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'reservation/:id',
    component: ReservationComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'staff',
    component: StaffListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'staff/edit',
    component: StaffEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'staff/edit/:id',
    component: StaffEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'local',
    component: LocalListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'local/edit',
    component: LocalEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'local/edit/:id',
    component: LocalEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client',
    component: ClientListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [LoggoffGuardService],
  },
  {
    path: 'artiste',
    component: ArtisteListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'artiste/edit',
    component: ArtisteEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'artiste/edit/:id',
    component: ArtisteEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client/home',
    component: ClientHomeComponent,
    canActivate: [ClientGuardService],
  },

  {
    path: 'client/edit/:id',
    component: ClientEditComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'admin/home',
    component: AdminHomeComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'evenement/edit',
    component: EvenementEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'evenement/edit/:id',
    component: EvenementEditComponent,
    canActivate: [AdminGuardService],
  },

  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
