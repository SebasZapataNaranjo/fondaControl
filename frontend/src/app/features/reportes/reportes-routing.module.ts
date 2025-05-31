// src/app/features/reportes/reportes-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InformeCajaListComponent } from './informe-caja-list/informe-caja-list.component';
import { InformeCajaDetailComponent } from './informe-caja-details/informe-caja-detail.component';

const routes: Routes = [
  { path: '', component: InformeCajaListComponent },
  { path: ':id', component: InformeCajaDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReportesRoutingModule {}
