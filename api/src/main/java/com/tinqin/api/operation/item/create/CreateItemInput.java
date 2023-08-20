package com.tinqin.api.operation.item.create;

import com.tinqin.api.base.ProcessorInput;
import java.util.Set;
import java.util.UUID;
import lombok.*;
import uk.co.jemos.podam.common.PodamCollection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateItemInput implements ProcessorInput {

    private String title;
    private String description;
    @PodamCollection(nbrElements = 2)
    private Set<UUID> vendorIds;
    @PodamCollection(nbrElements = 2)
    private Set<UUID> tagIds;
}