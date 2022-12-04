package com.project.inventory.product.ports;

import com.project.inventory.product.ProductService;
import com.project.inventory.product.model.Product;
import com.project.inventory.product.ports.resource.CreateProductResource;
import com.project.inventory.product.ports.resource.ProductConverter;
import com.project.inventory.product.ports.resource.ProductResource;
import com.project.inventory.product.ports.resource.UpdateProductResource;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduct(@PathVariable UUID productId) {
        ProductResource productResource = ProductConverter.convertProduct(productService.findExistingById(productId));
        return ResponseEntity.ok().body(productResource);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProduct(@RequestBody CreateProductResource resource) {
        Product product = productService.create(Product.builder()
                .price(resource.getPrice())
                .description(resource.getDescription())
                .location(resource.getLocation())
                .pictureURL(resource.getPictureURL())
                .name(resource.getName())
                .quantity(resource.getQuantity())
                .build());
        return ResponseEntity.status(201).body(product);
    }

    @PatchMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@PathVariable UUID productId, @RequestBody UpdateProductResource updateProductResource) {
        ProductResource productResource = ProductConverter.convertProduct(productService.update(productId, updateProductResource));
        return ResponseEntity.ok().body(productResource);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }

}
