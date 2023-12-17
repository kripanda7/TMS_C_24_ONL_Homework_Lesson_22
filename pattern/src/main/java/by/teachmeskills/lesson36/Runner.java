package by.teachmeskills.lesson36;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Runner {

    private static final Logger LOGGER = Logger.getLogger(by.teachmeskills.lesson33.Runner.class);

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        String[] strs = new String[]{"a", "b", "a", "c", "b"};
        LOGGER.info(Arrays.toString(strs));
        Map<String, Boolean> map = new HashMap<>();
        for (String str : strs) {
            map.put(str, Arrays.stream(strs).filter(s -> s.equals(str)).count() > 1);
        }
        LOGGER.info(map);
    }

    private static void task2() {
        String[] strs = new String[]{"man", "moon", "good", "night"};
        LOGGER.info(Arrays.toString(strs));
        Map<String, String> map = new HashMap<>();
        for (String str : strs) {
            map.put(str.substring(0, 1), str.substring(str.length() - 1));
        }
        LOGGER.info(map);
    }
}
