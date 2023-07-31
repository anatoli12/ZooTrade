package com.tinqin.api.operation.tag.create;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagInput implements ProcessorInput {
    private String title;
}
