package net.acetheeldritchking.art_of_forging.capabilities;

import net.acetheeldritchking.art_of_forging.capabilities.carnage.PlayerCarnage;
import net.acetheeldritchking.art_of_forging.capabilities.conquer.PlayerConquer;
import net.acetheeldritchking.art_of_forging.capabilities.devouring.PlayerDevouring;
import net.acetheeldritchking.art_of_forging.capabilities.karma.PlayerKarma;
import net.acetheeldritchking.art_of_forging.capabilities.soulCharge.PlayerSoulCharge;
import net.acetheeldritchking.art_of_forging.capabilities.subjugation.PlayerSubjugation;
import net.minecraft.world.entity.player.Player;

import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

public final class AoFPlayerData {
    private static final Map<Player, State> STATES = new WeakHashMap<>();

    private AoFPlayerData() {
    }

    public static Optional<PlayerDevouring> getDevouring(Player player) {
        return Optional.of(state(player).devouring);
    }

    public static Optional<PlayerCarnage> getCarnage(Player player) {
        return Optional.of(state(player).carnage);
    }

    public static Optional<PlayerSoulCharge> getSoulCharge(Player player) {
        return Optional.of(state(player).soulCharge);
    }

    public static Optional<PlayerKarma> getKarma(Player player) {
        return Optional.of(state(player).karma);
    }

    public static Optional<PlayerConquer> getConquer(Player player) {
        return Optional.of(state(player).conquer);
    }

    public static Optional<PlayerSubjugation> getSubjugation(Player player) {
        return Optional.of(state(player).subjugation);
    }

    public static void copy(Player original, Player clone) {
        State oldState = state(original);
        State newState = state(clone);
        newState.devouring.copyFrom(oldState.devouring);
        newState.carnage.copyFrom(oldState.carnage);
        newState.soulCharge.copyFrom(oldState.soulCharge);
        newState.karma.copyFrom(oldState.karma);
        newState.conquer.copyFrom(oldState.conquer);
        newState.subjugation.copyFrom(oldState.subjugation);
    }

    private static State state(Player player) {
        return STATES.computeIfAbsent(player, ignored -> new State());
    }

    private static final class State {
        private final PlayerDevouring devouring = new PlayerDevouring();
        private final PlayerCarnage carnage = new PlayerCarnage();
        private final PlayerSoulCharge soulCharge = new PlayerSoulCharge();
        private final PlayerKarma karma = new PlayerKarma();
        private final PlayerConquer conquer = new PlayerConquer();
        private final PlayerSubjugation subjugation = new PlayerSubjugation();
    }
}
