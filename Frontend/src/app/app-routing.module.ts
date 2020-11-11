import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FeeComponent } from './fee/fee.component';
import { PriceListComponent } from './price-list/price-list.component';
import { ResidentComponent } from './resident/resident.component';

const routes: Routes = [
  {path: '', component: FeeComponent},
  {path: 'resident', component: ResidentComponent},
  {path: 'pricelist', component: PriceListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
