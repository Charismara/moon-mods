package de.blutmondgilde.moonmagic.testing;

import de.blutmondgilde.moonapi.capability.IMoonCapability;

public interface ITestCap extends IMoonCapability {
    void setValue(String value);

    String getValue();
}
