package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface RandomUtils {
    public static String getRandomNumericString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    static String getString() {
        return "test " + getRandomNumericString(5);
    }

    static int getInt() {
        return getInt(1000);
    }

    static int getInt(int range) {
        return ThreadLocalRandom.current().nextInt(range);
    }

}
