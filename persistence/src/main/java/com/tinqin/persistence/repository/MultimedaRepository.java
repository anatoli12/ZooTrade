package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Multimedia;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimedaRepository extends JpaRepository<Multimedia, UUID> {}
