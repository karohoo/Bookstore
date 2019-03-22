package hh.palvelinohjelmointi.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.Bookstore.domain.Book;
import hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepoTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book>books = repository.findByTitle("Harry Potter and the Philosopher's Stone");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J. K. Rowling");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Harry Potter and the Order of Phoenix", "J. K. Rowling", 2003, "265656-64564654", 15.90, new Category("Scifi"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}