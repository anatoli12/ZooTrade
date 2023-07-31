package com.tinqin.persistence.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "vendors")
@NoArgsConstructor
@AllArgsConstructor
public class Vendor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vendor_id")
    private UUID id;

    @Column private String name;

    @Column
    @ManyToMany
    @JoinTable(
            name = "items_vendors",
            joinColumns = {@JoinColumn(name = "vendor_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private Set<Item> items;
}