package com.tinqin.api.operation.item.removemultimediafromitem;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemoveMultimediaFromItemInput implements ProcessorInput {
    private String itemId;
    private Set<String> multimediaIds;
}
