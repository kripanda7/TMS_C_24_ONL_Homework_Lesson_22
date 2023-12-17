package by.teachmeskills.lesson30.singleton;

import org.apache.log4j.Logger;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        LOGGER.info(appConfig.toString());
    }
}
