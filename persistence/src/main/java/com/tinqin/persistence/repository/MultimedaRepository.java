package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MultimedaRepository extends JpaRepository<Multimedia, UUID> {}
