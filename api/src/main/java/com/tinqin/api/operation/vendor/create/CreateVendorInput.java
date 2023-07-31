package com.tinqin.api.operation.vendor.create;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateVendorInput implements ProcessorInput {
    private String name;
}
