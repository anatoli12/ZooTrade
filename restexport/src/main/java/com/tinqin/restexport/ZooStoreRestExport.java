package com.tinqin.restexport;

import com.tinqin.api.operation.item.findall.FindAllItemsOutput;
import com.tinqin.api.operation.item.findallregex.FindAllItemsRegexOutput;
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

    return findAllItemsInternal(uri.toString());
  }

  @RequestLine("GET {url}")
  FindAllItemsOutput findAllItemsInternal(@Param String url);

  @RequestLine("GET /item/all?showDeleted=true")
  FindAllItemsOutput findItemsTest();

  default FindAllItemsRegexOutput findRegexItems(Optional<Integer> pageNumber,
                                                 Optional<Integer> pageSize,
                                                 String regex){
    UriComponents uri = UriComponentsBuilder.fromPath("/item/all/regex")
            .queryParam("regex", regex)
            .queryParamIfPresent("pageNumber", pageNumber)
            .queryParamIfPresent("pageSize", pageSize)
            .build();

    return findRegexItemsInternal(uri.toString());
  }
  @RequestLine("GET {url}")
  FindAllItemsRegexOutput findRegexItemsInternal(@Param String url);

}
