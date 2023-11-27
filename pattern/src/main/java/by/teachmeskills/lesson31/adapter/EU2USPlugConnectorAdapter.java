package by.teachmeskills.lesson31.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EU2USPlugConnectorAdapter implements USPlugConnector {
    private final EUPlugConnector plug;

    @Override
    public void provideElectricity() {
        plug.giveElectricity();
    }
}
