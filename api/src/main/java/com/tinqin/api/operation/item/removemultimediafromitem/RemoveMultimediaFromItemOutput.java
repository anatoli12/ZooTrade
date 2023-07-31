package com.tinqin.api.operation.item.removemultimediafromitem;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoveMultimediaFromItemOutput implements ProcessorOutput {
    private BaseItemDTO baseItemDTO;
}
