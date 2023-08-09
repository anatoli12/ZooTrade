package com.tinqin.api.operation.comment.findrepliesbycomment;

import com.tinqin.api.base.ProcessorInput;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindRepliesByCommentInput implements ProcessorInput {
    private UUID parentId;
}
