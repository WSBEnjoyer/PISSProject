package com.project.inventory.product.ports.resource;

import com.project.inventory.product.model.Product;

public class ProductConverter {
    public static ProductResource convertProduct(Product product) {
        return ProductResource.builder()
                .id(product.getId())
                .description(product.getDescription())
                .location(product.getLocation())
                .name(product.getName())
                .pictureURL(product.getPictureURL())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
