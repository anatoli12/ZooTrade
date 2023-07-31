package com.tinqin.api.operation.item.findbyid;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindItemByIdOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}