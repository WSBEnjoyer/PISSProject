package com.project.inventory.product;

import com.project.inventory.product.model.Product;
import com.project.inventory.product.ports.resource.UpdateProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Product findExistingById(UUID productId) {
        return productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Product create(Product product) {
        Product createdProduct = productRepository.save(product);
        //log.info("Product created. [id = {}]", createdProduct.getId());
        return createdProduct;
    }

    @Transactional
    public Product update(UUID productId, UpdateProductResource updateProductResource) {
        Product product = findExistingById(productId);

        product.setDescription(updateProductResource.getDescription());
        product.setLocation(updateProductResource.getLocation());
        product.setPrice(updateProductResource.getPrice());
        product.setName(updateProductResource.getName());
        product.setPictureURL(updateProductResource.getPictureURL());

        Product updatedProduct = productRepository.save(product);

        //log.info("Product updated. [id = {}]", updatedProduct.getId());
        return updatedProduct;
    }

    @Transactional
    public void delete(UUID productId) {
        Product existingProduct = findExistingById(productId);
        productRepository.delete(existingProduct);
        //log.info("Product deleted. [id = {}]", productId);
    }
}
