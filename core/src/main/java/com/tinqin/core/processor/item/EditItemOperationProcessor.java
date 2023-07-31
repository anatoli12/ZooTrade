package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.update.EditItemInput;
import com.tinqin.api.operation.item.update.EditItemOperation;
import com.tinqin.api.operation.item.update.EditItemOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.repository.ItemRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class EditItemOperationProcessor implements EditItemOperation {
  private final ItemRepository itemRepository;

  @Override
  public EditItemOutput process(EditItemInput request) {
    Item item =
        itemRepository
            .findById(UUID.fromString(request.getId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    item.setTitle(request.getTitle());
    item.setDescription(request.getDescription());
    itemRepository.save(item);
    BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
    return EditItemOutput.builder().baseItemDTO(base).build();
  }
}
