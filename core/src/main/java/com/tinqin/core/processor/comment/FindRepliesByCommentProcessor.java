package com.tinqin.core.processor.comment;

import com.tinqin.api.operation.comment.BaseCommentDTO;
import com.tinqin.api.operation.comment.findrepliesbycomment.FindRepliesByCommentInput;
import com.tinqin.api.operation.comment.findrepliesbycomment.FindRepliesByCommentOperation;
import com.tinqin.api.operation.comment.findrepliesbycomment.FindRepliesByCommentOutput;
import com.tinqin.persistence.model.Comment;
import com.tinqin.persistence.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindRepliesByCommentProcessor implements FindRepliesByCommentOperation {
  private final CommentRepository commentRepository;

  @Override
  public FindRepliesByCommentOutput process(FindRepliesByCommentInput request) {
    Comment parent =
        commentRepository
            .findById(request.getParentId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    List<BaseCommentDTO> dtos = new ArrayList<>();
    parent
        .getReplies()
        .forEach(
            c -> {
              dtos.add(
                  BaseCommentDTO.builder()
                      .parentId(c.getParent().getCommentId())
                      .timestamp(c.getCreationTimeStamp())
                      .userId(c.getUserId())
                      .text(c.getText())
                      .build());
            });
    return FindRepliesByCommentOutput.builder().replyList(dtos).build();
  }
}
