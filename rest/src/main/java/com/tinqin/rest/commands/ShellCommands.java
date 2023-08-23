package com.tinqin.rest.commands;

import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureInput;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureOperation;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureOutput;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureInput;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureOperation;
import com.tinqin.api.operation.tag.generatefixture.GenerateTagFixtureOutput;
import com.tinqin.api.operation.vendor.generatefixture.GenerateVendorFixtureInput;
import com.tinqin.api.operation.vendor.generatefixture.GenerateVendorFixtureOperation;
import com.tinqin.api.operation.vendor.generatefixture.GenerateVendorFixtureOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommands {

    private final GenerateItemFixtureOperation generateItemFixtureOperation;
    private final GenerateVendorFixtureOperation generateVendorFixtureOperation;
    private final GenerateTagFixtureOperation generateTagFixtureOperation;
    @ShellMethod(key = "generate-items", value = "Generate items")
    public GenerateItemFixtureOutput generateItems(@ShellOption(defaultValue = "5") Integer count){
        return generateItemFixtureOperation.process(GenerateItemFixtureInput.builder()
                .count(count)
                .build());
    }
    @ShellMethod(key = "generate-vendors", value = "Generate vendors")
    public GenerateVendorFixtureOutput generateVendors(@ShellOption(defaultValue = "5") Integer count){
        return generateVendorFixtureOperation.process(GenerateVendorFixtureInput.builder()
                .count(count)
                .build());
    }
    @ShellMethod(key = "generate-tags", value = "Generate tags")
    public GenerateTagFixtureOutput generateTags(@ShellOption(defaultValue = "5") Integer count){
        return generateTagFixtureOperation.process(GenerateTagFixtureInput.builder()
                .count(count)
                .build());
    }
}

