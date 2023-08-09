package com.tinqin.api.operation.comment.addreplytocomment;

import com.tinqin.api.base.ProcessorInput;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddReplyToCommentInput implements ProcessorInput {
    private UUID parentId;
    private UUID userId;
    private String text;
}
