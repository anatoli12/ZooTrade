package com.tinqin.rest.controller;

import com.tinqin.api.operation.vendor.create.CreateVendorInput;
import com.tinqin.api.operation.vendor.create.CreateVendorOperation;
import com.tinqin.api.operation.vendor.create.CreateVendorOutput;
import com.tinqin.api.operation.vendor.edit.EditVendorInput;
import com.tinqin.api.operation.vendor.edit.EditVendorOperation;
import com.tinqin.api.operation.vendor.edit.EditVendorOutput;
import com.tinqin.api.operation.vendor.findall.FindAllVendorsInput;
import com.tinqin.api.operation.vendor.findall.FindAllVendorsOperation;
import com.tinqin.api.operation.vendor.findall.FindAllVendorsOutput;
import com.tinqin.api.operation.vendor.findbyid.FindVendorByIdInput;
import com.tinqin.api.operation.vendor.findbyid.FindVendorByIdOperation;
import com.tinqin.api.operation.vendor.findbyid.FindVendorByIdOutput;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendor")
public class VendorController {
  private final CreateVendorOperation createVendorOperation;
  private final EditVendorOperation editVendorOperation;
  private final FindAllVendorsOperation findAllVendorsOperation;
  private final FindVendorByIdOperation findVendorByIdOperation;

  @PostMapping
  public ResponseEntity<CreateVendorOutput> create(@RequestBody CreateVendorInput request) {
    return ResponseEntity.ok(createVendorOperation.process(request));
  }

  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity<FindVendorByIdOutput> findById(@PathVariable String id) {
    return ResponseEntity.ok(
        findVendorByIdOperation.process(FindVendorByIdInput.builder().id(id).build()));
  }

  @GetMapping("/all")
  @Transactional
  public ResponseEntity<FindAllVendorsOutput> findAll() {
    return ResponseEntity.ok(findAllVendorsOperation.process(new FindAllVendorsInput()));
  }

  @PatchMapping
  @Transactional
  public ResponseEntity<EditVendorOutput> update(@RequestBody EditVendorInput request) {
    return ResponseEntity.ok(editVendorOperation.process(request));
  }
}
