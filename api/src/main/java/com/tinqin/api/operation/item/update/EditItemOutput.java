package com.tinqin.api.operation.item.update;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
