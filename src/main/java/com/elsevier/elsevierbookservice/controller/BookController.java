package com.elsevier.elsevierbookservice.controller;

import com.elsevier.elsevierbookservice.payload.request.BookRequest;
import com.elsevier.elsevierbookservice.payload.response.BookResponse;
import com.elsevier.elsevierbookservice.service.BookService;
import com.elsevier.elsevierbookservice.shared.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  private final ModelMapper modelMapper;

  public BookController(BookService bookService, ModelMapper modelMapper) {
    this.bookService = bookService;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/{id}")
  public BookResponse getBook(@PathVariable UUID id) {
    BookDto bookDto = bookService.getBookById(id);
    return modelMapper.map(bookDto, BookResponse.class);
  }

  @PostMapping
  public BookResponse createBook(@Valid @RequestBody BookRequest bookRequest) {
    BookDto bookDto = modelMapper.map(bookRequest, BookDto.class);
    BookDto savedBookDto = bookService.createBook(bookDto);
    return modelMapper.map(savedBookDto, BookResponse.class);
  }
}
