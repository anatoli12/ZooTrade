package com.tinqin.api.operation.tag.findbyid;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.tag.BaseTagDTO;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindTagByIdOutput implements ProcessorOutput {
    private BaseTagDTO baseTagDTO;
}
