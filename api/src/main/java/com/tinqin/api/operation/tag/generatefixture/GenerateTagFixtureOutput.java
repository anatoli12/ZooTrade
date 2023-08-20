package com.tinqin.api.operation.tag.generatefixture;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.tag.create.CreateTagOutput;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateTagFixtureOutput implements ProcessorOutput {
    private List<CreateTagOutput> tags;
}
