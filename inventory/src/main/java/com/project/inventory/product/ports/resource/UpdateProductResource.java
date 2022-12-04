package com.project.inventory.product.ports.resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductResource {
    private final String name;

    private final String price;

    private final int quantity;

    private final String description;

    private final String pictureURL;

    private final String location;
}
