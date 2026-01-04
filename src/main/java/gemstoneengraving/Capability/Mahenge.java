package gemstoneengraving.Capability;


import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Config;
import gemstoneengraving.CuriosMath;
import gemstoneengraving.Item.ItemRegistery;
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

public class Mahenge extends Item implements ICurioItem {
    public Mahenge(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.MAHENGE.toStack(), Config.Mahenge.get(),"ADD_MULTIPLIED_BASE","entity_interaction_range");
            //Remove First
            attributes.getInstance(Attributes.ENTITY_INTERACTION_RANGE).removeModifier(modifier);
            attributes.getInstance(Attributes.ENTITY_INTERACTION_RANGE).addTransientModifier(modifier);



        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=CuriosMath.setAttributes(slotContext,ItemRegistery.MAHENGE.toStack(), Config.Mahenge.get(),"ADD_MULTIPLIED_BASE","entity_interaction_range");
            attributes.getInstance(Attributes.ENTITY_INTERACTION_RANGE).removeModifier(modifier);
            attributes.getInstance(Attributes.ENTITY_INTERACTION_RANGE).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.entity_interaction_range",Config.Mahenge.get()*100).withColor(0xfd64a4));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.heal").withColor(0x81db47));
        list.add(Component.translatable("tooltip.gemstoneengraving.immune").withColor(0xfd4d96));




    }

}
