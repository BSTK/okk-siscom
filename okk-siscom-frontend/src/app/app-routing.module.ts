import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./home/home.module')
      .then(module => module.HomeModule)
  },
  {
    path: '',
    loadChildren: () => import('./modulos/cadastros/cadastros.module')
      .then(module => module.CadastrosModule)
  },
  {
    path: '',
    loadChildren: () => import('./modulos/compras/compras.module')
      .then(module => module.ComprasModule)
  },
  {
    path: '',
    loadChildren: () => import('./modulos/configuracoes/configuracoes.module')
      .then(module => module.ConfiguracoesModule)
  },
  {
    path: '',
    loadChildren: () => import('./modulos/controle-estoque/controle-estoque.module')
      .then(module => module.ControleEstoqueModule)
  },
  {
    path: '',
    loadChildren: () => import('./modulos/movimento/movimento.module')
      .then(module => module.MovimentoModule)
  },
  {
    path: '',
    loadChildren: () => import('./modulos/tesouraria-banco/tesouraria-banco.module')
      .then(module => module.TesourariaBancoModule)
  },
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
