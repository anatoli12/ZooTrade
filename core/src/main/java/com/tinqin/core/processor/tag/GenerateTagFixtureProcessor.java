package com.tinqin.core.processor.tag;

import com.tinqin.api.operation.tag.create.CreateTagInput;
import com.tinqin.api.operation.tag.create.CreateTagOperation;
import com.tinqin.api.operation.tag.create.CreateTagOutput;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureInput;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureOperation;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureOutput;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateTagFixtureProcessor implements GenerateTagFixtureOperation {
    private final PodamFactory podamFactory = new PodamFactoryImpl();
    private final CreateTagOperation createTagOperation;

    @Override
    public GenerateTagFixtureOutput process(GenerateTagFixtureInput request) {
        List<CreateTagOutput> createTagOutputList=new ArrayList<>();
        for(int i=0;i<request.getCount();i++){
            CreateTagInput createTagInput = podamFactory.manufacturePojo(CreateTagInput.class);
            createTagOutputList.add(createTagOperation.process(createTagInput));
        }
        return GenerateTagFixtureOutput.builder()
                .tags(createTagOutputList)
                .build();
    }
}
