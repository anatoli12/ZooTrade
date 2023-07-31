package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Multimedia;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.model.Vendor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.stream.Collectors;
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
                .build();
    }

}
