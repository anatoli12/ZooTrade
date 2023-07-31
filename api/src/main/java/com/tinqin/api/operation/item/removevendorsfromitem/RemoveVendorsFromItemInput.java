package com.tinqin.api.operation.item.removevendorsfromitem;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemoveVendorsFromItemInput implements ProcessorInput {
    private String itemId;
    private Set<String> vendorIds;
}


