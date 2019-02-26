package hh.palvelinohjelmointi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.palvelinohjelmointi.Bookstore.domain.*;
 

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private CategoryReposity categoryreposity;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mainPage() {
		return "mainpage";
	}
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookrepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryreposity.findAll());
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
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(Model model) {
		model.addAttribute("book", );
		return "editbook";
	}
	
}
