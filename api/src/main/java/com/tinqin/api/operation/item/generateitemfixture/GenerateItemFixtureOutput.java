package com.tinqin.api.operation.item.generateitemfixture;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.item.create.CreateItemOutput;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateItemFixtureOutput implements ProcessorOutput {
    private List<CreateItemOutput> createItemOutputList;
}
