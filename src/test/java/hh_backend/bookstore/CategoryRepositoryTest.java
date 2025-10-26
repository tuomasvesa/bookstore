package hh_backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import hh_backend.bookstore.domain.Category;
import hh_backend.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewCategory() {
        Category category = new Category("Romance");
        categoryRepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategoryById() {
        List<Category> categories = categoryRepository.findByName("Horror");
        Long id = categories.get(0).getCategoryid();
        categoryRepository.deleteById(id);
        assertThat(categoryRepository.findByName("Horror")).hasSize(0);
    }

    @Test
    void findAll() {
        Iterable<Category> categories = categoryRepository.findAll();
        assertThat(categories).hasSize(3);
    }

    @Test
    public void findByName() {
        List<Category> categories = categoryRepository.findByName("Horror");
        assertThat(categories).hasSize(1);
    }

    @Test
    void findById() {
        List<Category> categories = categoryRepository.findByName("Horror");
        Long id = categories.get(0).getCategoryid();
        Optional<Category> foundCategory = categoryRepository.findById(id);
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo("Horror");
    }

    

}
