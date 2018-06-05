package se.lexicon.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.model.Book;

public interface BookRepository extends  JpaRepository<Book, Long>{
	
	public Book findByTitle(String title);
	public Book findById(Long id);
	public Book getById(Long id);
	public List<Book> getByTitle(String title);
	//public Book updateBook(Book bookToUpdate);
	//public void createBook(Book book); Behövs inte eftersom save finns direkt i JpaRepository

}
//spring data project, the JpaRepository is a spring framework class, is a generic