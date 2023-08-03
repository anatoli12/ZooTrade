package com.tinqin.api.operation.item.findall;

import com.tinqin.api.base.ProcessorInput;
import java.util.Optional;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllItemsInput implements ProcessorInput {
    private Boolean showDeleted;
    private Optional<Integer> pageNumber;
    private Optional<Integer> pageSize;
    private Optional<String> titleContains;
    private Optional<String> descriptionContains;
}
