package se.lexicon.services;

import java.util.List;

import se.lexicon.data.BookNotFoundException;
import se.lexicon.model.Book;

public interface BookService {

	public void createBook(Book newBook);
	public void updateBook(Book bookToChange);
	public void deleteBook(Book deletedBook) throws BookNotFoundException;
	public Book getBookById(Long id) throws BookNotFoundException;
	public List<Book> getBookByTitle(String title) throws BookNotFoundException;
	public Book findBookByTitle (String title) throws BookNotFoundException;
	public List<Book> getAllBooks();
	
}
	
	
	