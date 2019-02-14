package io.vpv.math.problemgenerateor.util;

import org.springframework.stereotype.Component;

/**
 * Created by vprasanna on 2/14/19.
 */
@Component
public class AppUtil {

    public static final String LOCAL_TESTING = "LOCAL_TESTING";

    /**
     * Check if the user is trying for local testing.
     *
     * @param key
     * @return
     */
    public boolean isLocal(String key) {
        if (null != key && key.equalsIgnoreCase("local")) {
            return true;
        }
        return false;
    }
}
