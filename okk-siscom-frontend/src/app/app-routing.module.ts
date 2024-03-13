import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module')
      .then(module => module.HomeModule)
  },
  {
    path: 'cadastros',
    loadChildren: () => import('./modulos/cadastros/cadastros.module')
      .then(module => module.CadastrosModule)
  },
  {
    path: 'compras',
    loadChildren: () => import('./modulos/compras/compras.module')
      .then(module => module.ComprasModule)
  },
  {
    path: 'configuracoes',
    loadChildren: () => import('./modulos/configuracoes/configuracoes.module')
      .then(module => module.ConfiguracoesModule)
  },
  {
    path: 'controle-estoque',
    loadChildren: () => import('./modulos/controle-estoque/controle-estoque.module')
      .then(module => module.ControleEstoqueModule)
  },
  {
    path: 'movimento',
    loadChildren: () => import('./modulos/movimento/movimento.module')
      .then(module => module.MovimentoModule)
  },
  {
    path: 'tesouraria-banco',
    loadChildren: () => import('./modulos/tesouraria-banco/tesouraria-banco.module')
      .then(module => module.TesourariaBancoModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
