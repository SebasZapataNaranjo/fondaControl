// src/app/features/reportes/reportes.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReportesRoutingModule } from './reportes-routing.module';
import { InformeCajaListComponent } from './informe-caja-list/informe-caja-list.component';
import { InformeCajaDetailComponent } from './informe-caja-details/informe-caja-detail.component';

@NgModule({
  declarations: [
    InformeCajaListComponent,
    InformeCajaDetailComponent
  ],
  imports: [
    CommonModule,
    ReportesRoutingModule
  ]
})
export class ReportesModule {}
