import {HomeComponent} from "./pages/home/home.component";
import {Routes} from "@angular/router";

export const HOME_ROUTES: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
];
