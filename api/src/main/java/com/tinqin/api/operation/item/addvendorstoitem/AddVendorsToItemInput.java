package com.tinqin.api.operation.item.addvendorstoitem;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddVendorsToItemInput implements ProcessorInput {
    private String itemId;
    private Set<String> vendorIds;
}
