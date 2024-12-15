package jvaicekauskas.backend.service;

import jvaicekauskas.backend.model.Product;
import jvaicekauskas.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // randa visus produktus
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // randa produkta pagal id
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(productRepository.findById(id).orElse(null));
    }


    // prideda nauja produkta
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // atnaujina jau esama produkta
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // istrina produkta pagal id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
