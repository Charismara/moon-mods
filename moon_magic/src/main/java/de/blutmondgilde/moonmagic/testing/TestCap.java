package de.blutmondgilde.moonmagic.testing;

import de.blutmondgilde.moonapi.capability.AbstractMoonCapability;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.LazyOptional;

public class TestCap extends AbstractMoonCapability<ITestCap> implements ITestCap {
    @Getter
    @Setter
    private String value = "default";

    public TestCap(Lazy<Capability<ITestCap>> capabilityReference) {
        super(capabilityReference);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("value", this.value);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.value = nbt.getString("value");
    }

    @Override
    protected LazyOptional<ITestCap> getCurrentInstance() {
        return LazyOptional.of(() -> this);
    }
}
