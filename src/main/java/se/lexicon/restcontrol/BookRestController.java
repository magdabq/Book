package se.lexicon.restcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.data.BookNotFoundException;
import se.lexicon.model.Book;
import se.lexicon.services.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value= "/book/id/{id}", method=RequestMethod.GET)
	public Book getBookById(@PathVariable Long id) 
	{
		Book foundBook;
		try {

			foundBook = bookService.getBookById(id);
		}
		catch (BookNotFoundException e)
		{
			throw new RuntimeException(e);
		} 
		return foundBook;
	}
	
	@RequestMapping(value="/book/title/{title}", method=RequestMethod.GET)
	public List<Book> getBookByTitle(@PathVariable String title) throws BookNotFoundException{
		return bookService.getBookByTitle(title);
		
	}

	@RequestMapping(value= "/book/list", method=RequestMethod.GET)
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();

	}
	
	@RequestMapping(value="/book", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public void createBook(@RequestBody Book newBook) {
		bookService.createBook(newBook);
		
	}
	@RequestMapping(value="/book/{id}", method=RequestMethod.DELETE)
	public void deleteBookById(@PathVariable Long id) throws BookNotFoundException{
		
		Book bookToDelete = bookService.getBookById(id);
		bookService.deleteBook(bookToDelete);			
	}	
	
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.PUT)
	public void updateBook(@RequestBody Book bookToChange) throws BookNotFoundException{
		
		bookService.updateBook(bookToChange);			
	}
}