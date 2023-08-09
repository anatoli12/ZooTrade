package com.tinqin.api.operation.comment;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseCommentDTO {
    private UUID parentId;
    private UUID userId;
    private Timestamp timestamp;
    private String text;
}
