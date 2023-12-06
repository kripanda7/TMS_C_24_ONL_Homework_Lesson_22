package by.teachmeskills.lesson31.decorator;

public class Runner {
    public static void main(String[] args) {
        String text = "Перевести текст";
        DecoratedTranslationService translationService =
                new TranslationServiceImpl(new FrenchTranslator(), new EnglishTranslator());
        translationService.translate(text);
        translationService.isGrammaticallyCorrect(text);
    }
}
