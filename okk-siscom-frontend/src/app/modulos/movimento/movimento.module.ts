import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {MOVIMENTO_ROUTES} from "./movimento.module.routes";
import {ContasAPagarComponent} from "./componentes/contas-a-pagar/contas-a-pagar.component";
import {ContasAReceberComponent} from "./componentes/contas-a-receber/contas-a-receber.component";
import {VendasComponent} from "./componentes/vendas/vendas.component";

@NgModule({
  declarations: [
    ContasAPagarComponent,
    ContasAReceberComponent,
    VendasComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(MOVIMENTO_ROUTES)
  ]
})
export class MovimentoModule {
}
