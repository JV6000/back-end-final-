package jvaicekauskas.backend.repository;

import jvaicekauskas.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//prideti kazka
    Optional<Order> findById(Long id);

}
