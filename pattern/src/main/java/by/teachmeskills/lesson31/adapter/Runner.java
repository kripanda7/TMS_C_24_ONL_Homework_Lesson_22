package by.teachmeskills.lesson31.adapter;

import org.apache.log4j.Logger;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);
    public static void main(String[] args) {
        EUPlugConnector plugConnector = () -> LOGGER.info("Using EU electricity.");
        USSocket usSocket = new USSocket();
        USPlugConnector usAdapter = new EU2USPlugConnectorAdapter(plugConnector);
        usSocket.plugIn(usAdapter);
    }
}
