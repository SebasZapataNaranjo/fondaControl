// src/app/features/venta-rapida/venta-rapida-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VentaRapidaComponent } from './venta-rapida/venta-rapida.component';

const routes: Routes = [
  { path: '', component: VentaRapidaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VentaRapidaRoutingModule {}
