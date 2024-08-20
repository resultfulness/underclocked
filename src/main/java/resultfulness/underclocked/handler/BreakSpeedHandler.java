package resultfulness.underclocked.handler;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import resultfulness.underclocked.helper.TagHelper;
import resultfulness.underclocked.item.ModItems;

public class BreakSpeedHandler {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player p = event.getEntity();
        Inventory i = p.getInventory();
        ItemStack enabledUnderclockDeviceStack = new ItemStack(ModItems.UNDERCLOCK_DEVICE_ITEM.get());
        TagHelper.setBool(TagHelper.ENABLED_TAG, true, enabledUnderclockDeviceStack);
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
