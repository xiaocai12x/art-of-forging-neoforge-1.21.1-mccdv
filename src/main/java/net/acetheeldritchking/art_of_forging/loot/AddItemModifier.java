package net.acetheeldritchking.art_of_forging.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<MapCodec<AddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst).and(ItemStack.CODEC.listOf()
            .fieldOf("items").forGetter(m -> m.items)).apply(inst, AddItemModifier::new)));
    private final List<ItemStack> items;

    public AddItemModifier(LootItemCondition[] conditionsIn, List<ItemStack> items) {
        super(conditionsIn);
        this.items = List.copyOf(items);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for (ItemStack item : this.items) {
            generatedLoot.add(item.copy());
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
