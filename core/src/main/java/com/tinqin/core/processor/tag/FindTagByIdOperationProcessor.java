package com.tinqin.core.processor.tag;

import com.tinqin.api.operation.tag.BaseTagDTO;
import com.tinqin.api.operation.tag.findbyid.FindTagByIdInput;
import com.tinqin.api.operation.tag.findbyid.FindTagByIdOperation;
import com.tinqin.api.operation.tag.findbyid.FindTagByIdOutput;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.repository.TagRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindTagByIdOperationProcessor implements FindTagByIdOperation {
  private final TagRepository tagRepository;

  @Override
  public FindTagByIdOutput process(FindTagByIdInput request) {
    Tag tag =
        tagRepository
            .findById(UUID.fromString(request.getId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    BaseTagDTO base = TagEntityToDTOProcessor.convertEntityToDTO(tag);
    return FindTagByIdOutput.builder().baseTagDTO(base).build();
  }
}
