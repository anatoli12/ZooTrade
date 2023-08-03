package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.removemultimediafromitem.RemoveMultimediaFromItemInput;
import com.tinqin.api.operation.item.removemultimediafromitem.RemoveMultimediaFromItemOperation;
import com.tinqin.api.operation.item.removemultimediafromitem.RemoveMultimediaFromItemOutput;
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

@Service
@RequiredArgsConstructor
public class RemoveMultimediaFromItemOperationProcessor implements RemoveMultimediaFromItemOperation {
    private final MultimedaRepository multimedaRepository;
    private final ItemRepository itemRepository;

    @Override
    public RemoveMultimediaFromItemOutput process(RemoveMultimediaFromItemInput request) {
        Item item =
                itemRepository
                        .findById(UUID.fromString(request.getItemId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Set<Multimedia> multimediaToRemove =
                request.getMultimediaIds().stream()
                        .map(UUID::fromString)
                        .map(
                                m ->
                                        multimedaRepository
                                                .findById(m)
                                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
                        .collect(Collectors.toSet());

        Set<Multimedia> itemMultimedia = Optional.ofNullable(item.getMultimedia()).orElseGet(HashSet::new);
        itemMultimedia.removeAll(multimediaToRemove);
        item.setMultimedia(itemMultimedia);
        itemRepository.save(item);

        BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return RemoveMultimediaFromItemOutput.builder().baseItemDTO(base).build();
    }
}
