package com.tinqin.api.operation.comment.findrepliesbycomment;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.comment.BaseCommentDTO;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindRepliesByCommentOutput implements ProcessorOutput {
    private List<BaseCommentDTO> replyList;
}
