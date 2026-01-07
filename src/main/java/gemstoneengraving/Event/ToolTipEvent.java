package gemstoneengraving.Event;

import com.mojang.blaze3d.platform.InputConstants;
import gemstoneengraving.api.ToolTip;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.ArrayList;
import java.util.List;

public class ToolTipEvent {

    public static  void onToolTip(ItemTooltipEvent event) {

        ItemStack itemStack = event.getItemStack();
        List<Component> toolTip = event.getToolTip();

        if (!(itemStack.getItem() instanceof ToolTip detailsTip)) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        boolean isAltPressed = InputConstants.isKeyDown(
                minecraft.getWindow().getWindow(),
                InputConstants.KEY_LALT
        );

        toolTip.removeIf(comp -> comp.getString().contains(
                Component.translatable("tooltip.gemstoneengraving.tip.press_alt").getString()
        ));

        if(isAltPressed){

            toolTip.add(Component.literal("§8---------------------"));
            List<Component> details = new ArrayList<>();
            detailsTip.addToolTip(itemStack, details);
            toolTip.addAll(details);

        }
        else {
            toolTip.add(Component.translatable("tooltip.gemstoneengraving.tip.press_alt"));
        }

    }
}
