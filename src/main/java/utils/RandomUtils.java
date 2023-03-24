package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public interface RandomUtils {


    static String getString() {
        return "test " + RandomStringUtils.randomNumeric(5);
    }

      void move();

    static int getInt() {
        return getInt(1000);
    }
    static int getInt(int range) {
        return ThreadLocalRandom.current().nextInt(range);
    }

}
