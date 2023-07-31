package com.tinqin.api.operation.vendor.findall;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.vendor.BaseVendorDTO;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindAllVendorsOutput implements ProcessorOutput {
    private Set<BaseVendorDTO> vendors;
}
