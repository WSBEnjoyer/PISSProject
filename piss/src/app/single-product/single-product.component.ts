import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InventoryService } from '../service/inventory.service';
import { Product } from '../service/product';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {

  id!: string | null;
  product!: Product;

  boughtQuantity: number = 0;
  successfulBuying: boolean = false;
  unsuccessfulBuying: boolean = false;

  constructor(private route: ActivatedRoute,
    private inventoryService: InventoryService) {
     }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.inventoryService.getSingleProdutct(this.id).subscribe(product => {
        this.product = product;
      });
    }
  }

  //swy for this UwU
  buy(quantity: { quantity: string; }) {
    this.unsuccessfulBuying = false;
    this.successfulBuying = false;
    
    this.boughtQuantity = parseInt(quantity.quantity);

    if (parseInt(quantity.quantity) > this.product.quantity) {
      this.unsuccessfulBuying = true;
      return
    }
    
    this.product.quantity = this.product.quantity - parseInt(quantity.quantity);
    this.boughtQuantity = parseInt(quantity.quantity);
    this.inventoryService.updateProduct(this.product).subscribe(
      product => {
        this.product = product;
        this.successfulBuying = true;
      }
    );
  }
}
