package com.akoca.exercise.util;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    public static void nullCheckArguments(Object ... arguments) {
        try {
            for(Object arg : arguments) {
                Preconditions.checkNotNull(arg);
            }
        } catch (NullPointerException npe) {
            LOGGER.error("Dependency not satisfied");
        }
    }
}