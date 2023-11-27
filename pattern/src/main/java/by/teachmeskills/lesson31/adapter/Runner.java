package by.teachmeskills.lesson31.adapter;

public class Runner {
    public static void main(String[] args) {
        EUPlugConnector plugConnector = () -> System.out.println("Using EU electricity.");
        USSocket usSocket = new USSocket();
        USPlugConnector usAdapter = new EU2USPlugConnectorAdapter(plugConnector);
        usSocket.plugIn(usAdapter);
    }
}
