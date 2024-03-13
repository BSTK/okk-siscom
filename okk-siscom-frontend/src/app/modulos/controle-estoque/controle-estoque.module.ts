import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {CONTROLE_ESTOQUE_ROUTES} from "./controle-estoque.module.routes";
import { ControleEstoqueComponent } from './pages/controle-estoque/controle-estoque.component';

@NgModule({
  declarations: [
    ControleEstoqueComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(CONTROLE_ESTOQUE_ROUTES)
  ]
})
export class ControleEstoqueModule {
}
