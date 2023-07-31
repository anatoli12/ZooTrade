package com.tinqin.api.operation.item.create;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}