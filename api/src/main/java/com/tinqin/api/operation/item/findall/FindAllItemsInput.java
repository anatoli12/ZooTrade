package com.tinqin.api.operation.item.findall;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.Optional;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllItemsInput implements ProcessorInput {
    private Boolean showDeleted;
    private Optional<Integer> pageNumber;
    private Optional<Integer> pageSize;
}
