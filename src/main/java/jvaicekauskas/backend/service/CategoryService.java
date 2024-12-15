package jvaicekauskas.backend.service;

import jvaicekauskas.backend.model.Category;
import jvaicekauskas.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // prideti nauja kategorija
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // gauti visas kategorijas
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // istrinti pagal id
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category with ID " + id + " not found");
        }
    }
}
