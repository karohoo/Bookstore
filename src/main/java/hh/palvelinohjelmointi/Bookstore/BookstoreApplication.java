package hh.palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.Bookstore.domain.Category;
import hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;
import hh.palvelinohjelmointi.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookrepository, CategoryRepository categoryrepository) {
		return (args) -> {
			log.info("saving books");
			categoryrepository.save(new Category("Fantasy"));
			categoryrepository.save(new Category("Horror"));
			categoryrepository.save(new Category("Comic book"));
			bookrepository.save(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 
					1997, "2545-45646496", 15.99, categoryrepository.findByName("Fantasy").get(0)));
			bookrepository.save(new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling", 
					2009, "3564970-65465468", 19.99, categoryrepository.findByName("Fantasy").get(0)));
			log.info("fetch all books");
			for (Book book : bookrepository.findAll()) {
				log.info(book.toString());
			}
	
		};
	}

}

