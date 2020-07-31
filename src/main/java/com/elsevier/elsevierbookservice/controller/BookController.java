package com.elsevier.elsevierbookservice.controller;

import com.elsevier.elsevierbookservice.payload.request.BookRequest;
import com.elsevier.elsevierbookservice.payload.response.BookDetailResponse;
import com.elsevier.elsevierbookservice.payload.response.BookResponse;
import com.elsevier.elsevierbookservice.service.BookService;
import com.elsevier.elsevierbookservice.shared.dto.BookDto;
import com.elsevier.elsevierbookservice.utils.PagedResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
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

  @GetMapping
  public PagedResponse<BookResponse> getBooks(Pageable pageable) {
    PagedResponse<BookDto> bookDtoPagedResponse = bookService.getBooks(pageable);

    List<BookResponse> bookResponses =
        modelMapper.map(
            bookDtoPagedResponse.getContent(), new TypeToken<List<BookResponse>>() {}.getType());

    return new PagedResponse<>(bookResponses, bookDtoPagedResponse.getPagination());
  }

  @GetMapping("/{id}")
  public BookDetailResponse getBook(@PathVariable UUID id) {
    BookDto bookDto = bookService.getBookById(id);
    return modelMapper.map(bookDto, BookDetailResponse.class);
  }

  @PostMapping
  public BookResponse createBook(@Valid @RequestBody BookRequest bookRequest) {
    BookDto bookDto = modelMapper.map(bookRequest, BookDto.class);
    BookDto savedBookDto = bookService.createBook(bookDto);
    return modelMapper.map(savedBookDto, BookResponse.class);
  }
}
