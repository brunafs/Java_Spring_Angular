import { ClienteListaComponent } from './cliente-lista/cliente-lista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { LayoutComponent } from '../layout/layout.component';


const routes: Routes = [
  { path: 'clientes', component: LayoutComponent, children: [
    { path: 'form', component: ClientesFormComponent },
    { path: 'form/:id', component: ClientesFormComponent },
    { path: 'lista', component: ClienteListaComponent },
    { path: '', redirectTo: "/clientes/lista", pathMatch: 'full' },
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
