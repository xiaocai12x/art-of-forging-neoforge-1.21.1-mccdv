package net.acetheeldritchking.art_of_forging.networking;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

public class AoFPackets {
    public static void register() {
    }

    public static <MSG> void sendToClient(MSG message) {
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
    }

    public static <MGS> void sendToEntity(MGS message, LivingEntity entity) {
    }
}
