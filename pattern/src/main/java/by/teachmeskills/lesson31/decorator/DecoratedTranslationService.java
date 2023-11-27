package by.teachmeskills.lesson31.decorator;

public interface DecoratedTranslationService extends TranslationService {
    boolean isGrammaticallyCorrect(String text);
}
