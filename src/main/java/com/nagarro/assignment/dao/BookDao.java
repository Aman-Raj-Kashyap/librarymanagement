package com.nagarro.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.assignment.model.Book;

public interface BookDao extends CrudRepository<Book, Integer>{

	public Book findById(int id);
	
}
