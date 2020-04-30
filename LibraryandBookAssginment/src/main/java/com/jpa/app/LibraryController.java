package com.jpa.app;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

	@Autowired
	private LibraryRepository libraryRepository;

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/getAllLibrarysByBookId/{book_id}/librarys")
	public Page<Library> getAllLibrarysByBookId(@PathVariable(value = "book_id") int book_id, Pageable pageable) {
		return libraryRepository.findByBookId(book_id, pageable);
	}

	@GetMapping("/getAllLibrarys")
	public Page<Library> getAllLibrary(Pageable pageable) {
		return libraryRepository.findAll(pageable);
	}

}
