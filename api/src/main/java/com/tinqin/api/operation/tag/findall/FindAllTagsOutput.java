package com.tinqin.api.operation.tag.findall;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.tag.BaseTagDTO;
import java.util.Set;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindAllTagsOutput implements ProcessorOutput {
    private Set<BaseTagDTO> tags;
}
