package resultfulness.underclocked.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
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
