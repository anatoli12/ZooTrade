package com.tinqin.api.operation.tag;

import lombok.*;

import java.util.Set;

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
