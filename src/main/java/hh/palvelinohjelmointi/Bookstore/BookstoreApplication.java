package hh.palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("saving books");
			repository.save(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, 49559, 15.99));
			repository.save(new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling", 2009, 39708, 19.99));
			log.info("fetch the books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}

}

