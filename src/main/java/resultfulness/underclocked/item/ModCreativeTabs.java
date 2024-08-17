package resultfulness.underclocked.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import resultfulness.underclocked.UnderclockedMod;

public class ModCreativeTabs {
    public static void register(IEventBus eventBus) {
        UnderclockedMod.LOGGER.info("Registering {} creative tab info", UnderclockedMod.MODID);
        eventBus.addListener(ModCreativeTabs::addCreative);
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
            event.accept(ModItems.UNDERCLOCK_DEVICE_ITEM);
    }
}
