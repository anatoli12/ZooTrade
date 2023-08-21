package com.tinqin.api.operation.vendor.generatefixture;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateVendorFixtureInput implements ProcessorInput {
    private Integer count;
}
