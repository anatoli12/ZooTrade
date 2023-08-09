package com.tinqin.api.operation.item;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseItemDTO {
    protected String id;
    protected String title;
    protected String description;
    protected Set<String> vendorIds;
    protected Set<String> multimediaIds;
    protected Set<String> tagIds;
    protected List<UUID> commentIds;
    protected Boolean deleted;
}
