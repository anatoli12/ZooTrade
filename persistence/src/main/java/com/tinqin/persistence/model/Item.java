package com.tinqin.persistence.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "v_items")
public class Item extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "item_id")
  private UUID id;

  @Column private String title;
  @Column private String description;

  @ManyToMany
  @JoinTable(
      name = "items_vendors",
      joinColumns = {@JoinColumn(name = "item_id")},
      inverseJoinColumns = {@JoinColumn(name = "vendor_id")})
  private Set<Vendor> vendors;

  @OneToMany(mappedBy = "item")
  private Set<Multimedia> multimedia;

  @ManyToMany
  @JoinTable(
      name = "items_tags",
      joinColumns = {@JoinColumn(name = "item_id")},
      inverseJoinColumns = {@JoinColumn(name = "tag_id")})
  private Set<Tag> tags;

  @OneToMany(mappedBy = "item")
  private List<Comment> comments;
}
