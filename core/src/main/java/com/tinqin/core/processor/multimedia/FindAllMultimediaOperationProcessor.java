package com.tinqin.core.processor.multimedia;

import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import com.tinqin.api.operation.multimedia.findall.FindAllMultimediaInput;
import com.tinqin.api.operation.multimedia.findall.FindAllMultimediaOperation;
import com.tinqin.api.operation.multimedia.findall.FindAllMultimediaOutput;
import com.tinqin.persistence.repository.MultimedaRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllMultimediaOperationProcessor implements FindAllMultimediaOperation {

  private final MultimedaRepository multimediaRepository;

  @Override
  public FindAllMultimediaOutput process(FindAllMultimediaInput request) {
    var multimedia =
            multimediaRepository.findAll();
    Set<BaseMultimediaDTO> base =
        multimedia.stream()
            .map(MultimediaEntityToDTOProcessor::convertEntityToDTO)
            .collect(Collectors.toSet());
    return FindAllMultimediaOutput.builder().multimedia(base).build();
  }
}
