package com.tinqin.core.processor.vendor;

import com.tinqin.api.operation.vendor.BaseVendorDTO;
import com.tinqin.api.operation.vendor.findall.FindAllVendorsInput;
import com.tinqin.api.operation.vendor.findall.FindAllVendorsOperation;
import com.tinqin.api.operation.vendor.findall.FindAllVendorsOutput;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllVendorsOperationProcessor implements FindAllVendorsOperation {

  private final VendorRepository vendorRepository;

  @Override
  public FindAllVendorsOutput process(FindAllVendorsInput request) {
    Set<Vendor> vendors = new HashSet<>(vendorRepository.findAll());
    Set<BaseVendorDTO> base =
        vendors.stream()
            .map(VendorEntityToDTOProcessor::convertEntityToDTO)
            .collect(Collectors.toSet());
    return FindAllVendorsOutput.builder().vendors(base).build();
  }
}
