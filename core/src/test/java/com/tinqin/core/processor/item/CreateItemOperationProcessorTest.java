package com.tinqin.core.processor.item;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tinqin.api.operation.item.create.CreateItemInput;
import com.tinqin.api.operation.item.create.CreateItemOutput;
import com.tinqin.core.exception.TagNotFoundException;
import com.tinqin.core.exception.VendorNotFoundException;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.TagRepository;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

class CreateItemOperationProcessorTest {

  @Mock
  private VendorRepository vendorRepository;

  @Mock
  private ItemRepository itemRepository;

  @Mock
  private TagRepository tagRepository;

  @InjectMocks
  private CreateItemOperationProcessor itemProcessor;

  PodamFactory podamFactory = new PodamFactoryImpl();
  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testProcessWithValidInput() {
    // Mock input data
    CreateItemInput input = podamFactory.manufacturePojo(CreateItemInput.class);

    List<UUID> vendorIds = input.getVendorIds().stream().toList();
    UUID vendorId1=vendorIds.get(0);
    UUID vendorId2=vendorIds.get(1);
    List<UUID> tagIds = input.getTagIds().stream().toList();
    UUID tagId1=tagIds.get(0);
    UUID tagId2=tagIds.get(1);

    // Mock the vendor and tag repositories
    Vendor vendor1 = Vendor.builder()
            .id(vendorIds.get(0))
            .build();
    Vendor vendor2 = Vendor.builder()
            .id(vendorIds.get(1))
            .build();
    when(vendorRepository.findById(vendorId1)).thenReturn(Optional.of(vendor1));
    when(vendorRepository.findById(vendorId2)).thenReturn(Optional.of(vendor2));

    Tag tag1 = Tag.builder()
            .id(tagId1)
            .build();
    Tag tag2 = Tag.builder()
            .id(tagId2)
            .build();
    when(tagRepository.findById(tagId1)).thenReturn(Optional.of(tag1));
    when(tagRepository.findById(tagId2)).thenReturn(Optional.of(tag2));

    // Mock the item repository
    Item savedItem = Item.builder()
            .build();
    when(itemRepository.save(any(Item.class))).thenReturn(savedItem);

    // Perform the operation
    CreateItemOutput output = itemProcessor.process(input);

    // Verify the results
    assertNotNull(output);
    assertNotNull(output.getBaseItemDTO());
    assertEquals(input.getTitle(), output.getBaseItemDTO().getTitle());
    assertEquals(input.getDescription(), output.getBaseItemDTO().getDescription());
    assertEquals(2, output.getBaseItemDTO().getVendorIds().size());
    assertEquals(2, output.getBaseItemDTO().getTagIds().size());

    // Verify that the item repository's save method was called once
    verify(itemRepository, times(1)).save(any(Item.class));
  }
  @Test
  void testProcessWithInvalidVendorId() {

    // Mock input data with invalid vendor id
    CreateItemInput input = podamFactory.manufacturePojo(CreateItemInput.class);

    List<UUID> vendorIds = input.getVendorIds().stream().toList();

    // Mock the vendor repository to return an empty Optional (not found)
    when(vendorRepository.findById(vendorIds.get(0))).thenReturn(Optional.empty());

    // Perform the operation and expect an exception
    assertThrows(VendorNotFoundException.class, () -> itemProcessor.process(input));

    // Verify that the item repository's save method was not called (invalid vendor ID)
    verify(itemRepository, never()).save(any(Item.class));
  }


  @Test
  void testProcessWithInvalidTagId() {
    // Mock input data with invalid tag id
    CreateItemInput input = podamFactory.manufacturePojo(CreateItemInput.class);

    List<UUID> tagIds = input.getTagIds().stream().toList();
    List<UUID> vendorIds = input.getVendorIds().stream().toList();
    UUID vendorId1=vendorIds.get(0);
    UUID vendorId2=vendorIds.get(1);

    when(vendorRepository.findById(vendorId1)).thenReturn(Optional.of(new Vendor()));
    when(vendorRepository.findById(vendorId2)).thenReturn(Optional.of(new Vendor()));
    // Mock the tag repository to return an empty Optional (not found)
    when(tagRepository.findById(tagIds.get(0))).thenReturn(Optional.empty());

    // Perform the operation and expect an exception
    assertThrows(TagNotFoundException.class, () -> itemProcessor.process(input));

    // Verify that the item repository's save method was not called (invalid tag ID)
    verify(itemRepository, never()).save(any(Item.class));
  }
}
