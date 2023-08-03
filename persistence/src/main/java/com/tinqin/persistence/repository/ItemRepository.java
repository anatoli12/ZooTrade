package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Item;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    Page<Item> findAll(Pageable pageable);
    Page<Item> findAllByIsDeleted(Example<?> example, Boolean showDeleted, Pageable pageable);
    Page<Item> findAllByTitleContainingIgnoreCase(Example<?> example, Pageable pageable);

    @Query("SELECT i FROM Item i " +
            "WHERE (:titleContains IS NULL OR i.title LIKE %:titleContains%) " +
            "AND (:descriptionContains IS NULL OR i.description LIKE %:descriptionContains%) " +
            "AND (:showDeleted = true OR i.isDeleted = false)")
    Page<Item> findAll(Optional<String> titleContains,
                       Optional<String> descriptionContains,
                       Boolean showDeleted,
                       Pageable pageable);



}
