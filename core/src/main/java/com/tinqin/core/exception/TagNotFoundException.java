package com.tinqin.core.exception;

import java.util.UUID;

public class TagNotFoundException extends RuntimeException{
    public TagNotFoundException(UUID id) {
        super(String.format("Tag with id '%s' does not exist.", id));
    }

    public TagNotFoundException(String idList) {
        super(String.format("Tags with ids '%s' does not exist.", idList));
    }
}