// src/app/app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

// Este módulo ya incluye todas las rutas principales (lazy-loading, layout y login/register)
import { AppRoutingModule } from './app-routing.module';

// Componentes principales
import { AppComponent } from './app.component';

// Layout y pantallas “públicas”
import { MainLayoutModule } from './layout/main-layout/main-layout.module';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';

// Para trabajar con formularios en Login/Register
import { FormsModule } from '@angular/forms';

// Este SharedModule puede incluir directivas/pipes/otros módulos comunes de tu proyecto.
// Si no lo tienes con algo específico, puedes comentar esta línea y borrar SharedModule de imports.
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,            // Para [(ngModel)] en login/register
    SharedModule,           // <-- si tienes rutas, pipes o componentes compartidos
    MainLayoutModule,       // <-- Módulo que declara MainLayoutComponent y su CSS/HTML
    AppRoutingModule        // <-- Debe ir siempre AL FINAL de los imports
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
