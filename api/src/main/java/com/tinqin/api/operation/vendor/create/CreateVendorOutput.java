package com.tinqin.api.operation.vendor.create;

import com.tinqin.api.base.ProcessorOutput;
import com.tinqin.api.operation.vendor.BaseVendorDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateVendorOutput implements ProcessorOutput {
  private BaseVendorDTO baseVendorDTO;
}
