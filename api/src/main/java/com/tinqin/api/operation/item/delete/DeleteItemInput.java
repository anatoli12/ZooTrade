package com.tinqin.api.operation.item.delete;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteItemInput implements ProcessorInput {
    private String id;
}
