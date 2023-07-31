package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {}
