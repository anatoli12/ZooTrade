package com.tinqin.api.operation.item.removetagsfromitem;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemoveTagsFromItemInput implements ProcessorInput {
    private String itemId;
    private Set<String> tagIds;
}

