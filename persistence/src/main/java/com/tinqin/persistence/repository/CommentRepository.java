package com.tinqin.persistence.repository;

import com.tinqin.persistence.model.Comment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, UUID> {}
