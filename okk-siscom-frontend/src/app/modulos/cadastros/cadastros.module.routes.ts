import {Routes} from "@angular/router";
import {ClientesComponent} from "./componentes/clientes/clientes.component";
import {FornecedorComponent} from "./componentes/fornecedor/fornecedor.component";
import {ContasBancariasComponent} from "./componentes/contas-bancarias/contas-bancarias.component";
import {UnidadesComponent} from "./componentes/unidades/unidades.component";
import {ProdutosComponent} from "./componentes/produtos/produtos.component";
import {CartoesComponent} from "./componentes/cartoes/cartoes.component";
import {
  TipoPagamentoRecebimentoComponent
} from "./componentes/tipo-pagamento-recebimento/tipo-pagamento-recebimento.component";
import {PlanoContasComponent} from "./componentes/plano-contas/plano-contas.component";
import {CadastrosComponent} from "./pages/cadastros/cadastros.component";
import {DepartamentosComponent} from "./componentes/departamentos/departamentos.component";

export const CADASTROS_ROUTES: Routes = [
  {
    path: 'cadastros',
    component: CadastrosComponent,
    children: [
      {
        path: 'clientes',
        component: ClientesComponent,
        outlet: 'routerOutletCadastros',
        pathMatch: 'full'
      },
      {
        path: 'fornecedores',
        pathMatch: 'full',
        component: FornecedorComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'contas-bancarias',
        component: ContasBancariasComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'unidades',
        component: UnidadesComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'produtos',
        component: ProdutosComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'departamentos',
        component: DepartamentosComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'cartoes',
        component: CartoesComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'tipo-pagamento-recebimento',
        component: TipoPagamentoRecebimentoComponent,
        outlet: 'routerOutletCadastros'
      },
      {
        path: 'plano-contas',
        component: PlanoContasComponent,
        outlet: 'routerOutletCadastros'
      }
    ]
  }
];
