package com.tinqin.rest.commands;

import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureInput;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureOperation;
import com.tinqin.api.operation.item.generateitemfixture.GenerateItemFixtureOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommands {

    private final GenerateItemFixtureOperation generateItemFixtureOperation;
    @ShellMethod(key = "generate-item", value = "Generate items")
    public GenerateItemFixtureOutput generateItems(@ShellOption(defaultValue = "5") Integer count){
        return generateItemFixtureOperation.process(GenerateItemFixtureInput.builder()
                .count(count)
                .build());
    }
}

