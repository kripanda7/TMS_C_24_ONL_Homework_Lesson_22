package by.teachmeskills.lesson31.decorator;

import java.util.List;

public class TranslationServiceImpl implements DecoratedTranslationService {
    private final List<TranslationService> translators;

    public TranslationServiceImpl(TranslationService... translators) {
        this.translators = List.of(translators);
    }

    @Override
    public boolean isGrammaticallyCorrect(String text) {
        return true;
    }

    @Override
    public void translate(String text) {
        translators.forEach(it -> it.translate(text));
    }
}
