package com.tinqin.api.operation.item;

import java.util.Set;
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
    protected Boolean deleted;
}
