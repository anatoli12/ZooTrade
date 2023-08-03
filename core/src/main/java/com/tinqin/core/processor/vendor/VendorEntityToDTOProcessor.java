package com.tinqin.core.processor.vendor;

import com.tinqin.api.operation.vendor.BaseVendorDTO;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Vendor;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VendorEntityToDTOProcessor {
  public static BaseVendorDTO convertEntityToDTO(Vendor vendor) {
    return BaseVendorDTO.builder()
        .id(String.valueOf(vendor.getId()))
        .name(vendor.getName())
        .itemIds(
            vendor.getItems().stream()
                .map(Item::getId)
                .map(UUID::toString)
                .collect(Collectors.toSet()))
        .build();
  }
}
