package com.tinqin.core.processor.item;

import com.tinqin.api.operation.item.create.CreateItemInput;
import com.tinqin.api.operation.item.create.CreateItemOutput;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureInput;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureOperation;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureOutput;
import com.tinqin.persistence.model.Tag;
import com.tinqin.persistence.model.Vendor;
import com.tinqin.persistence.repository.TagRepository;
import com.tinqin.persistence.repository.VendorRepository;
import java.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateItemFixtureProcessor implements GenerateItemFixtureOperation {
    private final VendorRepository vendorRepository;
    private final TagRepository tagRepository;
    private final CreateItemOperationProcessor createItemOperationProcessor;
    private final PodamFactory podamFactory = new PodamFactoryImpl();
    @Override
    public GenerateItemFixtureOutput process(GenerateItemFixtureInput request) {
        ArrayList<UUID> vendorIds = new ArrayList<>(vendorRepository.findAll().stream()
                .map(Vendor::getId)
                .toList());

        ArrayList<UUID> tagIds = new ArrayList<>(tagRepository.findAll().stream()
                .map(Tag::getId)
                .toList());

        List<CreateItemOutput> itemOutputList = new ArrayList<>();

        for (int i = 0; i < request.getCount(); i++) {
            CreateItemInput createItemInput = createMockItemInput(vendorIds, tagIds);
            itemOutputList.add(createItemOperationProcessor.process(createItemInput));
        }

        return GenerateItemFixtureOutput.builder()
                .createItemOutputList(itemOutputList)
                .build();
    }

    private CreateItemInput createMockItemInput(List<UUID> vendorIds, List<UUID> tagIds) {
        Collections.shuffle(vendorIds);
        Collections.shuffle(tagIds);

        CreateItemInput createItemInput = podamFactory.manufacturePojo(CreateItemInput.class);
        createItemInput.setVendorIds(new HashSet<>(vendorIds.subList(0, 3)));
        createItemInput.setTagIds(new HashSet<>(tagIds.subList(0,3)));

        return createItemInput;
    }
}
