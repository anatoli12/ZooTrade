package com.tinqin.api.operation.tag.findbyid;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindTagByIdInput implements ProcessorInput {
    private String id;
}
