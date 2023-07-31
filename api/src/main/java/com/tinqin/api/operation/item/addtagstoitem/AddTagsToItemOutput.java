package com.tinqin.api.operation.item.addtagstoitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddTagsToItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
