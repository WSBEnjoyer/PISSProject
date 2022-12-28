import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SingleProductComponent } from './single-product/single-product.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'products', component: AllProductsComponent},
  { path: 'product/:id', component: SingleProductComponent},
  { path: 'new-product', component: AddProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
