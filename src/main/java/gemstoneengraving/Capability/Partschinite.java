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

public class Partschinite extends Item implements ICurioItem, ToolTip {


    public Partschinite(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.PARTSCHINITE.toStack(), Config.Partschinite.get(),"ADD_VALUE","armor");
            //Remove First
            attributes.getInstance(Attributes.ARMOR).removeModifier(modifier);
            attributes.getInstance(Attributes.ARMOR).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=CuriosMath.setAttributes(slotContext,ItemRegistery.PARTSCHINITE.toStack(), Config.Partschinite.get(),"ADD_VALUE","armor");
            attributes.getInstance(Attributes.ARMOR).removeModifier(modifier);
            attributes.getInstance(Attributes.ARMOR).addTransientModifier(modifier);
        }
    }

    @Override
    public void addToolTip(ItemStack itemStack, List<Component> tooltip) {
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.armor",Config.Partschinite.get()).withColor(0xea0c0c));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.abhor").withColor(0x8f8f8f));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.perseverance").withColor(0xb7bc00));



    }
}
