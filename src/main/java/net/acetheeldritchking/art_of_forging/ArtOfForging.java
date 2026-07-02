package net.acetheeldritchking.art_of_forging;

import com.mojang.logging.LogUtils;
import net.acetheeldritchking.art_of_forging.effects.*;
import net.acetheeldritchking.art_of_forging.effects.curio.*;
import net.acetheeldritchking.art_of_forging.effects.potion.PotionEffects;
import net.acetheeldritchking.art_of_forging.item.AoFCreativeModeTab;
import net.acetheeldritchking.art_of_forging.loot.ModLootModifiers;
import net.acetheeldritchking.art_of_forging.networking.AoFPackets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.InterModComms;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ArtOfForging.MOD_ID)
public class ArtOfForging {
    public static final String MOD_ID = "art_of_forging";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ArtOfForging(ModContainer modContainer) {
        var bus = modContainer.getEventBus();

        // Register the commonSetup method for modloading
        bus.addListener(this::commonSetup);
        // Curios
        bus.addListener(this::enqueueIMC);

        // Items //
        AoFRegistry.ITEMS.register(bus);
        AoFCreativeModeTab.register(bus);

        // Loot Tables //
        ModLootModifiers.register(bus);

        // Potion Effects //
        PotionEffects.register(bus);

        // Item Effects //
        // Withering
        NeoForge.EVENT_BUS.register(new WitheringEffect());
        // Storm Caller
        NeoForge.EVENT_BUS.register(new StormCallerEffect());
        // Evoking Maw
        NeoForge.EVENT_BUS.register(new EvokingMawEffect());
        // Life Steal
        NeoForge.EVENT_BUS.register(new LifeStealEffect());
        // Knockback
        NeoForge.EVENT_BUS.register(new KnockbackEffect());
        // Life Fiber Loss
        NeoForge.EVENT_BUS.register(new LifeFiberLossEffect());
        // Cavalry
        NeoForge.EVENT_BUS.register(new CavalryEffect());
        // Dismounting
        NeoForge.EVENT_BUS.register(new DismountingEffect());
        // Dragon Mist
        NeoForge.EVENT_BUS.register(new DragonMistEffect());
        // Disorienting
        NeoForge.EVENT_BUS.register(new DisorientingEffect());
        // Vengeance
        NeoForge.EVENT_BUS.register(new VengeanceEffect());
        // Resolve
        NeoForge.EVENT_BUS.register(new ResolveEffect());
        // Devouring
        NeoForge.EVENT_BUS.register(new DevouringEffect());
        // Infernal Rebuke
        NeoForge.EVENT_BUS.register(new InfernalRebukeEffect());
        // Hubris
        NeoForge.EVENT_BUS.register(new HubrisEffect());
        // Slaughtering
        NeoForge.EVENT_BUS.register(new SlaughteringEffect());
        // Carnage
        NeoForge.EVENT_BUS.register(new CarnageEffect());
        // Judgement
        NeoForge.EVENT_BUS.register(new JudgementEffect());
        // Retribution
        NeoForge.EVENT_BUS.register(new RetributionEffect());
        // Esoteric Edge
        NeoForge.EVENT_BUS.register(new EsotericEdgeEffect());
        // Feasting
        NeoForge.EVENT_BUS.register(new FeastingEffect());
        // Nano-Fused
        NeoForge.EVENT_BUS.register(new NanoFusedEffect());
        // Beheading
        NeoForge.EVENT_BUS.register(new BeheadingEffect());
        // Soul Charged
        NeoForge.EVENT_BUS.register(new SoulChargedEffect());
        // Sonic Shock
        // SonicShockEffect only defines a charged ability and client stats, not event listeners.
        // Conquering
        NeoForge.EVENT_BUS.register(new ConqueringEffect());
        // Subjugation
        NeoForge.EVENT_BUS.register(new SubjugationEffect());
        // Goliath Slayer
        NeoForge.EVENT_BUS.register(new GoliathSlayerEffect());

        // Curio Effects //
        // Flame Protection
        NeoForge.EVENT_BUS.register(new CurioFireResistanceEffect());
        // Arcane Protection
        NeoForge.EVENT_BUS.register(new CurioMagicResistanceEffect());
        // Strength Infused
        NeoForge.EVENT_BUS.register(new CurioStrengthEffect());
        // Healing Infused
        NeoForge.EVENT_BUS.register(new CurioRegenerationEffect());
        // Karma Infused
        NeoForge.EVENT_BUS.register(new CurioKarmaEffect());
        // Haste Infused
        NeoForge.EVENT_BUS.register(new CurioHasteEffect());
        // Third Sight
        NeoForge.EVENT_BUS.register(new CurioGlowingEffect());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Packets let's go!
        event.enqueueWork(() -> {
            AoFPackets.register();
        });
    }

    // Curios Compat
    // I looked at how Artifacts did it
    public void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.CHARM.getMessageBuilder().size(1).build());
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            WitheringEffect.init();
            StormCallerEffect.init();
            EvokingMawEffect.init();
            LifeStealEffect.init();
            KnockbackEffect.init();
            LifeFiberLossEffect.init();
            CavalryEffect.init();
            DismountingEffect.init();
            DragonMistEffect.init();
            DisorientingEffect.init();
            VengeanceEffect.init();
            ResolveEffect.init();
            DevouringEffect.init();
            InfernalRebukeEffect.init();
            CarnageEffect.init();
            SlaughteringEffect.init();
            HubrisEffect.init();
            JudgementEffect.init();
            RetributionEffect.init();
            EsotericEdgeEffect.init();
            FeastingEffect.init();
            NanoFusedEffect.init();
            BeheadingEffect.init();
            SoulChargedEffect.init();
            SonicShockEffect.init();
            ConqueringEffect.init();
            SubjugationEffect.init();
            GoliathSlayerEffect.init();
            // Curio
            CurioFireResistanceEffect.init();
            CurioMagicResistanceEffect.init();
            CurioStrengthEffect.init();
            CurioRegenerationEffect.init();
            CurioKarmaEffect.init();
            CurioHasteEffect.init();
            CurioGlowingEffect.init();
        }
    }
}
