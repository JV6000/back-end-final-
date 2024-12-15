package jvaicekauskas.backend.controller;

import jvaicekauskas.backend.model.Product;
import jvaicekauskas.backend.model.Category;
import jvaicekauskas.backend.model.User;
import jvaicekauskas.backend.service.ProductService;
import jvaicekauskas.backend.service.CategoryService;
import jvaicekauskas.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Nurodo, kad ši klasė yra REST API valdiklis, kuris tvarko HTTP užklausas
@RequestMapping("/admin")  // Visos šios klasės užklausos prasideda nuo "/admin" kelio
public class AdminController {

    // Priklausomybės injekcija: šie serviso komponentai bus įterpti automatiškai
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    // Metodas, kuris gauna visus vartotojus
    @GetMapping("/users")  // HTTP GET užklausa, nukreipta į "/admin/users"
    public List<User> getAllUsers() {
        return userService.getAllUsers();  // Grąžina visus vartotojus naudodamasis userService
    }

    // Metodas, skirtas ištrinti vartotoją pagal ID
    @DeleteMapping("/users/{id}")  // HTTP DELETE užklausa, nukreipta į "/admin/users/{id}", kur {id} yra vartotojo ID
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);  // Ištrina vartotoją pagal pateiktą ID naudodamasis userService
        return ResponseEntity.ok("User deleted successfully");  // Grąžina sėkmingą atsakymą su pranešimu
    }

    // Metodas, skirtas pridėti naują kategoriją
    @PostMapping("/categories")  // HTTP POST užklausa, nukreipta į "/admin/categories"
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.addCategory(category));  // Pridėti kategoriją ir grąžinti ją sėkmingam atsakymui
    }

    // Metodas, skirtas ištrinti kategoriją pagal ID
    @DeleteMapping("/categories/{id}")  // HTTP DELETE užklausa, nukreipta į "/admin/categories/{id}", kur {id} yra kategorijos ID
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);  // Ištrina kategoriją pagal pateiktą ID naudodamasis categoryService
        return ResponseEntity.ok("Category deleted successfully");  // Grąžina sėkmingą atsakymą su pranešimu
    }
}
