package com.tinqin.core.processor.vendor;

import com.tinqin.api.operation.vendor.BaseVendorDTO;
import com.tinqin.api.operation.vendor.findbyid.FindVendorByIdInput;
import com.tinqin.api.operation.vendor.findbyid.FindVendorByIdOperation;
import com.tinqin.api.operation.vendor.findbyid.FindVendorByIdOutput;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindVendorByIdOperationProcessor implements FindVendorByIdOperation {
  private final VendorRepository vendorRepository;

  @Override
  public FindVendorByIdOutput process(FindVendorByIdInput request) {
    Vendor vendor =
        vendorRepository
            .findById(UUID.fromString(request.getId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    BaseVendorDTO base = VendorEntityToDTOProcessor.convertEntityToDTO(vendor);
    return FindVendorByIdOutput.builder().baseVendorDTO(base).build();
  }
}
