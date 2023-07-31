package com.tinqin.api.operation.tag.edit;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.tag.BaseTagDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditTagOutput implements ProcessorOutput {
    private BaseTagDTO baseTagDTO;
}
