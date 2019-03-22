package hh.palvelinohjelmointi.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.Bookstore.domain.Category;
import hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepoTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnId() {
        List<Category>categories = repository.findByName("Fantasy");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryId()).isEqualTo(1L);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Drama");
    	repository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }    

}