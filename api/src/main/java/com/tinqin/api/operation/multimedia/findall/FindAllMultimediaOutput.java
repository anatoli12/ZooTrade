package com.tinqin.api.operation.multimedia.findall;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.multimedia.BaseMultimediaDTO;
import lombok.*;

import java.util.Set;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllMultimediaOutput implements ProcessorOutput {
    private Set<BaseMultimediaDTO> multimedia;
}
