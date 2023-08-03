package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemInput;
import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemOperation;
import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Multimedia;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.MultimedaRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class AddMultimediaToItemOperationProcessor implements AddMultimediaToItemOperation {

    private final MultimedaRepository multimedaRepository;
    private final ItemRepository itemRepository;
    @Override
    public AddMultimediaToItemOutput process(AddMultimediaToItemInput request) {
        Item item =
                itemRepository
                        .findById(UUID.fromString(request.getItemId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Set<Multimedia> multimediaToAdd =
                request.getMultimediaIds().stream()
                        .map(UUID::fromString)
                        .map(m -> multimedaRepository
                                .findById(m)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
                        .collect(Collectors.toSet());
        Set<Multimedia> itemMultimedia =
                Optional.ofNullable(item.getMultimedia()).orElseGet(HashSet::new);

        itemMultimedia.addAll(multimediaToAdd);
        item.setMultimedia(itemMultimedia);
        itemRepository.save(item);
        BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return AddMultimediaToItemOutput.builder().baseItemDTO(base).build();
    }
}
