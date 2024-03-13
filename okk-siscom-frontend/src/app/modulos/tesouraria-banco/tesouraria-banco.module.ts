import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {TESOURARIA_BANCO_ROUTES} from "./tesouraria-banco.module.routes";
import {TesourariaBancoComponent} from './pages/tesouraria-banco/tesouraria-banco.component';

@NgModule({
  declarations: [
    TesourariaBancoComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(TESOURARIA_BANCO_ROUTES)
  ]
})
export class TesourariaBancoModule {
}
