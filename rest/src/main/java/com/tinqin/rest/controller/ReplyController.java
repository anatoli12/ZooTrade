package com.tinqin.rest.controller;

import com.tinqin.api.operation.comment.addreplytocomment.AddReplyToCommentInput;
import com.tinqin.api.operation.comment.addreplytocomment.AddReplyToCommentOperation;
import com.tinqin.api.operation.comment.addreplytocomment.AddReplyToCommentOutput;
import com.tinqin.api.operation.comment.findrepliesbycomment.FindRepliesByCommentInput;
import com.tinqin.api.operation.comment.findrepliesbycomment.FindRepliesByCommentOperation;
import com.tinqin.api.operation.comment.findrepliesbycomment.FindRepliesByCommentOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final AddReplyToCommentOperation addReplyToCommentOperation;
    private final FindRepliesByCommentOperation findRepliesByCommentOperation;

    @PostMapping
    @Transactional
    public ResponseEntity<AddReplyToCommentOutput> addReply(AddReplyToCommentInput input){
        return ResponseEntity.ok(addReplyToCommentOperation.process(input));
    }
    @GetMapping("/{id}")
    @Transactional
    @Operation(summary = "Get all replies to a comment", description = "Get replies to a comment by a comment id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<FindRepliesByCommentOutput> findRepliesByComment(@PathVariable UUID id)
    {
        return ResponseEntity.ok(findRepliesByCommentOperation.process(FindRepliesByCommentInput.builder()
                .parentId(id)
                .build()));
    }
}
