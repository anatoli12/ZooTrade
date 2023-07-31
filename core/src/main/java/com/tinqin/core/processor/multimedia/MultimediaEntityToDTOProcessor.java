package com.tinqin.core.processor.multimedia;

import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import com.tinqin.persistence.model.Multimedia;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MultimediaEntityToDTOProcessor {
  public static BaseMultimediaDTO convertEntityToDTO(Multimedia multimedia) {
    return BaseMultimediaDTO.builder()
        .id(String.valueOf(multimedia.getId()))
        .url(multimedia.getUrl())
        .itemId(String.valueOf(Optional.of(multimedia.getItem().getId())))
        .build();
  }
}
