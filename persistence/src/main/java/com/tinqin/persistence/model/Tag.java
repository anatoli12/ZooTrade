package com.tinqin.persistence.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tag_id")
    private UUID id;

    @Column private String title;

    @Column
    @ManyToMany
    @JoinTable(
            name = "items_tags",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private Set<Item> items;
}