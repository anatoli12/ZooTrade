package com.tinqin.api.operation.item.findall;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import java.util.List;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllItemsOutput implements ProcessorOutput {
    private List<BaseItemDTO> items;
}

