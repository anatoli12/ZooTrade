package com.tinqin.api.operation.vendor.edit;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditVendorInput implements ProcessorInput {
    private String id;
    private String name;
}
