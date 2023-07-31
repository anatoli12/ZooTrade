package com.tinqin.api.operation.multimedia.edit;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditMultimediaInput implements ProcessorInput {
    private String id;
    private String url;
}
