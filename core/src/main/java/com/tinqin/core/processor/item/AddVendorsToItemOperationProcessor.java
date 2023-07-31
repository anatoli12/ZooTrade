package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.addvendorstoitem.AddVendorsToItemInput;
import com.tinqin.api.operation.item.addvendorstoitem.AddVendorsToItemOperation;
import com.tinqin.api.operation.item.addvendorstoitem.AddVendorsToItemOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.ItemRepository;
import com.tinqin.persistence.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddVendorsToItemOperationProcessor implements AddVendorsToItemOperation {
    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;


    @Override
    public AddVendorsToItemOutput process(AddVendorsToItemInput request) {
        Item item =
                itemRepository
                        .findById(UUID.fromString(request.getItemId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Set<Vendor> vendorsToAdd =
                request.getVendorIds().stream()
                        .map(UUID::fromString)
                        .map(v -> vendorRepository
                                .findById(v)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
                        .collect(Collectors.toSet());
        Set<Vendor> itemVendors =
                Optional.ofNullable(item.getVendors()).orElseGet(HashSet::new);

        itemVendors.addAll(vendorsToAdd);
        item.setVendors(itemVendors);
        itemRepository.save(item);
        BaseItemDTO base = ItemEntityToDTOProcessor.convertEntityToDTO(item);
        return AddVendorsToItemOutput.builder().baseItemDTO(base).build();
    }
}
