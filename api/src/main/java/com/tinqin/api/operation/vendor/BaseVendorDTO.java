package com.tinqin.api.operation.vendor;

import java.util.Set;
import lombok.*;

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
