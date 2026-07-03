package net.acetheeldritchking.art_of_forging.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import se.mickelus.tetra.blocks.scroll.ScrollData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AoFScrollCreativeItems {
    private static final ResourceKey<CreativeModeTab> TETRA_TAB = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath("tetra", "default"));

    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (TETRA_TAB.equals(event.getTabKey())) {
            event.acceptAll(getScrolls());
        }
    }

    private static List<ItemStack> getScrolls() {
        return List.of(
                setupSchematic("tetra/flamberge_blade", "art_of_forging",
                        new String[]{"sword/flamberge_blade"}, false, 2, 0xff9612, 6, 15, 4, 7),
                setupSchematic("single/head/halberd_head/halberd_head", "art_of_forging",
                        new String[]{"single/head/halberd_head/halberd_head"}, false, 1, 0x444bbf, 8, 1, 4, 5),
                setupSchematic("sword/key_guard", "art_of_forging",
                        new String[]{"sword/key_guard"}, false, 1, 0xfadec9, 0, 1, 9, 4),
                setupSchematic("single/head/mace_head/mace_head", "art_of_forging",
                        new String[]{"single/head/mace_head/mace_head"}, false, 1, 0x5603e0, 9, 3, 6, 2),
                setupSchematic("tetra/crucible_blade", "art_of_forging",
                        new String[]{"sword/crucible_blade"}, false, 2, 0xff1e00, 8, 7, 9, 2),
                setupSchematic("bow/stave/dreadnought_stave", "art_of_forging",
                        new String[]{"bow/stave/dreadnought_stave", "bow/stave/dreadnought_cross_stave"}, false, 1, 0xf3a99f, 8, 1, 9, 5),
                setupSchematic("sword/katana/katana_blade", "art_of_forging",
                        new String[]{"sword/katana/katana_blade", "sword/tsuba_guard"}, false, 2, 0xdbff10, 5, 10, 13, 2),
                setupSchematic("bow/string/compound_string", "art_of_forging",
                        new String[]{"bow/string/compound_string", "crossbow/string/compound_cross_string"}, false, 1, 0x19e448, 15, 13, 12, 14),
                setupSchematic("utilize/hammer", "art_of_forging",
                        new String[]{"utilize/hammer"}, false, 2, 0xfa4ae9, 1, 15, 12, 8),
                setupSchematic("sword/katana/murasama_blade", "otherworldly",
                        new String[]{"sword/katana/murasama_blade"}, false, 2, 0xc52323, 6, 7, 13, 15),
                setupSchematic("tetra/rending_scissor_complete", "otherworldly",
                        new String[]{"sword/scissor_blade_left", "sword/scissor_blade_right", "sword/rending_scissor_complete"}, false, 2, 0xe32182, 1, 15, 2, 13),
                setupSchematic("sword/crucible/architects_crucible_blade", "true_crucible",
                        new String[]{"sword/crucible_blade", "sword/crucible/architects_crucible_blade"}, true, 2, 0xff0042, 8, 7, 9, 2),
                setupSchematic("sword/tonal_blade", "art_of_forging",
                        new String[]{"sword/tonal_blade"}, false, 1, 0xdaef26, 3, 5, 6, 9),
                setupSchematic("sword/thousand_cold_nights", "otherworldly",
                        new String[]{"sword/katana/murasama_blade", "sword/thousand_cold_nights"}, true, 2, 0x5c7c80, 7, 8, 14, 13)
        );
    }

    private static ItemStack setupSchematic(String key, String details, String[] schematics, boolean isIntricate,
                                            int material, int tint, Integer... glyphs) {
        ScrollData data = new ScrollData(key, Optional.ofNullable(details), isIntricate, material, tint,
                Arrays.asList(glyphs),
                Arrays.stream(schematics)
                        .map(s -> ResourceLocation.fromNamespaceAndPath("tetra", s))
                        .toList(),
                Collections.emptyList());
        return data.createItemStack();
    }
}
