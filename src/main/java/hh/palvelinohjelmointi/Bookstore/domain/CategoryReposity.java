package hh.palvelinohjelmointi.Bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CategoryReposity extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);

}
