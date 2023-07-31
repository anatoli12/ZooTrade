package com.tinqin.api.operation.item.findbyid;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindItemByIdInput implements ProcessorInput {
    private String id;
}
