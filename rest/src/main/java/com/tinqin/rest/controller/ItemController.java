package com.tinqin.rest.controller;

import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemInput;
import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemOperation;
import com.tinqin.api.operation.item.addmultimediatoitem.AddMultimediaToItemOutput;
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
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

  @GetMapping("/all")
  @Transactional
  public ResponseEntity<FindAllItemsOutput> findAll(@RequestParam Boolean showDeleted,
                                                    @RequestParam Optional<Integer> pageNumber,
                                                    @RequestParam Optional<Integer> pageSize) {

    FindAllItemsInput input = FindAllItemsInput.builder()
            .showDeleted(showDeleted)
            .pageNumber(pageNumber)
            .pageSize(pageSize)
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
  public ResponseEntity<CreateItemOutput> create(@RequestBody CreateItemInput request) {
    return ResponseEntity.ok(createItemOperation.process(request));
  }

  @DeleteMapping
  @Transactional
  public ResponseEntity<DeleteItemOutput> delete(@RequestBody DeleteItemInput request) {
    return ResponseEntity.ok(deleteItemOperation.process(request));
  }

  @PutMapping
  public ResponseEntity<EditItemOutput> update(@RequestBody EditItemInput request) {
    return ResponseEntity.ok(editItemOperation.process(request));
  }

  @PostMapping("/add-tags")
  @Transactional
  public ResponseEntity<AddTagsToItemOutput> addTags(@RequestBody AddTagsToItemInput request) {
    return ResponseEntity.ok(addTagsToItemOperation.process(request));
  }

  @DeleteMapping("/remove-tags")
  @Transactional
  public ResponseEntity<RemoveTagsFromItemOutput> deleteTags(
      @RequestBody RemoveTagsFromItemInput request) {
    return ResponseEntity.ok(removeTagsFromItemOperation.process(request));
  }

  @PostMapping("/add-vendors")
  @Transactional
  public ResponseEntity<AddVendorsToItemOutput> addVendors(
      @RequestBody AddVendorsToItemInput request) {
    return ResponseEntity.ok(addVendorsToItemOperation.process(request));
  }

  @DeleteMapping("/remove-vendors")
  @Transactional
  public ResponseEntity<RemoveVendorsFromItemOutput> deleteVendors(
      @RequestBody RemoveVendorsFromItemInput request) {
    return ResponseEntity.ok(removeVendorsFromItemOperation.process(request));
  }

//  @PostMapping("/add-multimedia")
//  @Transactional
//  public ResponseEntity<AddMultimediaToItemOutput> addMultimedia(
//      @RequestBody AddMultimediaToItemInput request) {
//    return ResponseEntity.ok(addMultimediaToItemOperation.process(request));
//  }

  @DeleteMapping("/remove-multimedia")
  @Transactional
  public ResponseEntity<RemoveMultimediaFromItemOutput> deleteMultimedia(
      @RequestBody RemoveMultimediaFromItemInput request) {
    return ResponseEntity.ok(removeMultimediaFromItemOperation.process(request));
  }
}
