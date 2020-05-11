package com.akoca.containerservice.utilities;

import org.modelmapper.ModelMapper;

public final class ModelMappingUtils {
    private ModelMappingUtils() {}

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, S> D mapRegular(Class<D> to, S source) {
        return modelMapper.map(source, to);
    }
}
