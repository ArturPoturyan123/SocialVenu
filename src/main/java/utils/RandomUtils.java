package utils;

import org.apache.commons.lang3.RandomStringUtils;

public interface RandomUtils {


    static String getString() {
        return "test-" + RandomStringUtils.randomNumeric(10);
    }

    static int getInt() {
        return Integer.parseInt(RandomStringUtils.randomNumeric(1000));
    }
    
}
