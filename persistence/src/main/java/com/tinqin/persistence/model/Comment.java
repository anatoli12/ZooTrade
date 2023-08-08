package com.tinqin.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comment_id", nullable = false)
    private UUID commentId;

    private String text;

    private Timestamp creationTimeStamp;

    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
