package gemstoneengraving.Capability;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Config;
import gemstoneengraving.CuriosMath;
import gemstoneengraving.Item.ItemRegistery;
import gemstoneengraving.api.ToolTip;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class Topaz extends Item implements ICurioItem, ToolTip {


    public Topaz(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.TOPAZ.toStack(), Config.Topaz.get(),"ADD_MULTIPLIED_BASE","oxygen_bonus");
            //Remove First
            attributes.getInstance(Attributes.OXYGEN_BONUS).removeModifier(modifier);
            attributes.getInstance(Attributes.OXYGEN_BONUS).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.TOPAZ.toStack(), Config.Topaz.get(),"ADD_MULTIPLIED_BASE","oxygen_bonus");
            attributes.getInstance(Attributes.OXYGEN_BONUS).removeModifier(modifier);
            attributes.getInstance(Attributes.OXYGEN_BONUS).removeModifier(modifier);
        }
    }

    @Override
    public void addToolTip(ItemStack itemStack, List<Component> tooltip) {
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.oxygen_bonus",Config.Topaz.get()*100).withColor(0x0097a7));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.absorb").withColor(0xb2fb82));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.waterbreathing").withColor(0x7494fb));
    }
}
