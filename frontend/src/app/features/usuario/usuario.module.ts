// src/app/features/usuario/usuario.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioRoutingModule } from './usuario-routing.module';
import { UsuarioCrudComponent } from './usuario-crud/usuario-crud.component';

@NgModule({
  declarations: [
    UsuarioCrudComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    UsuarioRoutingModule
  ]
})
export class UsuarioModule {}
