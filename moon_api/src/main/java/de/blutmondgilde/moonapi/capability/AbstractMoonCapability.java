package de.blutmondgilde.moonapi.capability;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractMoonCapability<T extends IMoonCapability> {
    private final Lazy<Capability<T>> capabilityReference;

    public AbstractMoonCapability(Lazy<Capability<T>> capabilityReference) {
        this.capabilityReference = capabilityReference;
    }

    @NotNull
    public <C> LazyOptional<C> getCapability(@NotNull Capability<C> cap, @Nullable Direction side) {
        return capabilityReference.get().orEmpty(cap, getCurrentInstance());
    }

    protected abstract LazyOptional<T> getCurrentInstance();
}
