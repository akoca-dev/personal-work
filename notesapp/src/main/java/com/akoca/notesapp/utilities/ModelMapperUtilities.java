package com.akoca.notesapp.utilities;

import com.akoca.notesapp.exceptionhandling.unchecked.ModelMappingException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public final class ModelMapperUtilities {
    private ModelMapperUtilities() {}

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> Mono<T> map (Class<T> to, Object source) {
        try {
            log.debug("Converting {} to {}", source.getClass().getName(), to.getName());
            return Mono.just(modelMapper.map(source, to));
        } catch (Exception e) {
            //String errorMessage = String.format("Converting %s to %s failed.Cause: %s.Stack trace: %n%s", source.getClass().getName(), to.getName(), e.getMessage(), ExceptionUtils.getStackTrace(e));
            String errorMessage = String.format("-----CHANGE WHEN ON CENTRAL REPO------Converting %s to %s failed.Cause: %s.Stack trace: %n%s", source.getClass().getName(), to.getName(), e.getMessage(), "stack trace");
            log.info(errorMessage);
            return Mono.error(new ModelMappingException(errorMessage, Instant.now(), source.getClass(), to));
        }
    }

    public static <T> Flux<T> map(Class<T> to, Flux<?> sourceCollection) {
        try {
            log.debug("Converting {} flux to {} flux", sourceCollection.getClass().getName(), to.getName());
            return sourceCollection.map(source -> modelMapper.map(source, to));
        } catch (Exception e) {
            String errorMessage = String.format("-----CHANGE WHEN ON CENTRAL REPO------Converting %s to %s failed.Cause: %s.Stack trace: %n%s", sourceCollection.getClass(), to.getName(), e.getMessage(), "stack trace");
            log.info(errorMessage);
            return Flux.error(new ModelMappingException(errorMessage, Instant.now(), sourceCollection.getClass(), to));
        }
    }
}