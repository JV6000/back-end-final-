package jvaicekauskas.backend.repository;

import jvaicekauskas.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // prideti kazka
    Product findByName(String name);
}
