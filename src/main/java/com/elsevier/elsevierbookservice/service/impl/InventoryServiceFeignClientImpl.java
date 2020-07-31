package com.elsevier.elsevierbookservice.service.impl;

import com.elsevier.elsevierbookservice.service.InventoryService;
import com.elsevier.elsevierbookservice.service.InventoryServiceFeignClient;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class InventoryServiceFeignClientImpl implements InventoryService {

  private final InventoryServiceFeignClient inventoryServiceFeignClient;

  public InventoryServiceFeignClientImpl(InventoryServiceFeignClient inventoryServiceFeignClient) {
    this.inventoryServiceFeignClient = inventoryServiceFeignClient;
  }

  @Override
  public Long getInventoryQuantityByBookId(UUID bookId) {
    return Objects.requireNonNull(
            inventoryServiceFeignClient.getInventoryQuantityByBookId(bookId).getBody())
        .getQuantity();
  }
}
