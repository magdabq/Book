package se.lexicon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String ISBN;
	private String author;
	
	
	public Book () {		
	}
	
	public Book (String title, String ISBN, String author) {
		this.title = title;
		this.ISBN= ISBN;
		this.author = author;	
	}

	@Override
	public String toString() {
		return "Book Id:=" + id  + "   Title:  " + title +  "    Author:" + author + "ISBN:   " + ISBN;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getISBN() {
		return ISBN;
		
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}

