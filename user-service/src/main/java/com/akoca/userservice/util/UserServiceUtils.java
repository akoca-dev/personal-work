package com.akoca.userservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserServiceUtils {
    public static String findMethodName() {
        StackWalker stackWalker = StackWalker.getInstance();

        Optional<String> methodNameOpt = stackWalker.walk(
                stackFrameStream -> stackFrameStream
                        .skip(1)
                        .findFirst()
                        .map(StackWalker.StackFrame::getMethodName)
        );

        return methodNameOpt.orElse(StringUtils.EMPTY);
    }

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream
                .of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}