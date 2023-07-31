package com.tinqin.core.processor.tag;

import com.tinqin.api.operation.tag.BaseTagDTO;
import com.tinqin.api.operation.tag.create.CreateTagInput;
import com.tinqin.api.operation.tag.create.CreateTagOperation;
import com.tinqin.api.operation.tag.create.CreateTagOutput;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTagOperationProcessor implements CreateTagOperation {

  private final TagRepository tagRepository;

  @Override
  public CreateTagOutput process(CreateTagInput request) {
    Tag tag = Tag.builder().title(request.getTitle()).build();
    tagRepository.save(tag);
    BaseTagDTO base =
        BaseTagDTO.builder().id(String.valueOf(tag.getId())).title(tag.getTitle()).build();
    return CreateTagOutput.builder().baseTagDTO(base).build();
  }
}
