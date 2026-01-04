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

public class Mica extends Item implements ICurioItem {


    public Mica(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.MICA.toStack(), Config.Mica.get(),"ADD_VALUE","knockback_resistance");
            //Remove First
            attributes.getInstance(Attributes.KNOCKBACK_RESISTANCE).removeModifier(modifier);
            attributes.getInstance(Attributes.KNOCKBACK_RESISTANCE).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.MICA.toStack(), Config.Mica.get(),"ADD_VALUE","knockback_resistance");
            attributes.getInstance(Attributes.KNOCKBACK_RESISTANCE).removeModifier(modifier);
            attributes.getInstance(Attributes.KNOCKBACK_RESISTANCE).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.knockback_resistance",Config.Mica.get()).withColor(0xc3a591));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.Fixed").withColor(0x204300));
        list.add(Component.translatable("tooltip.gemstoneengraving.thelastgasp").withColor(0xffe567));



    }

}
