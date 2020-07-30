package com.elsevier.elsevierbookservice.service;

import com.elsevier.elsevierbookservice.shared.dto.AuthorDto;

import java.util.UUID;

public interface AuthorService {

  AuthorDto getAuthor(UUID id);
}
