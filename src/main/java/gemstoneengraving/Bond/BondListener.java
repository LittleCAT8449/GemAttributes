package gemstoneengraving.Bond;

import com.mojang.logging.LogUtils;
import gemstoneengraving.Gemstoneengraving;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioCanEquipEvent;


public class BondListener {

    @SubscribeEvent

    public void onCuriosEquip(CurioCanEquipEvent event){
        ItemStack stack=event.getStack();
        SlotContext context =event.getSlotContext();
        if(!(context.entity() instanceof Player player)){
            return;
        }

        if(BondCapability.effectCapability(player)){
            player.sendSystemMessage(Component.literal("success"));
        }

    }


}
