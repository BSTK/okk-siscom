import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {CONFIGURACOES_ROUTES} from "./configuracoes.module.routes";
import { ConfiguracoesComponent } from './pages/configuracoes/configuracoes.component';

@NgModule({
  declarations: [
    ConfiguracoesComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(CONFIGURACOES_ROUTES)
  ]
})
export class ConfiguracoesModule {
}
