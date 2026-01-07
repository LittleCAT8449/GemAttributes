package gemstoneengraving.api;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface ToolTip {

    void addToolTip(ItemStack itemStack, List<Component> tooltip);

}
