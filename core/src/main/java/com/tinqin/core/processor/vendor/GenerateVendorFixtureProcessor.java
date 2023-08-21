package com.tinqin.core.processor.vendor;

import com.tinqin.api.operation.vendor.create.CreateVendorInput;
import com.tinqin.api.operation.vendor.create.CreateVendorOperation;
import com.tinqin.api.operation.vendor.create.CreateVendorOutput;
import com.tinqin.api.operation.vendor.generatefixture.GenerateVendorFixtureInput;
import com.tinqin.api.operation.vendor.generatefixture.GenerateVendorFixtureOperation;
import com.tinqin.api.operation.vendor.generatefixture.GenerateVendorFixtureOutput;
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
public class GenerateVendorFixtureProcessor implements GenerateVendorFixtureOperation {
    private final PodamFactory podamFactory = new PodamFactoryImpl();
    private final CreateVendorOperation createVendorOperation;
    @Override
    public GenerateVendorFixtureOutput process(GenerateVendorFixtureInput request) {
        List<CreateVendorOutput> createVendorOutputList=new ArrayList<>();
        for(int i=0;i<request.getCount();i++){
            CreateVendorInput createVendorInput = podamFactory.manufacturePojo(CreateVendorInput.class);
            createVendorOutputList.add(createVendorOperation.process(createVendorInput));
        }
        return GenerateVendorFixtureOutput.builder()
                .vendorOutputList(createVendorOutputList)
                .build();
    }
}
