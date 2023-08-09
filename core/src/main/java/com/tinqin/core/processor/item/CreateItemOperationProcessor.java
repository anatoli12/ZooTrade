package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.create.CreateItemInput;
import com.tinqin.api.operation.item.create.CreateItemOperation;
import com.tinqin.api.operation.item.create.CreateItemOutput;
import com.tinqin.core.exception.TagNotFoundException;
import com.tinqin.core.exception.VendorNotFoundException;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.TagRepository;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.*;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemOperationProcessor implements CreateItemOperation {
  private final VendorRepository vendorRepository;
  private final ItemRepository itemRepository;
  private final TagRepository tagRepository;

  @Override
  public CreateItemOutput process(CreateItemInput input) {
    Set<Vendor> vendorsToAdd =
        input.getVendorIds().stream()
            .map(UUID::fromString)
            .map(
                vendorId ->
                    vendorRepository
                        .findById(vendorId)
                        .orElseThrow(
                            () ->
                                new VendorNotFoundException(vendorId)))
            .collect(Collectors.toSet());

    Set<Tag> tagsToAdd =
        input.getTagIds().stream()
            .map(UUID::fromString)
            .map(
                tagId ->
                    tagRepository
                        .findById(tagId)
                        .orElseThrow(
                            () -> new TagNotFoundException(tagId)))
            .collect(Collectors.toSet());

    Item itemEntity =
        Item.builder()
            .id(UUID.randomUUID())
            .title(input.getTitle())
            .description(input.getDescription())
            .tags(tagsToAdd)
            .vendors(vendorsToAdd)
            .multimedia(new HashSet<>())
                .comments(new ArrayList<>())
            .build();
    itemEntity.setIsDeleted(false);
    itemRepository.save(itemEntity);

    BaseItemDTO base =
        ItemEntityToDTOProcessor.convertEntityToDTO(itemEntity);
    return CreateItemOutput.builder().baseItemDTO(base).build();
  }
}
