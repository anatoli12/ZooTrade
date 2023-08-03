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
  @Override
  public FindAllItemsOutput process(FindAllItemsInput request) {

    int pageNumber = request.getPageNumber().orElse(0);

    // Get the pageSize from the request, or use 10 if it is not present, less than 1, or greater
    // than 50
    int size = request.getPageSize().filter(s -> s >= 1 && s <= 50).orElse(10);

    Pageable pageable = PageRequest.of(pageNumber, size);
    Page<Item> items = itemRepository.findAll(
            request.getTitleContains(),
            request.getDescriptionContains(),
            request.getShowDeleted(),
            pageable
    );
    List<BaseItemDTO> result =
        items.stream().map(ItemEntityToDTOProcessor::convertEntityToDTO).toList();

    return FindAllItemsOutput.builder().items(result).build();
  }
}
