package com.elsevier.elsevierbookservice.service.impl;

import com.elsevier.elsevierbookservice.domain.Book;
import com.elsevier.elsevierbookservice.repository.BookRepository;
import com.elsevier.elsevierbookservice.service.AuthorService;
import com.elsevier.elsevierbookservice.service.BookService;
import com.elsevier.elsevierbookservice.shared.dto.AuthorDto;
import com.elsevier.elsevierbookservice.shared.dto.BookDto;
import com.elsevier.elsevierbookservice.utils.PagedResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  private final AuthorService authorService;

  private final ModelMapper modelMapper;

  public BookServiceImpl(
      BookRepository bookRepository, AuthorService authorService, ModelMapper modelMapper) {
    this.bookRepository = bookRepository;
    this.authorService = authorService;
    this.modelMapper = modelMapper;
  }

  @Override
  public PagedResponse<BookDto> getBooks(Pageable pageable) {
    Page<Book> bookPage = bookRepository.findAll(pageable);

    List<BookDto> bookDtos =
        modelMapper.map(bookPage.getContent(), new TypeToken<List<BookDto>>() {}.getType());

    return new PagedResponse<>(
        bookDtos,
        bookPage.getNumber(),
        bookPage.getSize(),
        bookPage.getTotalElements(),
        bookPage.getTotalPages(),
        bookPage.isFirst(),
        bookPage.isLast());
  }

  @Override
  public BookDto getBookById(UUID id) {
    Book book =
        bookRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Book with ID " + id + " not found"));

    AuthorDto authorDto = authorService.getAuthor(book.getAuthorId());
    BookDto bookDto = modelMapper.map(book, BookDto.class);
    bookDto.setAuthor(authorDto);
    return bookDto;
  }

  @Override
  public BookDto createBook(BookDto bookDto) {
    Book book = modelMapper.map(bookDto, Book.class);
    Book savedBook = bookRepository.save(book);
    return modelMapper.map(savedBook, BookDto.class);
  }
}
