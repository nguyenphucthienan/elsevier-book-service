package com.elsevier.elsevierbookservice.service;

import com.elsevier.elsevierbookservice.payload.response.InventoryQuantityResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "inventory-service")
public interface InventoryServiceFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/api/books/{bookId}/inventories")
  ResponseEntity<InventoryQuantityResponse> getBookInventoryQuantityById(
      @PathVariable("bookId") UUID bookId);
}
