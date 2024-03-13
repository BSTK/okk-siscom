import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from './pages/home/home.component';
import {HOME_ROUTES} from "./home.module.routes";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    HomeComponent
  ],
  exports: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(HOME_ROUTES)
  ]
})
export class HomeModule {
}
