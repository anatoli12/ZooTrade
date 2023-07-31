package com.tinqin.restexport;

import com.tinqin.api.operation.item.findbyid.FindItemByIdOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestHeader;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestExport {

    @RequestLine("GET /item/{id}")
    FindItemByIdOutput findItemById(@Param("id") String id);
}
