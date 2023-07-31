package com.tinqin.api.operation.multimedia;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseMultimediaDTO {
    private String id;
    private String url;
    private String itemId;
}
