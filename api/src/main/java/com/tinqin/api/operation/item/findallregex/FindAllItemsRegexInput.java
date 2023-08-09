package com.tinqin.api.operation.item.findallregex;

import com.tinqin.api.base.ProcessorInput;
import java.util.Optional;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllItemsRegexInput implements ProcessorInput {
    private Optional<Integer> pageNumber;
    private Optional<Integer> pageSize;
    private String regex;
}
