package com.jpa.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/getAllBooks")
	public Page<Book> getAllPosts(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@PostMapping("/PostBook")
	public Book createPost(@Valid @RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/BookUpdate/{id}")
	public Book updatePost(@PathVariable Long id, @Valid @RequestBody Book bookRequest) {
		bookRepository.save(bookRequest);
		return bookRequest;
	}

	@DeleteMapping("/BookDelete/{id}")
	public String deletePost(@PathVariable Long id) {
		bookRepository.delete(id);
		return "deleted";
	}

}
