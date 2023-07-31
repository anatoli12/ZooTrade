package com.tinqin.api.operation.multimedia.create;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMultimediaInput implements ProcessorInput {
    private String url;
    private String itemId;
}
