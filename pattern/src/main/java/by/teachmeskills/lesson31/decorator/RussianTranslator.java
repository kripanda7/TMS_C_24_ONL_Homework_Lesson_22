package by.teachmeskills.lesson31.decorator;

public class RussianTranslator implements TranslationService {
    @Override
    public void translate(String text) {
        System.out.println("Перевод на русском.");
    }
}

