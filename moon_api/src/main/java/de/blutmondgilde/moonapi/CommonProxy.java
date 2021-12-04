package de.blutmondgilde.moonapi;

import de.blutmondgilde.moonapi.network.packet.SyncSimpleCapabilityPacket;

public class CommonProxy {
    /** No handling since Capabilities always syncs from Server to Client */
    public void updateEntityCapability(SyncSimpleCapabilityPacket packet) {}

    public void clientSetup(){}
}
