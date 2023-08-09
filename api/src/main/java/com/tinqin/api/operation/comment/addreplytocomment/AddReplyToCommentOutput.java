package com.tinqin.api.operation.comment.addreplytocomment;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.comment.BaseCommentDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddReplyToCommentOutput implements ProcessorOutput {
    private BaseCommentDTO base;
}
