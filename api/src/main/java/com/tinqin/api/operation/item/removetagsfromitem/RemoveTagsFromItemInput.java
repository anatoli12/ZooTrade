package com.tinqin.api.operation.item.removetagsfromitem;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemoveTagsFromItemInput implements ProcessorInput {
    private String itemId;
    private Set<String> tagIds;
}

