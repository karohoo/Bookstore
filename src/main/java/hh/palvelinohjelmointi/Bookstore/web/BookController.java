package hh.palvelinohjelmointi.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.Bookstore.domain.*;
 

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private CategoryRepository categoryrepository;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mainPage() {
		return "mainpage";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String bookList(Model model) {
		model.addAttribute("books", bookrepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> getBooksRest() {
		return (List<Book>) bookrepository.findAll();
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Book> getBookRest(@PathVariable("id") Long bookId) {
		return bookrepository.findById(bookId);
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Book book) {
		bookrepository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookrepository.deleteById(id);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String addBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookrepository.findById(id));
		model.addAttribute("category", categoryrepository.findAll());
		return "editbook";
	}
	
}
