package com.tinqin.api.operation.item.create;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemInput implements ProcessorInput {

    private String title;
    private String description;
    private Set<String> vendorIds;
    private Set<String> tagIds;
}