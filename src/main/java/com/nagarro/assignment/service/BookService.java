package com.nagarro.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.assignment.dao.BookDao;
import com.nagarro.assignment.model.Book;

@Component
public class BookService {

	@Autowired
	private BookDao bookRepository;

	public List<Book> getAllBooks() {
		List<Book> book_list = (List<Book>) this.bookRepository.findAll();
		return book_list;
	}

	public Book getBookByID(int id) {

		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}
	
	public Book addBook(Book book) {
		
		Book result = bookRepository.save(book);
		return result;
	}
	
	public void deleteBook(int id) {
		
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book book, int id) {
		
		book.setCode(id);
		bookRepository.save(book);
	}
	
}
