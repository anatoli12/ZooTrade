package com.tinqin.api.operation.vendor.findbyid;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.vendor.BaseVendorDTO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindVendorByIdOutput implements ProcessorOutput {
    private BaseVendorDTO baseVendorDTO;
}
