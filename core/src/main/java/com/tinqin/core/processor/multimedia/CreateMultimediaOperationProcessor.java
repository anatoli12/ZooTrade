package com.tinqin.core.processor.multimedia;

import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import com.tinqin.api.operation.multimedia.create.CreateMultimediaInput;
import com.tinqin.api.operation.multimedia.create.CreateMultimediaOperation;
import com.tinqin.api.operation.multimedia.create.CreateMultimediaOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Multimedia;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.MultimedaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateMultimediaOperationProcessor implements CreateMultimediaOperation {

  private final MultimedaRepository multimedaRepository;
  private final ItemRepository itemRepository;

  @Override
  public CreateMultimediaOutput process(CreateMultimediaInput request) {
    Item targetItem = itemRepository.findById(UUID.fromString(request.getItemId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Multimedia multimedia = Multimedia.builder()
            .url(request.getUrl())
            .item(targetItem)
            .build();
    multimedaRepository.save(multimedia);
    BaseMultimediaDTO base = BaseMultimediaDTO.builder()
            .id(String.valueOf(multimedia.getId()))
            .url(multimedia.getUrl())
            .itemId(Optional.ofNullable(multimedia.getItem())
                    .map(item -> String.valueOf(item.getId()))
                    .orElse(""))
            .build();
    return CreateMultimediaOutput.builder()
            .baseMultimediaDTO(base)
            .build();
  }
}
