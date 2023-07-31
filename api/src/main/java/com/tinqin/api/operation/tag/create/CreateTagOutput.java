package com.tinqin.api.operation.tag.create;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.tag.BaseTagDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagOutput implements ProcessorOutput {
    private BaseTagDTO baseTagDTO;
}
