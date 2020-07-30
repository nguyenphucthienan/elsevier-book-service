package com.elsevier.elsevierbookservice.service.impl;

import com.elsevier.elsevierbookservice.domain.Book;
import com.elsevier.elsevierbookservice.repository.BookRepository;
import com.elsevier.elsevierbookservice.service.BookService;
import com.elsevier.elsevierbookservice.shared.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  private final ModelMapper modelMapper;

  public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
    this.bookRepository = bookRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public BookDto getBookById(UUID id) {
    Book book =
        bookRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Book with ID " + id + " not found"));

    return modelMapper.map(book, BookDto.class);
  }

  @Override
  public BookDto createBook(BookDto bookDto) {
    Book book = modelMapper.map(bookDto, Book.class);
    Book savedBook = bookRepository.save(book);
    return modelMapper.map(savedBook, BookDto.class);
  }
}
