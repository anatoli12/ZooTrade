package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.BaseItemDTO;
import com.tinqin.api.operation.item.findall.FindAllItemsInput;
import com.tinqin.api.operation.item.findall.FindAllItemsOperation;
import com.tinqin.api.operation.item.findall.FindAllItemsOutput;
import com.tinqin.persistence.model.Item;
import com.tinqin.persistence.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindAllItemsOperationProcessor implements FindAllItemsOperation {
  private final EntityManager entityManager;
  private final ItemRepository itemRepository;

  //  Boolean showDeleted;
  //  Optional<Integer> page;
  //  Optional<Integer> size;
  @Override
  public FindAllItemsOutput process(FindAllItemsInput request) {

    int pageNumber = Math.max(0, request.getPageNumber().orElse(0));
    int size = Math.max(1, Math.min(request.getPageSize().orElse(10), 50));

    Pageable pageable = PageRequest.of(pageNumber, size);
    Boolean showDeleted = request.getShowDeleted();
    Page<Item> items =
        Boolean.TRUE.equals(showDeleted)
            ? itemRepository.findAll(pageable)
            : itemRepository.findAllByIsDeleted(false, pageable);

    List<BaseItemDTO> result =
        items.stream().map(ItemEntityToDTOProcessor::convertEntityToDTO).toList();

    return FindAllItemsOutput.builder().items(result).build();
    //    Set<Item> items =
    //        itemRepository.findAll().stream()
    //            .filter(i -> request.isShowDeleted() || !i.isDeleted())
    //            .collect(Collectors.toSet());
    //    Set<BaseItemDTO> base =
    //        items.stream()
    //            .map(ItemEntityToDTOProcessor::convertEntityToDTO)
    //            .collect(Collectors.toSet());
    //    return FindAllItemsOutput.builder().items(base).build();
  }
}
