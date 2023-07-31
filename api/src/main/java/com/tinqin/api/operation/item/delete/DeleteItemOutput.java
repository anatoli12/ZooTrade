package com.tinqin.api.operation.item.delete;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
