//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package embersalvatore.ancient_remnants;

import embersalvatore.ancient_remnants.AncientRemnants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface AncientRemnantsStructures {
    ResourceKey<Structure> LARGE_BRIDGE = createKey("large_bridge");


    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(AncientRemnants.MODID, name));
    }
}
