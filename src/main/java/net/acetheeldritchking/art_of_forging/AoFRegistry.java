package net.acetheeldritchking.art_of_forging;

///import net.acetheeldritchking.art_of_forging.item.DummyItem;
import net.acetheeldritchking.art_of_forging.item.custom.AncientItem;
import net.acetheeldritchking.art_of_forging.item.custom.EnigmaticConstructItem;
import net.acetheeldritchking.art_of_forging.item.custom.LifeFiberItem;
import net.acetheeldritchking.art_of_forging.item.custom.SigilOfEdenItem;
import net.acetheeldritchking.art_of_forging.item.modular.ModularArtifact;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class AoFRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ArtOfForging.MOD_ID);

  ///  public static final DeferredHolder<Item, Item> DUMMY_ITEM = ITEMS.register("dummyitem", DummyItem::new);
    //               //
    // Modular Items //
    //               //
    // Modular Artifact
    public static final DeferredHolder<Item, Item> MODULAR_ARTIFACT = ITEMS.register(ModularArtifact.identifier, ModularArtifact::new);

    public static final DeferredHolder<Item, Item> CURIOUS_ARTIFACT = ITEMS.register("curious_artifact",
            () -> new Item(new Item.Properties()));


    //        //
    // INGOTS //
    //        //
    // Resonant Alloy
    public static final DeferredHolder<Item, Item> RESONANT_ALLOY = ITEMS.register("resonant_alloy",
            () -> new Item(new Item.Properties().fireResistant()));

    // Forged Steel
    public static final DeferredHolder<Item, Item> FORGED_STEEL_INGOT = ITEMS.register("forged_steel_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    // Vobrite Crystal
    public static DeferredHolder<Item, Item> VOBRITE_CRYSTAL = ITEMS.register("vobrite_crystal",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).
                    fireResistant()));

    // Vobrivium Ingot
    public static DeferredHolder<Item, Item> VOBRIVIUM_INGOT = ITEMS.register("vobrivium_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).
                    fireResistant()));

    // Endsteel
    public static DeferredHolder<Item, Item> ENDSTEEL_INGOT = ITEMS.register("endsteel_ingot",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.UNCOMMON).fireResistant()));


    //          //
    // TREASURE //
    //          //
    // Life Fiber
    public static DeferredHolder<Item, Item> LIFE_FIBER = ITEMS.register("life_fiber",
            () -> new LifeFiberItem(new Item.Properties().rarity(Rarity.RARE)));

    // Fang Charm
    public static final DeferredHolder<Item, Item> FANG_CHARM = ITEMS.register("fang_charm",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

    // Sigil of Eden
    public static DeferredHolder<Item, Item> SIGIL_OF_EDEN = ITEMS.register("sigil_of_eden",
            () -> new SigilOfEdenItem(new Item.Properties().
                    rarity(Rarity.EPIC).stacksTo(1).fireResistant()));

    // Enigmatic Construct
    public static DeferredHolder<Item, Item> ENIGMATIC_CONSTRUCT = ITEMS.register("enigmatic_construct",
            () -> new EnigmaticConstructItem(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Ancient Axe head
    public static DeferredHolder<Item, Item> ANCIENT_AXE = ITEMS.register("ancient_axe",
            () -> new AncientItem(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Ancient Blade
    public static DeferredHolder<Item, Item> ANCIENT_BLADE = ITEMS.register("ancient_blade",
            () -> new AncientItem(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Ancient Flail
    public static DeferredHolder<Item, Item> ANCIENT_FLAIL = ITEMS.register("ancient_flail",
            () -> new AncientItem(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Demonic Axe Head
    public static DeferredHolder<Item, Item> DEMONIC_AXE = ITEMS.register("demonic_axe",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Demonic Blade
    public static DeferredHolder<Item, Item> DEMONIC_BLADE = ITEMS.register("demonic_blade",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Demonic Flail
    public static DeferredHolder<Item, Item> DEMONIC_FLAIL = ITEMS.register("demonic_flail",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).fireResistant().stacksTo(1)));

    // Devil's Soul Gem
    public static DeferredHolder<Item, Item> DEVILS_SOUL_GEM = ITEMS.register("devils_soul_gem",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).stacksTo(1).fireResistant()));

    // Rending Scissor Red
    public static DeferredHolder<Item, Item> RENDING_SCISSOR_RED = ITEMS.register("rending_scissor_red",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).stacksTo(1).fireResistant()));

    // Rending Scissor Purple
    public static DeferredHolder<Item, Item> RENDING_SCISSOR_PURPLE = ITEMS.register("rending_scissor_purple",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).stacksTo(1).fireResistant()));

    // Rending Scissor Complete
    public static DeferredHolder<Item, Item> RENDING_SCISSOR_COMPLETE = ITEMS.register("rending_scissor_complete",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).stacksTo(1).fireResistant()));


    //      //
    // MISC //
    //      //
    // Nano-Insectoid
    public static DeferredHolder<Item, Item> NANO_INSECTOID = ITEMS.register("nano_insectoid",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.UNCOMMON).stacksTo(16)));

    // Encoded Canister
    public static DeferredHolder<Item, Item> ENCODED_CANISTER = ITEMS.register("encoded_canister",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.UNCOMMON).stacksTo(16)));

    // Esoteric Codex
    public static DeferredHolder<Item, Item> ESOTERIC_CODEX = ITEMS.register("esoteric_codex",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE).stacksTo(1)));

    // Mark of The Architect
    public static DeferredHolder<Item, Item> MARK_OF_THE_ARCHITECT = ITEMS.register("mark_of_the_architect",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.EPIC).stacksTo(1)));

    // Shockwave Chamber
    public static DeferredHolder<Item, Item> SHOCKWAVE_CHAMBER = ITEMS.register("shockwave_chamber",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE).stacksTo(16)));


    //           //
    // MOB DROPS //
    //           //
    // Dragon Soul
    public static DeferredHolder<Item, Item> DRAGON_SOUL = ITEMS.register("dragon_soul",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE).fireResistant()));

    // Shards of Malice
    public static DeferredHolder<Item, Item> SHARDS_OF_MALICE = ITEMS.register("shards_of_malice",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.UNCOMMON).fireResistant()));

    // Potent Mixture
    public static DeferredHolder<Item, Item> POTENT_MIXTURE = ITEMS.register("potent_mixture",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE)));

    // Heart of Ender
    public static DeferredHolder<Item, Item> HEART_OF_ENDER = ITEMS.register("heart_of_ender",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE)));

    // Eerie Shard
    public static DeferredHolder<Item, Item> EERIE_SHARD = ITEMS.register("eerie_shard",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE).stacksTo(16)));

    // Soul Ember
    public static DeferredHolder<Item, Item> SOUL_EMBER = ITEMS.register("soul_ember",
            () -> new Item(new Item.Properties()));

    // Fragment of Eden
    public static DeferredHolder<Item, Item> FRAGMENT_OF_EDEN = ITEMS.register("fragment_of_eden",
            () -> new Item(new Item.Properties().
                    rarity(Rarity.RARE).stacksTo(16)));


}
