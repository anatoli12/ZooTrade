package com.tinqin.api.operation.tag.generatefixture;

import com.tinqin.api.base.ProcessorInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTagFixtureInput implements ProcessorInput {
    private Integer count;
}
