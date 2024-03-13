import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {CADASTROS_ROUTES} from "./cadastros.module.routes";
import {CadastrosComponent} from './pages/cadastros/cadastros.component';
import {CartoesComponent} from "./componentes/cartoes/cartoes.component";
import {ClientesComponent} from "./componentes/clientes/clientes.component";
import {UnidadesComponent} from "./componentes/unidades/unidades.component";
import {ProdutosComponent} from "./componentes/produtos/produtos.component";
import {FornecedorComponent} from "./componentes/fornecedor/fornecedor.component";
import {PlanoContasComponent} from "./componentes/plano-contas/plano-contas.component";
import {DepartamentosComponent} from "./componentes/departamentos/departamentos.component";
import {ContasBancariasComponent} from "./componentes/contas-bancarias/contas-bancarias.component";
import {
  TipoPagamentoRecebimentoComponent
} from "./componentes/tipo-pagamento-recebimento/tipo-pagamento-recebimento.component";

@NgModule({
  declarations: [
    CartoesComponent,
    ClientesComponent,
    UnidadesComponent,
    ProdutosComponent,
    FornecedorComponent,
    PlanoContasComponent,
    DepartamentosComponent,
    ContasBancariasComponent,
    TipoPagamentoRecebimentoComponent,
    CadastrosComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(CADASTROS_ROUTES)
  ]
})
export class CadastrosModule {
}
