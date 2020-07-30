package com.elsevier.elsevierbookservice.service.impl;

import com.elsevier.elsevierbookservice.payload.response.AuthorResponse;
import com.elsevier.elsevierbookservice.service.AuthorService;
import com.elsevier.elsevierbookservice.service.AuthorServiceFeignClient;
import com.elsevier.elsevierbookservice.shared.dto.AuthorDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorServiceFeignClientImpl implements AuthorService {

  private final AuthorServiceFeignClient authorServiceFeignClient;

  private final ModelMapper modelMapper;

  public AuthorServiceFeignClientImpl(
      AuthorServiceFeignClient authorServiceFeignClient, ModelMapper modelMapper) {
    this.authorServiceFeignClient = authorServiceFeignClient;
    this.modelMapper = modelMapper;
  }

  @Override
  public AuthorDto getAuthor(UUID id) {
    ResponseEntity<AuthorResponse> responseEntity = authorServiceFeignClient.getAuthor(id);
    return modelMapper.map(responseEntity.getBody(), AuthorDto.class);
  }
}
