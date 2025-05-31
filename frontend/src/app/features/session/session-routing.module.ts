// src/app/features/session/session-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SessionListComponent } from './session-list/session-list.component';
import { SessionOpenComponent } from './session-open/session-open.component';

const routes: Routes = [
  { path: '', component: SessionListComponent },
  { path: 'abrir', component: SessionOpenComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SessionRoutingModule {}
