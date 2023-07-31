package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.findbyid.FindItemByIdInput;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOperation;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FindItemByIdByIdOperationProcessor implements FindItemByIdOperation {
    private final ItemRepository itemRepository;
    @Override
    public FindItemByIdOutput process(FindItemByIdInput request) {
        Item item =
                itemRepository
                        .findById(UUID.fromString(request.getId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return FindItemByIdOutput.builder().baseItemDTO(base).build();
    }
}
