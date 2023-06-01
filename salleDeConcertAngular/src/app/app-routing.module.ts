import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EvenementListComponent } from './components/evenement/evenement-list/evenement-list.component';
import { StaffListComponent } from './components/staff/staff-list/staff-list.component';
import { StaffEditComponent } from './components/staff/staff-edit/staff-edit.component';
import { ClientListComponent } from './components/customer/client-list/client-list.component';
import { LocalListComponent } from './components/local/local-list/local-list.component';
import { LocalEditComponent } from './components/local/local-edit/local-edit.component';
import { EvenementEditComponent } from './components/evenement/evenement-edit/evenement-edit.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'evenement', component: EvenementListComponent },
  { path: 'evenement/edit', component: EvenementEditComponent },
  { path: 'evenement/edit/:id', component: EvenementEditComponent },
  { path: 'staff', component: StaffListComponent },
  { path: 'staff/edit', component: StaffEditComponent },
  { path: 'staff/edit/:id', component: StaffEditComponent },
  { path: 'client', component: ClientListComponent },
  { path: 'local', component: LocalListComponent },
  { path: 'local/edit', component: LocalEditComponent },
  { path: 'local/edit/:id', component: LocalEditComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
