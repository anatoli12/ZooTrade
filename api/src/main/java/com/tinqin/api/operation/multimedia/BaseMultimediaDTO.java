package com.tinqin.api.operation.multimedia;

import java.util.Optional;
import java.util.UUID;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseMultimediaDTO {
    private String id;
    private String url;
    private Optional<UUID> itemId;
}
