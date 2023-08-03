package com.tinqin.api.operation.multimedia.findall;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import java.util.Set;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllMultimediaOutput implements ProcessorOutput {
    private Set<BaseMultimediaDTO> multimedia;
}
