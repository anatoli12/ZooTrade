package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Vendor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {}
