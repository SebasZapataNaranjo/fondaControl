// src/app/layout/main-layout/main-layout.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-layout',
  standalone: false,
  templateUrl: './main-layout.component.html',
  styleUrls: ['./main-layout.component.css']
})
export class MainLayoutComponent {
  constructor(private router: Router) {}

  logout() {
    // Aquí borra tu token, localStorage, etc. si aplica.
    // Luego redirige al login:
    this.router.navigate(['/login']);
  }
}
