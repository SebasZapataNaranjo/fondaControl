// src/app/features/venta-rapida/venta-rapida.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { VentaRapidaRoutingModule } from './venta-rapida-routing.module';
import { VentaRapidaComponent } from './venta-rapida/venta-rapida.component';

@NgModule({
  declarations: [
    VentaRapidaComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    VentaRapidaRoutingModule
  ]
})
export class VentaRapidaModule {}
