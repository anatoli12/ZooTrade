package com.tinqin.api.operation.tag;

import java.util.Set;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseTagDTO {
    private String id;
    private String title;
    private Set<String> itemIds;
}
