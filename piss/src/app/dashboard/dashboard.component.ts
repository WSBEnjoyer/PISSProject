import { Component, OnInit } from '@angular/core';
import { InventoryService } from '../service/inventory.service';
import { Product } from '../service/product'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  numberOfProducts: number = 0;
  numberOfOutOfStockProducts: number = 0;

  constructor(private inventoryService: InventoryService) { }

  ngOnInit(): void {
    this.inventoryService.getAllProducts().subscribe(
      res => {
        let products: Product[] = []
        products = res
        this.numberOfProducts = products.length;

        products.map(product => { 
          if (product.quantity == 0) {
            this.numberOfOutOfStockProducts++
          }
          })
      }
    )
  }
    
}
