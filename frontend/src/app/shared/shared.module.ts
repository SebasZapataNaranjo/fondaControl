// src/app/shared/shared.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    // Aquí van pipes o directivas que quieras compartir
  ],
  imports: [CommonModule],
  exports: [
    CommonModule
    // , AlgunaDirectivaPipeCompartida, etc.
  ]
})
export class SharedModule { }
