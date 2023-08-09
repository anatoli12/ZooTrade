package com.tinqin.api.operation.item.findallregex;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.BaseItemDTO;
import java.util.List;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllItemsRegexOutput implements ProcessorOutput {
    private List<BaseItemDTO> items;
}
