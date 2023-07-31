package com.tinqin.api.operation.multimedia.create;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMultimediaOutput implements ProcessorOutput {
    private BaseMultimediaDTO baseMultimediaDTO;
}
