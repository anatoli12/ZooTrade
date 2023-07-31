package com.tinqin.api.operation.vendor.findbyid;

import com.tinqin.api.base.ProcessorInput;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindVendorByIdInput implements ProcessorInput {
    private String id;
}
