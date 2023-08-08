package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.persistence.model.*;

import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ItemEntityToDTOProcessor{
    public static BaseItemDTO convertEntityToDTO(Item itemEntity) {
    return BaseItemDTO.builder()
        .id(String.valueOf(itemEntity.getId()))
        .title(itemEntity.getTitle())
        .description(itemEntity.getDescription())
        .deleted(itemEntity.getIsDeleted())
        .tagIds(
            itemEntity.getTags().stream()
                .map(Tag::getId)
                .map(UUID::toString)
                .collect(Collectors.toSet()))
        .multimediaIds(
            itemEntity.getMultimedia().stream()
                .map(Multimedia::getId)
                .map(UUID::toString)
                .collect(Collectors.toSet()))
        .vendorIds(
            itemEntity.getVendors().stream()
                .map(Vendor::getId)
                .map(UUID::toString)
                .collect(Collectors.toSet()))
        .commentIds(itemEntity.getComments().stream()
                .map(Comment::getCommentId)
                .toList())
        .build();
    }

}
