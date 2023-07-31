package com.tinqin.api.operation.vendor.edit;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.vendor.BaseVendorDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EditVendorOutput implements ProcessorOutput {
    private BaseVendorDTO baseVendorDTO;
}
