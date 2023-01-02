package com.project.inventory.product.model;

import com.project.inventory.product.ports.resource.CreateProductResource;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private UUID id;

    private String name;

    private String price;

    private int quantity;

    private String description;

    @Column(name="picture_url")
    private String pictureURL;

    private String location;

    @Builder
    public Product(String name, String price, int quantity, String description, String pictureURL, String location) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.pictureURL = pictureURL;
        this.location = location;
    }
}