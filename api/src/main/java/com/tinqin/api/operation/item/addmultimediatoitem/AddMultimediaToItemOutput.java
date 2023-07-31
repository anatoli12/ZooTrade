package com.tinqin.api.operation.item.addmultimediatoitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddMultimediaToItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
