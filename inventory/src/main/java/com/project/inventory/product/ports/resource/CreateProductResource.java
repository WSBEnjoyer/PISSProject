package com.project.inventory.product.ports.resource;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateProductResource {
    private final String name;

    private final String price;

    private final int quantity;

    private final String description;

    private final String pictureURL;

    private final String location;
}
