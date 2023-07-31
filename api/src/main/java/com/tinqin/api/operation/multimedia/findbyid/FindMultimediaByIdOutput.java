package com.tinqin.api.operation.multimedia.findbyid;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindMultimediaByIdOutput implements ProcessorOutput {
    private BaseMultimediaDTO baseMultimediaDTO;
}
