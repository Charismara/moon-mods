package de.blutmondgilde.moonmagic.client;

import de.blutmondgilde.moonmagic.CommonProxy;
import de.blutmondgilde.moonmagic.client.renderer.MoonMagicRenderer;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        MoonMagicRenderer.registerEventListeners();
    }

    @Override
    public void initClient() {
        MoonMagicRenderer.init();
    }
}
