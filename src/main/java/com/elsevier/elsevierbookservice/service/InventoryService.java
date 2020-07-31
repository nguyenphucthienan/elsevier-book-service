package com.elsevier.elsevierbookservice.service;

import java.util.UUID;

public interface InventoryService {

  Long getInventoryQuantityByBookId(UUID bookId);
}
