package com.tinqin.persistence.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    protected Boolean isDeleted;
}
