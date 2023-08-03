package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Tag;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {}
