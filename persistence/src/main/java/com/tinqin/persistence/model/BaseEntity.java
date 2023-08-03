package com.tinqin.persistence.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    protected Boolean isDeleted;
}
