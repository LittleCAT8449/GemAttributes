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

public class SlimeCore extends Item implements ICurioItem, ToolTip {
    public SlimeCore(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.SLIME_CORE.toStack(), Config.Slime_Core.get(),"ADD_MULTIPLIED_BASE","attack_knockback");
            //Remove First
            attributes.getInstance(Attributes.ATTACK_KNOCKBACK).removeModifier(modifier);
            attributes.getInstance(Attributes.ATTACK_KNOCKBACK).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=CuriosMath.setAttributes(slotContext,ItemRegistery.SLIME_CORE.toStack(), Config.Slime_Core.get(),"ADD_MULTIPLIED_BASE","attack_knockback");
            attributes.getInstance(Attributes.ATTACK_KNOCKBACK).removeModifier(modifier);
            attributes.getInstance(Attributes.ATTACK_KNOCKBACK).addTransientModifier(modifier);
        }
    }

    @Override
    public void addToolTip(ItemStack itemStack, List<Component> tooltip) {
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.attack_knockback",Config.Slime_Core.get()*100).withColor(0x78e81d));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.slash").withColor(0xf33ab0));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.resistance").withColor(0x8cf6fa));
    }
}
