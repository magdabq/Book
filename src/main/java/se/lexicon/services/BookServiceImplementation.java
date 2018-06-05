package se.lexicon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lexicon.data.BookNotFoundException;
import se.lexicon.data.BookRepository;
import se.lexicon.model.Book;


@Service
public class BookServiceImplementation implements BookService {
	
	private BookRepository repos;
	
	@Autowired
	public BookServiceImplementation(BookRepository repos) {
		this.repos = repos;
	}
	
	@Override
	public void createBook(Book newBook) {
		repos.save(newBook);	
	}

	@Override
	public void updateBook(Book bookToChange) {
		repos.save(bookToChange);
	}
	

	@Override
	public void deleteBook(Book bookToDelete) throws BookNotFoundException {
		repos.delete(bookToDelete);
	}
	
	
	@Override
	public Book getBookById(Long id) throws BookNotFoundException {
		return repos.getById(id);
	}
		
	@Override
	public List<Book> getBookByTitle(String title) throws BookNotFoundException {
		
		return repos.getByTitle(title);
	}

	@Override
	public List<Book> getAllBooks() {
		return repos.findAll();	
	}

	@Override
	public Book findBookByTitle(String title) throws BookNotFoundException {
		return repos.findByTitle(title);
	}

	

	

}
