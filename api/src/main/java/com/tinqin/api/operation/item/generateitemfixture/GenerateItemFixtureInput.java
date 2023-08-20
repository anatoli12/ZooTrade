package com.tinqin.api.operation.item.generateitemfixture;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateItemFixtureInput implements ProcessorInput {
    private Integer count;
}
