package net.acetheeldritchking.art_of_forging.networking.packet;

public class SoulChargedParticlesS2CPacket {
    private final double xPos;
    private final double yPos;
    private final double zPos;

    public SoulChargedParticlesS2CPacket(double xPos, double yPos, double zPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
    }
}
