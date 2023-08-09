package com.tinqin.persistence.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "parent_id") // self-referencing foreign key
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> replies; // replies to this comment
}
