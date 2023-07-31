package com.tinqin.core.processor.tag;

import com.tinqin.api.operation.tag.BaseTagDTO;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Tag;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.stream.Collectors;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TagEntityToDTOProcessor {
  public static BaseTagDTO convertEntityToDTO(Tag tag) {
    return BaseTagDTO.builder()
        .id(String.valueOf(tag.getId()))
        .title(tag.getTitle())
        .itemIds(
            tag.getItems().stream()
                .map(Item::getId)
                .map(UUID::toString)
                .collect(Collectors.toSet()))
        .build();
  }
}
