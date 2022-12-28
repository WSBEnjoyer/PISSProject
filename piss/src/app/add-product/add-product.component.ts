import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InventoryService } from '../service/inventory.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  productAdded: boolean = false;
  constructor(private fb: FormBuilder,
    private inventoryService: InventoryService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: [null, [Validators.required]],
      price: [null, [Validators.required, Validators.pattern("^[0-9.]*$")]],
      quantity: [null, [Validators.required, Validators.pattern("^[0-9]*$")]],
      description: [null],
      pictureURL: [null],
      location: [null, [Validators.required]]
    });
  }

  saveDetails(form: any) {
    this.inventoryService.addProduct(form.value);
    this.productAdded = true;
    this.form.reset();
  }

}
