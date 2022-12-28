import { Component, OnInit } from '@angular/core';
import { InventoryService } from '../service/inventory.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {

  products = []
  displayedColumns: string[] = ['name', 'price', 'quantity', 'location'];

  constructor(
    private inventoryService: InventoryService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.inventoryService.getAllProducts().subscribe(products => {
      this.products = products;
    });

  }

}
