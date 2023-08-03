package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.addtagstoitem.AddTagsToItemInput;
import com.tinqin.api.operation.item.addtagstoitem.AddTagsToItemOperation;
import com.tinqin.api.operation.item.addtagstoitem.AddTagsToItemOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.TagRepository;
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
public class AddTagsToItemOperationProcessor implements AddTagsToItemOperation {
    private final TagRepository tagRepository;
    private final ItemRepository itemRepository;
    @Override
    public AddTagsToItemOutput process(AddTagsToItemInput request) {
        Item item =
                itemRepository
                        .findById(UUID.fromString(request.getItemId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Set<Tag> tagsToAdd =
                request.getTagIds().stream()
                        .map(UUID::fromString)
                        .map(t -> tagRepository
                                .findById(t)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
                        .collect(Collectors.toSet());
        Set<Tag> itemTags =
                Optional.ofNullable(item.getTags()).orElseGet(HashSet::new);

        itemTags.addAll(tagsToAdd);
        item.setTags(itemTags);
        itemRepository.save(item);
        BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return AddTagsToItemOutput.builder().baseItemDTO(base).build();
    }
}
