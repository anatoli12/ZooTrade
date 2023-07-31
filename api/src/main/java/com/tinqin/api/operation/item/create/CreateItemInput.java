package com.tinqin.api.operation.item.create;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemInput implements ProcessorInput {

    private String title;
    private String description;
    private Set<String> vendorIds;
//    private Set<String> multimediaIds;
    private Set<String> tagIds;
}