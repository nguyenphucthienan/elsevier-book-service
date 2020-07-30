package com.elsevier.elsevierbookservice.service;

import com.elsevier.elsevierbookservice.shared.dto.BookDto;

import java.util.UUID;

public interface BookService {

  BookDto getBookById(UUID id);

  BookDto createBook(BookDto bookDto);
}
