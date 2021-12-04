package de.blutmondgilde.moonapi.util;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class TickCounter implements Serializable {
    private final int totalTicks;
    private int currentTick = 0;

    public boolean tick() {
        if (currentTick >= totalTicks) {
            currentTick = 0;
            return true;
        } else {
            currentTick++;
            return false;
        }
    }
}
