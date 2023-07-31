package com.tinqin.api.operation.item.update;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditItemInput implements ProcessorInput {
    private String id;
    private String title;
    private String description;
}
