package com.elsevier.elsevierbookservice.service;

import com.elsevier.elsevierbookservice.shared.dto.BookDto;
import com.elsevier.elsevierbookservice.utils.PagedResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BookService {

  PagedResponse<BookDto> getBooks(Pageable pageable);

  BookDto getBookById(UUID id);

  BookDto createBook(BookDto bookDto);
}
