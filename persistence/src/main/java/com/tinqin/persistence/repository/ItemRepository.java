package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Item;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    Page<Item> findAll(Pageable pageable);

    @Query("SELECT i FROM Item i " +
            "WHERE (:titleContains IS NULL OR i.title LIKE %:titleContains%) " +
            "AND (:descriptionContains IS NULL OR i.description LIKE %:descriptionContains%) " +
            "AND (:showDeleted = true OR i.isDeleted = false)")
    Page<Item> findAll(Optional<String> titleContains,
                       Optional<String> descriptionContains,
                       Boolean showDeleted,
                       Pageable pageable);

    @Query(value = "SELECT * FROM v_items i WHERE (:regex IS NULL OR i.title REGEXP :regex)", nativeQuery = true)
    Page<Item> findAllByTitleRegex(@Param("regex") String regex, Pageable pageable);
}
