package resultfulness.underclocked.handler;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import resultfulness.underclocked.UnderclockedMod;
import resultfulness.underclocked.component.ModComponents;
import resultfulness.underclocked.item.ModItems;

@EventBusSubscriber(modid = UnderclockedMod.MODID)
public class BreakSpeedHandler {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player p = event.getEntity();
        Inventory i = p.getInventory();
        ItemStack enabledUnderclockDeviceStack = new ItemStack(ModItems.UNDERCLOCK_DEVICE_ITEM.get());
        enabledUnderclockDeviceStack.set(ModComponents.ENABLED_COMPONENT, true);
        if (!i.contains(enabledUnderclockDeviceStack)) {
            return;
        }
        ItemStack heldItem = p.getMainHandItem();
        if (heldItem.isEmpty()) {
            return;
        }
        if (heldItem.getDestroySpeed(event.getState()) > 1F) {
            float hardness = event.getState().getDestroySpeed(p.level(), event.getPosition().orElse(BlockPos.ZERO));
            event.setNewSpeed(29.9999F * hardness);
        }
    }
}
