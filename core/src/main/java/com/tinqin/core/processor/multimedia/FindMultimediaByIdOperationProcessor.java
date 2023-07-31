package com.tinqin.core.processor.multimedia;

import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import com.tinqin.api.operation.multimedia.findbyid.FindMultimediaByIdInput;
import com.tinqin.api.operation.multimedia.findbyid.FindMultimediaByIdOperation;
import com.tinqin.api.operation.multimedia.findbyid.FindMultimediaByIdOutput;
import com.tinqin.persistence.model.Multimedia;
import com.tinqin.persistence.repository.MultimedaRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindMultimediaByIdOperationProcessor implements FindMultimediaByIdOperation {
  private final MultimedaRepository multimedaRepository;

  @Override
  public FindMultimediaByIdOutput process(FindMultimediaByIdInput request) {
    Multimedia multimedia =
        multimedaRepository
            .findById(UUID.fromString(request.getId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    BaseMultimediaDTO base = MultimediaEntityToDTOProcessor.convertEntityToDTO(multimedia);
    return FindMultimediaByIdOutput.builder().baseMultimediaDTO(base).build();
  }
}
