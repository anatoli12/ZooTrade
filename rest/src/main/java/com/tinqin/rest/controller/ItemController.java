package com.tinqin.rest.controller;

import com.tinqin.api.operation.item.addcommenttoitem.AddCommentToItemInput;
import com.tinqin.api.operation.item.addcommenttoitem.AddCommentToItemOperation;
import com.tinqin.api.operation.item.addcommenttoitem.AddCommentToItemOutput;
import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemOperation;
import com.tinqin.api.operation.item.addtagstoitem.AddTagsToItemInput;
import com.tinqin.api.operation.item.addtagstoitem.AddTagsToItemOperation;
import com.tinqin.api.operation.item.addtagstoitem.AddTagsToItemOutput;
import com.tinqin.api.operation.item.addvendorstoitem.AddVendorsToItemInput;
import com.tinqin.api.operation.item.addvendorstoitem.AddVendorsToItemOperation;
import com.tinqin.api.operation.item.addvendorstoitem.AddVendorsToItemOutput;
import com.tinqin.api.operation.item.create.CreateItemInput;
import com.tinqin.api.operation.item.create.CreateItemOperation;
import com.tinqin.api.operation.item.create.CreateItemOutput;
import com.tinqin.api.operation.item.delete.DeleteItemInput;
import com.tinqin.api.operation.item.delete.DeleteItemOperation;
import com.tinqin.api.operation.item.delete.DeleteItemOutput;
import com.tinqin.api.operation.item.findall.FindAllItemsInput;
import com.tinqin.api.operation.item.findall.FindAllItemsOperation;
import com.tinqin.api.operation.item.findall.FindAllItemsOutput;
import com.tinqin.api.operation.item.findbyid.FindItemByIdInput;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOperation;
import com.tinqin.api.operation.item.findbyid.FindItemByIdOutput;
import com.tinqin.api.operation.item.removemultimediafromitem.RemoveMultimediaFromItemInput;
import com.tinqin.api.operation.item.removemultimediafromitem.RemoveMultimediaFromItemOperation;
import com.tinqin.api.operation.item.removemultimediafromitem.RemoveMultimediaFromItemOutput;
import com.tinqin.api.operation.item.removetagsfromitem.RemoveTagsFromItemInput;
import com.tinqin.api.operation.item.removetagsfromitem.RemoveTagsFromItemOperation;
import com.tinqin.api.operation.item.removetagsfromitem.RemoveTagsFromItemOutput;
import com.tinqin.api.operation.item.removevendorsfromitem.RemoveVendorsFromItemInput;
import com.tinqin.api.operation.item.removevendorsfromitem.RemoveVendorsFromItemOperation;
import com.tinqin.api.operation.item.removevendorsfromitem.RemoveVendorsFromItemOutput;
import com.tinqin.api.operation.item.update.EditItemInput;
import com.tinqin.api.operation.item.update.EditItemOperation;
import com.tinqin.api.operation.item.update.EditItemOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
  private final AddMultimediaToItemOperation addMultimediaToItemOperation;
  private final AddTagsToItemOperation addTagsToItemOperation;
  private final AddVendorsToItemOperation addVendorsToItemOperation;
  private final CreateItemOperation createItemOperation;
  private final DeleteItemOperation deleteItemOperation;
  private final FindAllItemsOperation findAllItemsOperation;
  private final FindItemByIdOperation findItemByIdOperation;
  private final EditItemOperation editItemOperation;
  private final RemoveTagsFromItemOperation removeTagsFromItemOperation;
  private final RemoveMultimediaFromItemOperation removeMultimediaFromItemOperation;
  private final RemoveVendorsFromItemOperation removeVendorsFromItemOperation;
  private final AddCommentToItemOperation addCommentToItemOperation;

  @GetMapping("/all/params")
  @Transactional
  public ResponseEntity<FindAllItemsOutput> findAll(@RequestParam Boolean showDeleted,
                                                    @RequestParam Optional<Integer> pageNumber,
                                                    @RequestParam Optional<Integer> pageSize,
                                                    @RequestParam Optional<String> titleContains,
                                                    @RequestParam Optional<String> descriptionContains) {

    FindAllItemsInput input = FindAllItemsInput.builder()
            .showDeleted(showDeleted)
            .pageNumber(pageNumber)
            .pageSize(pageSize)
            .titleContains(titleContains)
            .descriptionContains(descriptionContains)
            .build();
    return ResponseEntity.ok(
        findAllItemsOperation.process(input));
  }
  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity<FindItemByIdOutput> findItemById(@PathVariable String id) {
    return ResponseEntity.ok(
            findItemByIdOperation.process(
                    FindItemByIdInput.builder().id(id).build()));
  }

  @PostMapping
  @Operation(summary = "Create item", description = "Create a new item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<CreateItemOutput> create(@RequestBody CreateItemInput request) {
    return ResponseEntity.ok(createItemOperation.process(request));
  }

  @DeleteMapping
  @Transactional
  @Operation(summary = "Delete item", description = "Delete an existing item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<DeleteItemOutput> delete(@RequestBody DeleteItemInput request) {
    return ResponseEntity.ok(deleteItemOperation.process(request));
  }

  @PutMapping
  @Operation(summary = "Update item", description = "Update an existing item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<EditItemOutput> update(@RequestBody EditItemInput request) {
    return ResponseEntity.ok(editItemOperation.process(request));
  }

  @PostMapping("/add-tags")
  @Transactional
  @Operation(summary = "Add tags to item", description = "Add tags to an existing item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item/Tag not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<AddTagsToItemOutput> addTags(@RequestBody AddTagsToItemInput request) {
    return ResponseEntity.ok(addTagsToItemOperation.process(request));
  }

  @DeleteMapping("/remove-tags")
  @Transactional
  @Operation(summary = "Remove tags from item", description = "Remove tags from an existing item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item/Tag not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<RemoveTagsFromItemOutput> deleteTags(
      @RequestBody RemoveTagsFromItemInput request) {
    return ResponseEntity.ok(removeTagsFromItemOperation.process(request));
  }

  @PostMapping("/add-vendors")
  @Transactional
  @Operation(summary = "Add vendors to item", description = "Add vendors to an existing item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item/Vendor not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<AddVendorsToItemOutput> addVendors(
      @RequestBody AddVendorsToItemInput request) {
    return ResponseEntity.ok(addVendorsToItemOperation.process(request));
  }

  @DeleteMapping("/remove-vendors")
  @Transactional
  @Operation(summary = "Remove vendors from item", description = "Remove vendors from an existing item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item/Vendor not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<RemoveVendorsFromItemOutput> deleteVendors(
      @RequestBody RemoveVendorsFromItemInput request) {
    return ResponseEntity.ok(removeVendorsFromItemOperation.process(request));
  }


  @DeleteMapping("/remove-multimedia")
  @Transactional
  @Operation(summary = "Remove multimedia", description = "Remove multimedia from item.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Multimedia not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<RemoveMultimediaFromItemOutput> deleteMultimedia(
      @RequestBody RemoveMultimediaFromItemInput request) {
    return ResponseEntity.ok(removeMultimediaFromItemOperation.process(request));
  }

  @PostMapping("/add-comment")
  @Transactional
  @Operation(summary = "Add comment to item", description = "Add comment to item")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "Item not found", content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "403", description = "Forbidden access", content = @Content(mediaType = "application/json"))
  })
  public ResponseEntity<AddCommentToItemOutput> addComment(
          @RequestBody AddCommentToItemInput request){
    return ResponseEntity.ok(addCommentToItemOperation.process(request));
  }
}
