package com.tinqin.api.operation.item.create;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateItemInput implements ProcessorInput {

    private String title;
    private String description;
    private Set<UUID> vendorIds;
    private Set<UUID> tagIds;
}