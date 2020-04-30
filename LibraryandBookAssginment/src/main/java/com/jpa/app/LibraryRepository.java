package com.jpa.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	Page<Library> findByBookId(int book_id, Pageable pageable);

	List<Library> findByBookId(int book_id);

	Optional<Library> findByIdAndBookId(int id, int book_Id);
}