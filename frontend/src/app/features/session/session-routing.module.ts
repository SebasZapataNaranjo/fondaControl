// src/app/features/session/session-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SessionListComponent } from './session-list/session-list.component';

const routes: Routes = [
  { path: 'list', component: SessionListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SessionRoutingModule {}
