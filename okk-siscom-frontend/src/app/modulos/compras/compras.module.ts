import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {COMPRAS_ROUTES} from "./compras.module.routes";
import { ComprasComponent } from './pages/compras/compras.component';

@NgModule({
  declarations: [
    ComprasComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(COMPRAS_ROUTES)
  ]
})
export class ComprasModule {
}
