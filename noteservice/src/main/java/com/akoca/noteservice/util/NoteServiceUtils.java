package com.akoca.noteservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NoteServiceUtils {
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
}