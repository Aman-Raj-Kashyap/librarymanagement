package com.nagarro.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment.model.Author;
import com.nagarro.assignment.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAuthors() {
		List<Author> author_list = authorService.getAllAuthors();
		if (author_list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(author_list));
	}

	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthorByID(@PathVariable("id") int id) {

		Author author = authorService.getAuthorByID(id);
		if (author == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(author));
	}

	@PostMapping("/author")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		Author added_author = null;

		try {
			added_author = this.authorService.addAuthor(author);
			return ResponseEntity.of(Optional.of(added_author));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/author/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable("id") int id) {

		try {
			this.authorService.deleteAuthor(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {

		try {
			this.authorService.updateAuthor(author, id);
			return ResponseEntity.ok().body(author);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
