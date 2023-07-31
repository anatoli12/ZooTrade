package com.tinqin.api.operation.item.removetagsfromitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveTagsFromItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}