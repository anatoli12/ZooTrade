package com.tinqin.core.processor.vendor;

import com.tinqin.api.operation.vendor.BaseVendorDTO;
import com.tinqin.api.operation.vendor.edit.EditVendorInput;
import com.tinqin.api.operation.vendor.edit.EditVendorOperation;
import com.tinqin.api.operation.vendor.edit.EditVendorOutput;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class EditVendorOperationProcessor implements EditVendorOperation {
    private final VendorRepository vendorRepository;
    @Override
    public EditVendorOutput process(EditVendorInput request) {
        Vendor vendor =
                vendorRepository
                        .findById(UUID.fromString(request.getId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        vendor.setName(request.getName());
        vendorRepository.save(vendor);
        BaseVendorDTO base = VendorEntityToDTOProcessor.convertEntityToDTO(vendor);
        return EditVendorOutput.builder().baseVendorDTO(base).build();
    }
}
