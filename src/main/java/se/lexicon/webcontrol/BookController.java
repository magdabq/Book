package se.lexicon.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.lexicon.data.BookRepository;
import se.lexicon.model.Book;

@Controller
@RequestMapping("/home/books")
public class BookController {

	@Autowired
	private BookRepository bookRepos;
	
	
	// add book in two steps, first step
	@RequestMapping(value="/newBook.html",method=RequestMethod.GET)
	public ModelAndView renderNewbookForm() {
		Book newBook = new Book();
		return new ModelAndView("newBook", "form", newBook)	;
	}
	
	// *****add book in two steps, second step
	@RequestMapping(value="/newBook.html", method=RequestMethod.POST)
	public String newBook(Book book) {
		bookRepos.save(book);
		return "redirect:/home/books/list.html";
	}

	//******List all books
	@RequestMapping(value="/list.html",method=RequestMethod.GET)
	public ModelAndView books()
	{
		List<Book> allBooks = bookRepos.findAll();
		return new ModelAndView("/allBooks","books", allBooks);
	}
	
	//******delete book *******************
	@RequestMapping(value="/delete/{title}")
	public ModelAndView DeleteBookByTitle(@PathVariable("title") String title) {
		
		Book foundBook = bookRepos.findByTitle(title);
		return new ModelAndView("deleteBook", "form", foundBook)	;
		
		
	}
	
	// *****delete book in two steps, second step
	@RequestMapping(value="/delete/{title}", method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("title") String title) {
		Book foundBook = bookRepos.findByTitle(title);
		bookRepos.delete(foundBook);
		
		return "redirect:/home/books/list.html";
	}
	

	
	
	// show book by Title
	@RequestMapping(value="/book/{title}")
	public ModelAndView showbookById(@PathVariable("title") String title)
	{
			Book book = bookRepos.findByTitle(title);
			{
			return new ModelAndView("bookInfo", "book", book );
			}
			}
}


	

