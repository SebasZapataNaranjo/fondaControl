// src/app/features/mesa/mesa.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MesaRoutingModule } from './mesa-routing.module';
import { MesaListComponent } from './mesa-list/mesa-list.component';
import { MesaDetailComponent } from './mesa-detail/mesa-detail.component';

@NgModule({
  declarations: [
    MesaListComponent,
    MesaDetailComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MesaRoutingModule
  ]
})
export class MesaModule {}
