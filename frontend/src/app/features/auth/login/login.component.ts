// src/app/features/auth/login/login.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router) {}

  onSubmit() {
    // TODO: Aquí iría la llamada real a tu API de login.
    //       Para mostrar un flujo funcional, simulamos que siempre es válido:
    if (this.username && this.password) {
      // Por ejemplo: localStorage.setItem('token', '…');
      this.router.navigate(['/usuarios']);
    } else {
      alert('Usuario y contraseña son obligatorios');
    }
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }
}
