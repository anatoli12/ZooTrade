package com.tinqin.api.operation.vendor;

import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseVendorDTO {
    private String id;
    private String name;
    private Set<String> itemIds;
}
