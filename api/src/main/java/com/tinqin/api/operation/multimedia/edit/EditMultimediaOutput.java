package com.tinqin.api.operation.multimedia.edit;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditMultimediaOutput implements ProcessorOutput {
  private BaseMultimediaDTO base;
}
