package net.acetheeldritchking.art_of_forging.events;

import net.acetheeldritchking.art_of_forging.ArtOfForging;
import net.acetheeldritchking.art_of_forging.capabilities.AoFPlayerData;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;


@EventBusSubscriber(modid = ArtOfForging.MOD_ID)
public class AoFEvents {
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            AoFPlayerData.copy(event.getOriginal(), event.getEntity());
        }
    }
}
