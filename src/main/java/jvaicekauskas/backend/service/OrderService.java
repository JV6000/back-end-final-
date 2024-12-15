package jvaicekauskas.backend.service;

import jvaicekauskas.backend.model.Order;
import jvaicekauskas.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // Nurodo, kad ši klasė yra Spring service komponentas, kuri teikia logiką paslaugų teikimui
public class OrderService {

    @Autowired  // Automatiškai įterpia OrderRepository priklausomybę (OrderRepository naudojamas prieiga prie duomenų bazės)
    private OrderRepository orderRepository;

    // Metodas, skirtas gauti užsakymą pagal ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id); // Ieško užsakymo pagal pateiktą ID ir grąžina Optional<Order> (tuščią arba su užsakymu)
    }

    // Metodas, skirtas sukurti užsakymą
    public Optional<Order> placeOrder(Order order) {
        try {
            Order savedOrder = orderRepository.save(order); // Išsaugo užsakymą į duomenų bazę
            return Optional.of(savedOrder); // Grąžina užsakymą, suvyniotą į Optional (saugiau nei tiesiog grąžinti null)
        } catch (Exception e) {
            return Optional.empty(); // Jei įvyksta klaida, grąžinama tuščia Optional reikšmė
        }
    }

    // Metodas, skirtas ištrinti užsakymą pagal ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id); // Ištrina užsakymą iš duomenų bazės pagal ID
    }
}
