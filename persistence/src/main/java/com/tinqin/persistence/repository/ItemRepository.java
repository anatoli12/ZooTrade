package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
//    Page<Item> findAll(Pageable pageable);
    Page<Item> findAllByIsDeleted(Boolean showDeleted, Pageable pageable);
    Page<Item> findAll(Pageable pageable);
}
