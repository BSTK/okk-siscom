import {Routes} from "@angular/router";
import {ContasAPagarComponent} from "./componentes/contas-a-pagar/contas-a-pagar.component";
import {ContasAReceberComponent} from "./componentes/contas-a-receber/contas-a-receber.component";

export const MOVIMENTO_ROUTES: Routes = [
  {
    path: 'movimento',
    component: ContasAPagarComponent,
    children: [
      {
        path: 'contas-a-pagar',
        component: ContasAPagarComponent
      },
      {
        path: 'contas-a-receber',
        component: ContasAReceberComponent
      }
    ]
  }
];
