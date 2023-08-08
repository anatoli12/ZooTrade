package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.addcommenttoitem.AddCommentToItemInput;
import com.tinqin.api.operation.item.addcommenttoitem.AddCommentToItemOperation;
import com.tinqin.api.operation.item.addcommenttoitem.AddCommentToItemOutput;
import com.tinqin.persistence.model.Comment;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.repository.CommentRepository;
import com.tinqin.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AddCommentToItemProcessor implements AddCommentToItemOperation {
    private final ItemRepository itemRepository;
    private final CommentRepository commentRepository;
    @Override
    public AddCommentToItemOutput process(AddCommentToItemInput request) {
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Comment comment = Comment.builder()
                .creationTimeStamp(new Timestamp(System.currentTimeMillis()))
                .userId(request.getUserId())
                .text(request.getText())
                .item(item)
                .build();
        List<Comment> itemComments = Optional.ofNullable(item.getComments()).orElseGet(ArrayList::new);
        itemComments.add(comment);
        item.setComments(itemComments);
        itemRepository.save(item);
        commentRepository.save(comment);
        BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return AddCommentToItemOutput.builder()
                .baseItemDTO(base)
                .build();
    }
}
