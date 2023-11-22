package by.teachmeskills.lesson30.singleton;

public class Runner {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        System.out.println(appConfig.toString());
    }
}
