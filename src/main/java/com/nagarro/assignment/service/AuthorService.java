package com.nagarro.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.assignment.dao.AuthorDao;
import com.nagarro.assignment.model.Author;

@Component
public class AuthorService {

	@Autowired
	private AuthorDao authorRepository;

	public List<Author> getAllAuthors() {
		List<Author> author_list = (List<Author>) this.authorRepository.findAll();
		return author_list;
	}

	public Author getAuthorByID(int id) {

		Author author = null;
		try {
			author = this.authorRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;

	}
	
	public Author addAuthor(Author author) {
		
		Author result = authorRepository.save(author);
		return result;
	}
	
	public void deleteAuthor(int id) {
		
		authorRepository.deleteById(id);
	}
	
	public void updateAuthor(Author author, int id) {
		
		author.setId(id);
		authorRepository.save(author);
	}
	
}
