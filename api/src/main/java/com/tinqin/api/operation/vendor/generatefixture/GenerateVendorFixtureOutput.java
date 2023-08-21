package com.tinqin.api.operation.vendor.generatefixture;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.vendor.create.CreateVendorOutput;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateVendorFixtureOutput implements ProcessorOutput {
    private List<CreateVendorOutput> vendorOutputList;
}
