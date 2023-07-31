package com.tinqin.api.operation.item.addmultimediatoitem;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMultimediaToItemInput implements ProcessorInput {
  private String itemId;
  private Set<String> multimediaIds;
}
