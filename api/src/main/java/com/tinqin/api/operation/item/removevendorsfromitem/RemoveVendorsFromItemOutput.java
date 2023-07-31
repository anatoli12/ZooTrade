package com.tinqin.api.operation.item.removevendorsfromitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveVendorsFromItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
