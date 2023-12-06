package by.teachmeskills.lesson31.decorator;

public class EnglishTranslator implements TranslationService {
    @Override
    public void translate(String text) {
        System.out.println("Translation in English.");
    }
}
