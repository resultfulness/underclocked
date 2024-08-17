package resultfulness.underclocked.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import resultfulness.underclocked.helper.KeyboardHelper;

import java.util.List;

public class UnderclockDeviceItem extends Item {
    private boolean isEnabled = false;

    public UnderclockDeviceItem() {
        super(new Item.Properties().stacksTo(1));
    }

    private void toggleEnabled(ItemStack stack) {
        this.isEnabled = !this.isEnabled;
    }

    private boolean isEnabled(ItemStack stack) {
        return this.isEnabled;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        if (KeyboardHelper.isHoldingShift()) {
            tooltipComponents.add(Component.translatable("item.underclocked.underclock_device.info_tooltip").withStyle(ChatFormatting.GRAY));
            if (this.isEnabled(stack)) {
                tooltipComponents.add(Component.translatable("tooltip.status")
                    .withStyle(ChatFormatting.GRAY)
                    .append(": ").withStyle(ChatFormatting.GRAY)
                    .append(Component.translatable("tooltip.enabled")
                        .withStyle(ChatFormatting.DARK_GREEN)));
            } else {
                tooltipComponents.add(Component.translatable("tooltip.status")
                    .withStyle(ChatFormatting.GRAY)
                    .append(": ").withStyle(ChatFormatting.GRAY)
                    .append(Component.translatable("tooltip.disabled")
                        .withStyle(ChatFormatting.DARK_RED)));
            }
        } else {
            tooltipComponents.add(Component.translatable("tooltip.holdForMoreInfo").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {
            level.playSound(null, player.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 0.1F, 2F);
            this.toggleEnabled(stack);
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS_NO_ITEM_USED, stack);
    }
}
