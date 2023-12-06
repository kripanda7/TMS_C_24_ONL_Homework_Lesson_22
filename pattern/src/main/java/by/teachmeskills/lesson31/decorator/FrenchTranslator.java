package by.teachmeskills.lesson31.decorator;

public class FrenchTranslator implements TranslationService {
    @Override
    public void translate(String text) {
        System.out.println("Traduction en français.");
    }
}
