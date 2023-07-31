package com.tinqin.api.base;

public interface Processor<I extends ProcessorInput, O extends ProcessorOutput> {
  O process(I request);
}
