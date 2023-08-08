package com.tinqin.rest.controller;

import com.tinqin.api.operation.multimedia.create.CreateMultimediaInput;
import com.tinqin.api.operation.multimedia.create.CreateMultimediaOperation;
import com.tinqin.api.operation.multimedia.create.CreateMultimediaOutput;
import com.tinqin.api.operation.multimedia.edit.EditMultimediaInput;
import com.tinqin.api.operation.multimedia.edit.EditMultimediaOperation;
import com.tinqin.api.operation.multimedia.edit.EditMultimediaOutput;
import com.tinqin.api.operation.multimedia.findall.FindAllMultimediaInput;
import com.tinqin.api.operation.multimedia.findall.FindAllMultimediaOperation;
import com.tinqin.api.operation.multimedia.findall.FindAllMultimediaOutput;
import com.tinqin.api.operation.multimedia.findbyid.FindMultimediaByIdInput;
import com.tinqin.api.operation.multimedia.findbyid.FindMultimediaByIdOperation;
import com.tinqin.api.operation.multimedia.findbyid.FindMultimediaByIdOutput;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/multimedia")
public class MultimediaController {
  private final CreateMultimediaOperation createMultimediaOperation;
  private final EditMultimediaOperation editMultimediaOperation;
  private final FindAllMultimediaOperation findAllMultimediaOperation;
  private final FindMultimediaByIdOperation findMultimediaByIdOperation;

  @PostMapping
  public ResponseEntity<CreateMultimediaOutput> create(@RequestBody CreateMultimediaInput request) {
    return ResponseEntity.ok(createMultimediaOperation.process(request));
  }

  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity<FindMultimediaByIdOutput> findById(@PathVariable String id) {
    return ResponseEntity.ok(
        findMultimediaByIdOperation.process(FindMultimediaByIdInput.builder().id(id).build()));
  }

  @GetMapping("/all")
  @Transactional
  public ResponseEntity<FindAllMultimediaOutput> findAll() {
    return ResponseEntity.ok(findAllMultimediaOperation.process(new FindAllMultimediaInput()));
  }

  @PutMapping
  @Transactional
  public ResponseEntity<EditMultimediaOutput> update(@RequestBody EditMultimediaInput request) {
    return ResponseEntity.ok(editMultimediaOperation.process(request));
  }
}
