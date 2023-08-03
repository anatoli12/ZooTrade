package com.tinqin.restexport;

import com.tinqin.api.operation.item.findall.FindAllItemsOutput;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestExport {

  @RequestLine("GET /item/{id}")
  FindItemByIdOutput findItemById(@Param("id") String id);

  @RequestLine(
      "GET /item/all?showDeleted={showDeleted}&pageNumber={pageNumber}&pageSize={pageSize}")
  FindAllItemsOutput findAll(
      @Param("showDeleted") Boolean showDeleted,
      @Param("pageNumber") Integer pageNumber,
      @Param("pageSize") Integer pageSize);

  @RequestLine(
          "GET /item/all")
  FindAllItemsOutput findAll1(
          @Param("showDeleted") Boolean showDeleted,
          @Param("pageNumber") Integer pageNumber,
          @Param("pageSize") Integer pageSize);
}
