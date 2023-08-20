package com.tinqin.rest.controller;

import com.tinqin.api.operation.tag.create.CreateTagInput;
import com.tinqin.api.operation.tag.create.CreateTagOperation;
import com.tinqin.api.operation.tag.create.CreateTagOutput;
import com.tinqin.api.operation.tag.edit.EditTagInput;
import com.tinqin.api.operation.tag.edit.EditTagOperation;
import com.tinqin.api.operation.tag.edit.EditTagOutput;
import com.tinqin.api.operation.tag.findall.FindAllTagsInput;
import com.tinqin.api.operation.tag.findall.FindAllTagsOperation;
import com.tinqin.api.operation.tag.findall.FindAllTagsOutput;
import com.tinqin.api.operation.tag.findbyid.FindTagByIdInput;
import com.tinqin.api.operation.tag.findbyid.FindTagByIdOperation;
import com.tinqin.api.operation.tag.findbyid.FindTagByIdOutput;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureInput;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureOperation;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureOutput;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {
  private final CreateTagOperation createTagOperation;
  private final EditTagOperation editTagOperation;
  private final FindAllTagsOperation findAllTagsOperation;
  private final FindTagByIdOperation findTagByIdOperation;
  private final GenerateTagFixtureOperation generateTagFixtureOperation;

  @PostMapping
  public ResponseEntity<CreateTagOutput> create(@RequestBody CreateTagInput request) {
    return ResponseEntity.ok(createTagOperation.process(request));
  }

  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity<FindTagByIdOutput> findById(@PathVariable String id) {
    return ResponseEntity.ok(
        findTagByIdOperation.process(FindTagByIdInput.builder().id(id).build()));
  }

  @GetMapping("/all")
  @Transactional
  public ResponseEntity<FindAllTagsOutput> findAll() {
    return ResponseEntity.ok(findAllTagsOperation.process(new FindAllTagsInput()));
  }

  @PutMapping
  @Transactional
  public ResponseEntity<EditTagOutput> update(@RequestBody EditTagInput request) {
    return ResponseEntity.ok(editTagOperation.process(request));
  }

  @PostMapping("/generate")
  public ResponseEntity<GenerateTagFixtureOutput> generate(@RequestBody GenerateTagFixtureInput request){
    return ResponseEntity.ok(
            generateTagFixtureOperation.process(request)
    );
  }
}
