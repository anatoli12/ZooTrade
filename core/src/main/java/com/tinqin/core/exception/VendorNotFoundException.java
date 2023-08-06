package com.tinqin.core.exception;

import java.util.UUID;

public class VendorNotFoundException extends RuntimeException{
    public VendorNotFoundException(UUID id) {
        super(String.format("Vendor with id '%s' does not exist.", id));
    }
}