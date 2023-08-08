package com.tinqin.api.operation.item.addcommenttoitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentToItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
