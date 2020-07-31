package com.elsevier.elsevierbookservice.payload.response;

import java.util.UUID;

public class BookDetailResponse {

  private UUID id;
  private String title;
  private String isbn;
  private AuthorResponse author;
  private String description;
  private Long price;
  private Long quantity = 0L;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public AuthorResponse getAuthor() {
    return author;
  }

  public void setAuthor(AuthorResponse author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }
}
