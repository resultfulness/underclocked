package resultfulness.underclocked.component;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import resultfulness.underclocked.UnderclockedMod;

public class ModComponents {
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(
        UnderclockedMod.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> ENABLED_COMPONENT = REGISTRAR
        .registerComponentType(
            "device_enabled",
            builder -> builder
                // The codec to read/write the data to disk
                .persistent(Codec.BOOL)
    );

    public static void register(IEventBus eventBus) {
        UnderclockedMod.LOGGER.info("Registering {} components", UnderclockedMod.MODID);

        REGISTRAR.register(eventBus);
    }
}
