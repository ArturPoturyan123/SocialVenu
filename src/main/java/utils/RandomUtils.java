package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public interface RandomUtils {


    static String getString() {
        return "test " + RandomStringUtils.randomNumeric(5);
    }

    static int getInt() {
        return ThreadLocalRandom.current().nextInt(1000);

    }

}
