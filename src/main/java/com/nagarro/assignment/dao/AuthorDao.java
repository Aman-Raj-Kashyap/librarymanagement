package com.nagarro.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.assignment.model.Author;

public interface AuthorDao extends CrudRepository<Author, Integer> {

	public Author findById(int id);

}
