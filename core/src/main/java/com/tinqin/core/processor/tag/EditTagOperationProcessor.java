package com.tinqin.core.processor.tag;

import com.tinqin.api.operation.tag.BaseTagDTO;
import com.tinqin.api.operation.tag.edit.EditTagInput;
import com.tinqin.api.operation.tag.edit.EditTagOperation;
import com.tinqin.api.operation.tag.edit.EditTagOutput;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.repository.TagRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class EditTagOperationProcessor implements EditTagOperation {
    private final TagRepository tagRepository;
    @Override
    public EditTagOutput process(EditTagInput request) {
        Tag tag =
                tagRepository
                        .findById(UUID.fromString(request.getId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        tag.setTitle(request.getTitle());
        tagRepository.save(tag);
        BaseTagDTO base = TagEntityToDTOProcessor.convertEntityToDTO(tag);
        return EditTagOutput.builder().baseTagDTO(base).build();
    }
}
