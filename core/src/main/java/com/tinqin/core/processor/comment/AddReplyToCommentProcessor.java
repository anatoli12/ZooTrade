package com.tinqin.core.processor.comment;

import com.tinqin.api.operation.comment.BaseCommentDTO;
import com.tinqin.api.operation.comment.addreplytocomment.AddReplyToCommentInput;
import com.tinqin.api.operation.comment.addreplytocomment.AddReplyToCommentOperation;
import com.tinqin.api.operation.comment.addreplytocomment.AddReplyToCommentOutput;
import com.tinqin.persistence.model.Comment;
import com.tinqin.persistence.repository.CommentRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AddReplyToCommentProcessor implements AddReplyToCommentOperation {
    
    private final CommentRepository commentRepository;
    @Override
    public AddReplyToCommentOutput process(AddReplyToCommentInput request) {
        Comment parentComment = commentRepository.findById(request.getParentId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Comment reply = Comment.builder()
                .creationTimeStamp(new Timestamp(System.currentTimeMillis()))
                .userId(request.getUserId())
                .text(request.getText())
                .parent(parentComment)
                .build();

        List<Comment> parentReplies = Optional.ofNullable(parentComment.getReplies()).orElseGet(ArrayList::new);
        parentReplies.add(reply);
        parentComment.setReplies(parentReplies);

        commentRepository.save(parentComment);
        commentRepository.save(reply);

        return AddReplyToCommentOutput.builder()
                .base(BaseCommentDTO.builder()
                        .parentId(reply.getParent().getCommentId())
                        .timestamp(reply.getCreationTimeStamp())
                        .userId(reply.getUserId())
                        .text(reply.getText())
                        .build())
                .build();
    }
}
