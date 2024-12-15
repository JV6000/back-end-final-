package jvaicekauskas.backend.repository;

import jvaicekauskas.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Nurodo, kad ši klasė yra Spring Data repository komponentas,
// skirtas dirbti su duomenų baze
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Papildomas metodas, kuris leidžia rasti kategoriją pagal pavadinimą
    // JpaRepository jau turi standartinius metodus, tokius kaip findAll(), save(), deleteById() ir pan.
    Category findByName(String name);  // Šis metodas generuoja užklausą, kuri ieško
    // Category pagal pavadinimą
}
