package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.removevendorsfromitem.RemoveVendorsFromItemInput;
import com.tinqin.api.operation.item.removevendorsfromitem.RemoveVendorsFromItemOperation;
import com.tinqin.api.operation.item.removevendorsfromitem.RemoveVendorsFromItemOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RemoveVendorsFromItemOperationProcessor implements RemoveVendorsFromItemOperation {

  private final VendorRepository vendorRepository;
  private final ItemRepository itemRepository;

  @Override
  public RemoveVendorsFromItemOutput process(RemoveVendorsFromItemInput request) {
    Item item =
        itemRepository
            .findById(UUID.fromString(request.getItemId()))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Set<Vendor> vendorsToRemove =
        request.getVendorIds().stream()
            .map(UUID::fromString)
            .map(
                v ->
                    vendorRepository
                        .findById(v)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
            .collect(Collectors.toSet());

    Set<Vendor> itemVendors = Optional.ofNullable(item.getVendors()).orElseGet(HashSet::new);
    itemVendors.removeAll(vendorsToRemove);
    item.setVendors(itemVendors);
    itemRepository.save(item);

    BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
    return RemoveVendorsFromItemOutput.builder().baseItemDTO(base).build();
  }
}
