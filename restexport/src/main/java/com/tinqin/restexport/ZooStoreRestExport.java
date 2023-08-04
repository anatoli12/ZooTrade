package com.tinqin.restexport;

import com.tinqin.api.operation.item.findall.FindAllItemsOutput;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestExport {

  @RequestLine("GET /item/{id}")
  FindItemByIdOutput findItemById(@Param("id") String id);

  default FindAllItemsOutput findAll(
          Boolean showDeleted,
          Optional<Integer> pageNumber,
          Optional<Integer> pageSize,
          Optional<String> titleContains,
          Optional<String> descriptionContains) {

    StringBuilder urlBuilder = new StringBuilder("?showDeleted=").append(showDeleted);
    pageNumber.ifPresent(page -> urlBuilder.append("&pageNumber=").append(page));
    pageSize.ifPresent(size -> urlBuilder.append("&pageSize=").append(size));
    titleContains.ifPresent(title -> urlBuilder.append("&titleContains=").append(title));
    descriptionContains.ifPresent(description -> urlBuilder.append("&descriptionContains=").append(description));

    return findItemsInternal(urlBuilder.toString());
  }

  // Internal method to make the actual Feign request
  @RequestLine("GET /item/all{?params}")
  FindAllItemsOutput findItemsInternal(@Param("params") String params);

}
