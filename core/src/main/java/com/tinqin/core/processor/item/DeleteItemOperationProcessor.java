package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.delete.DeleteItemInput;
import com.tinqin.api.operation.item.delete.DeleteItemOperation;
import com.tinqin.api.operation.item.delete.DeleteItemOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.repository.ItemRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeleteItemOperationProcessor implements DeleteItemOperation {
    private final ItemRepository itemRepository;
    @Override
    public DeleteItemOutput process(DeleteItemInput request) {
        Item item = itemRepository
                .findById(UUID.fromString(request.getId()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        item.setIsDeleted(true);
        itemRepository.save(item);
        BaseItemDTO base =
                ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return DeleteItemOutput.builder().baseItemDTO(base).build();
    }
}
