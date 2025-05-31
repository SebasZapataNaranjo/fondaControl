// src/app/app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Pantallas “públicas” (antes de autenticarse)
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';

// Layout principal (barra lateral + contenido)
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';

const routes: Routes = [
  // 1) Rutas públicas (no usan layout)
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },

  // 2) Rutas internas protegidas (usando MainLayoutComponent como “wrapper”)
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      // Si la URL está vacía, redirige a “/usuarios”
      { path: '', redirectTo: 'usuarios', pathMatch: 'full' },

      // Usuarios (lazy-loaded)
      {
        path: 'usuarios',
        loadChildren: () =>
          import('./features/usuario/usuario.module').then(m => m.UsuarioModule)
      },

      // Inventario (lazy-loaded)
      {
        path: 'inventario',
        loadChildren: () =>
          import('./features/inventario/inventario.module').then(m => m.InventarioModule)
      },

      // Mesas (lazy-loaded)
      {
        path: 'mesas',
        loadChildren: () =>
          import('./features/mesa/mesa.module').then(m => m.MesaModule)
      },

      // Informe de Caja (lazy-loaded)
      {
        path: 'informe-caja',
        loadChildren: () =>
          import('./features/reportes/reportes.module').then(m => m.ReportesModule)
      },

      // Venta Rápida (lazy-loaded)
      {
        path: 'venta-rapida',
        loadChildren: () =>
          import('./features/venta-rapida/venta-rapida.module').then(m => m.VentaRapidaModule)
      },

      // Sesiones (lazy-loaded)
      {
        path: 'sesiones',
        loadChildren: () =>
          import('./features/session/session.module').then(m => m.SessionModule)
      }
    ]
  },

  // Si cualquiera escribe cualquier otra ruta, lo enviamos a login
  { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
