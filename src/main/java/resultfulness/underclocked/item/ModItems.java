package resultfulness.underclocked.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import resultfulness.underclocked.UnderclockedMod;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "underclocked" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnderclockedMod.MODID);

    public static final DeferredItem<Item> UNDERCLOCK_DEVICE_ITEM =
            ITEMS.register("underclock_device", UnderclockDeviceItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
