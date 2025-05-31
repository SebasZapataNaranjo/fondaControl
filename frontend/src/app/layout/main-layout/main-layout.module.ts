// src/app/layout/main-layout/main-layout.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MainLayoutComponent } from './main-layout.component';

// Si tienes estilos y otros componentes compartidos, inclúyelos aquí.
// Por ejemplo: SharedModule si contiene directivas/pipes que usas en MainLayout.
import { SharedModule } from '../../shared/shared.module';

@NgModule({
  declarations: [
    MainLayoutComponent
  ],
  imports: [
    CommonModule,
    RouterModule,    // para usar routerLink en el template
    SharedModule     // opcional: incluye aquí lo que necesite la vista del layout
  ],
  exports: [
    MainLayoutComponent
  ]
})
export class MainLayoutModule { }
