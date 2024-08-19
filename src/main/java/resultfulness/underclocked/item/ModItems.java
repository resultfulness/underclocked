package resultfulness.underclocked.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import resultfulness.underclocked.UnderclockedMod;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "underclocked" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UnderclockedMod.MODID);

    public static final RegistryObject<Item> UNDERCLOCK_DEVICE_ITEM =
        ITEMS.register("underclock_device", UnderclockDeviceItem::new);

    public static void register (IEventBus eventBus) {
        UnderclockedMod.LOGGER.info("Registering {} items", UnderclockedMod.MODID);
        ITEMS.register(eventBus);
    }
}
