package resultfulness.underclocked.helper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class TagHelper {
    public static final String ENABLED_TAG = "enabled";

    public static boolean getBool(String key, ItemStack stack) {
        CompoundTag t = stack.getTag();
        if (t == null) {
            t = new CompoundTag();
        }
        return t.getBoolean(key);
    }

    public static void setBool(String key, boolean val, ItemStack stack) {
        CompoundTag t = stack.getTag();
        if (t == null) {
            t = new CompoundTag();
        }
        t.putBoolean(key, val);
        stack.setTag(t);
    }
}
