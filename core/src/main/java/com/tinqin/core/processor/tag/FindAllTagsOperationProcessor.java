package com.tinqin.core.processor.tag;

import com.tinqin.api.operation.tag.BaseTagDTO;
import com.tinqin.api.operation.tag.findall.FindAllTagsInput;
import com.tinqin.api.operation.tag.findall.FindAllTagsOperation;
import com.tinqin.api.operation.tag.findall.FindAllTagsOutput;
import com.tinqin.persistence.model.Tag;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.tinqin.persistence.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllTagsOperationProcessor implements FindAllTagsOperation {

  private final TagRepository tagRepository;

  @Override
  public FindAllTagsOutput process(FindAllTagsInput request) {
    Set<Tag> tags =
            new HashSet<>(tagRepository.findAll());
    Set<BaseTagDTO> base =
        tags.stream()
            .map(TagEntityToDTOProcessor::convertEntityToDTO)
            .collect(Collectors.toSet());
    return FindAllTagsOutput.builder().tags(base).build();
  }
}
