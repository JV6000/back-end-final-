package jvaicekauskas.backend.controller;

import jvaicekauskas.backend.model.Order;
import jvaicekauskas.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // gauti visus orderius
//    @GetMapping
//    public List<Order> getAllOrders() {
//        return orderService.getAllOrders();
//    }

    // gauti orderi su id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 if not found
    }

    // naujas orderis
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Optional<Order> placedOrder = orderService.placeOrder(order);

        if (placedOrder.isPresent()) {
            return ResponseEntity.ok(placedOrder.get()); // 200 OK with the placed order
        } else {
            return ResponseEntity.status(400).body(null); // 400 Bad Request if not placed
        }
    }

    // istrinti pagal id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully"); // 200 OK
    }
}