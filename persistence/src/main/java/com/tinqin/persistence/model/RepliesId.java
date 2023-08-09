package com.tinqin.persistence.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepliesId implements Serializable {
    private UUID parentCommentId;
    private UUID replyCommentId;
}
