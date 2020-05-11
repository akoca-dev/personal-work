package com.akoca.exercise.util.lambdaUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T , R , E extends Throwable> {

    Logger LOGGER = LoggerFactory.getLogger(ThrowingFunction.class);

    R apply(T t) throws E;

    static <T , R , E extends Throwable> Function<T , R> applyChecked(ThrowingFunction<T , R , E> throwingFunction, Class<E> exClass) {
        return t -> {
            try {
                return throwingFunction.apply(t);
            } catch (Throwable ex) {
                try {
                    E exCast = exClass.cast(ex);
                    LOGGER.error("Error happened: Exception Message is: {}", exCast.getMessage());
                    throw new RuntimeException(ex);
                } catch (ClassCastException cce){
                    throw new RuntimeException(ex);
                }
            }
        };
    }
}
