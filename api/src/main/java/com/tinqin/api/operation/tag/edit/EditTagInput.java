package com.tinqin.api.operation.tag.edit;

import com.tinqin.api.base.ProcessorInput;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditTagInput implements ProcessorInput {
    private String id;
    private String title;
}
