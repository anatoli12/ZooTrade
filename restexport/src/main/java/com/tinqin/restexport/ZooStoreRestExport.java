package com.tinqin.restexport;

import com.tinqin.api.operation.item.findall.FindAllItemsOutput;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.Optional;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface ZooStoreRestExport {

  @RequestLine("GET /item/{id}")
  FindItemByIdOutput findItemById(@Param("id") String id);

  default FindAllItemsOutput findAll(
          Boolean showDeleted,
          Optional<Integer> pageNumber,
          Optional<Integer> pageSize,
          Optional<String> titleContains,
          Optional<String> descriptionContains) {

    UriComponents uri = UriComponentsBuilder.fromPath("/item/all/params")
            .queryParam("showDeleted", showDeleted)
            .queryParamIfPresent("pageNumber", pageNumber)
            .queryParamIfPresent("pageSize", pageSize)
            .queryParamIfPresent("titleContains", titleContains)
            .queryParamIfPresent("descriptionContains", descriptionContains)
            .build();

    return findItemsInternal(uri.toString());
  }

  @RequestLine("GET {url}")
  FindAllItemsOutput findItemsInternal(@Param String url);

  @RequestLine("GET /item/all?showDeleted=true")
  FindAllItemsOutput findItemsTest();

}
