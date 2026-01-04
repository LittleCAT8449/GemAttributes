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

public class Aquamarine extends Item implements ICurioItem {
    public Aquamarine(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.AQUAMARINE.toStack(), Config.Aquamarine_Value.get(),"ADD_VALUE","swim_speed");
            //Remove First
            attributes.getInstance(Attributes.WATER_MOVEMENT_EFFICIENCY).removeModifier(modifier);
            attributes.getInstance(Attributes.WATER_MOVEMENT_EFFICIENCY).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.AQUAMARINE.toStack(), Config.Aquamarine_Value.get(),"ADD_VALUE","swim_speed");
            attributes.getInstance(Attributes.WATER_MOVEMENT_EFFICIENCY).removeModifier(modifier);
            attributes.getInstance(Attributes.WATER_MOVEMENT_EFFICIENCY).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.water_movement_efficiency",Config.Aquamarine_Value.get()).withColor(0x0060ff));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.waterbreathing").withColor(0x7494fb));
        list.add(Component.translatable("tooltip.gemstoneengraving.invisible").withColor(0xca8cfa));



    }


}
