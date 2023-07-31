package com.tinqin.core.processor.vendor;

import com.tinqin.api.operation.vendor.BaseVendorDTO;
import com.tinqin.api.operation.vendor.create.CreateVendorInput;
import com.tinqin.api.operation.vendor.create.CreateVendorOperation;
import com.tinqin.api.operation.vendor.create.CreateVendorOutput;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVendorOperationProcessor implements CreateVendorOperation {

  private final VendorRepository vendorRepository;

  @Override
  public CreateVendorOutput process(CreateVendorInput request) {
    Vendor vendor = Vendor.builder().name(request.getName()).build();
    vendorRepository.save(vendor);
    BaseVendorDTO base =
        BaseVendorDTO.builder().id(String.valueOf(vendor.getId())).name(vendor.getName()).build();
    return CreateVendorOutput.builder().baseVendorDTO(base).build();
  }
}
