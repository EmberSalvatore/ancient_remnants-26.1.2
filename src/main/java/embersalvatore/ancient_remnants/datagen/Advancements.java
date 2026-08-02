package embersalvatore.ancient_remnants.datagen;

import embersalvatore.ancient_remnants.AncientRemnants;
import embersalvatore.ancient_remnants.AncientRemnantsStructures;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.LocationPredicate;
import net.minecraft.advancements.criterion.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class Advancements extends AdvancementProvider {
    public Advancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new AncientRemnantsAdvancements()));
    }

    public static class AncientRemnantsAdvancements implements AdvancementSubProvider {

        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
            var item = provider.lookup(Registries.ITEM);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            Items.MOSSY_STONE_BRICKS,
                            Component.literal("Ancient Remnants"),
                            Component.literal("You have entered a world once shaped by a powerful civilization. Now, it is all gone - except for a few ruins."),
                            Identifier.withDefaultNamespace("block/mossy_stone_bricks"),
                            AdvancementType.TASK,
                            true, false, false)
                    .addCriterion("joined_world", PlayerTrigger.TriggerInstance.tick())
                    .save(consumer, Identifier.fromNamespaceAndPath(AncientRemnants.MODID, "ancient_remnants/root_advancement"));

            /*AdvancementHolder foundBridge = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            Items.MOSSY_STONE_BRICKS,
                            Component.literal("The Bridge"),
                            Component.literal("Two ends, two goals, wherever it may lead."),
                            (Identifier) null,
                            AdvancementType.TASK,
                            true, false, false)
                    .addCriterion("found_large_bridge", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inStructure(provider.lookupOrThrow(Registries.STRUCTURE).getOrThrow(AncientRemnantsStructures.LARGE_BRIDGE))))
                    .save(consumer, Identifier.fromNamespaceAndPath(AncientRemnants.MODID, "ancient_remnants/found_large_bridge"));*/
        }
    }
}
