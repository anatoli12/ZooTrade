package com.tinqin.api.operation.item.addtagstoitem;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTagsToItemInput implements ProcessorInput {
    private String itemId;
    private Set<String> tagIds;
}
