package com.tinqin.api.operation.item.addmultimediatoitem;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMultimediaToItemInput implements ProcessorInput {
  private String itemId;
  private Set<String> multimediaIds;
}
