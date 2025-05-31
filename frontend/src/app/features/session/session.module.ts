// src/app/features/session/session.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SessionRoutingModule } from './session-routing.module';
import { SessionListComponent } from './session-list/session-list.component';
import { SessionOpenComponent } from './session-open/session-open.component';

@NgModule({
  declarations: [
    SessionListComponent,
    SessionOpenComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    SessionRoutingModule
  ]
})
export class SessionModule {}
