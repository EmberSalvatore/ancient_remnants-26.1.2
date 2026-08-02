package embersalvatore.ancient_remnants;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = AncientRemnants.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = AncientRemnants.MODID, value = Dist.CLIENT)
public class AncientRemnantsClient {
    public AncientRemnantsClient(ModContainer container) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }
}
