package com.tinqin.api.operation.item.addvendorstoitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddVendorsToItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
