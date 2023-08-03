package com.tinqin.persistence.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "multimedia")
public class Multimedia extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "multimedia_id")
    private UUID id;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
