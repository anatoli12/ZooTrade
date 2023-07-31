package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.removetagsfromitem.RemoveTagsFromItemInput;
import com.tinqin.api.operation.item.removetagsfromitem.RemoveTagsFromItemOperation;
import com.tinqin.api.operation.item.removetagsfromitem.RemoveTagsFromItemOutput;
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

@Service
@RequiredArgsConstructor
public class RemoveTagsFromItemOperationProcessor implements RemoveTagsFromItemOperation {

  private final TagRepository tagRepository;
  private final ItemRepository itemRepository;

  @Override
  public RemoveTagsFromItemOutput process(RemoveTagsFromItemInput request) {
    Item item =
        itemRepository
            .findById(UUID.fromString(request.getItemId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Set<Tag> tagsToRemove =
        request.getTagIds().stream()
            .map(UUID::fromString)
            .map(
                t ->
                    tagRepository
                        .findById(t)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
            .collect(Collectors.toSet());

    Set<Tag> itemTags = Optional.ofNullable(item.getTags()).orElseGet(HashSet::new);
    itemTags.removeAll(tagsToRemove);
    item.setTags(itemTags);
    itemRepository.save(item);

    BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
    return RemoveTagsFromItemOutput.builder().baseItemDTO(base).build();
  }
}
