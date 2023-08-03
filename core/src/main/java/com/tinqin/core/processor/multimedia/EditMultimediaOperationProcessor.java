package com.tinqin.core.processor.multimedia;

import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import com.tinqin.api.operation.multimedia.edit.EditMultimediaInput;
import com.tinqin.api.operation.multimedia.edit.EditMultimediaOperation;
import com.tinqin.api.operation.multimedia.edit.EditMultimediaOutput;
import com.tinqin.persistence.model.Multimedia;
import com.tinqin.persistence.repository.MultimedaRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class EditMultimediaOperationProcessor implements EditMultimediaOperation {
    private final MultimedaRepository multimedaRepository;
    @Override
    public EditMultimediaOutput process(EditMultimediaInput request) {
        Multimedia multimedia =
                multimedaRepository
                        .findById(UUID.fromString(request.getId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        multimedia.setUrl(request.getUrl());
        multimedaRepository.save(multimedia);
        BaseMultimediaDTO base = MultimediaEntityToDTOProcessor.convertEntityToDTO(multimedia);
        return EditMultimediaOutput.builder().base(base).build();
    }
}
