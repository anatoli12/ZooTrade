package com.tinqin.api.operation.item.addcommenttoitem;

import com.tinqin.api.base.ProcessorInput;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentToItemInput implements ProcessorInput {
    private UUID itemId;
    private UUID userId;
    private String text;
}
