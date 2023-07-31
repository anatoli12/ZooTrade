package com.tinqin.api.operation.multimedia.findbyid;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindMultimediaByIdInput implements ProcessorInput {
    private String id;
}
