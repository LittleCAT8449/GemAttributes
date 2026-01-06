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

public class Helvite extends Item implements ICurioItem {
    public Helvite(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.HELVITE.toStack(), Config.Helvite.get(),"ADD_MULTIPLIED_BASE","move_speed");
            //Remove First
            attributes.getInstance(Attributes.MOVEMENT_SPEED).removeModifier(modifier);
            attributes.getInstance(Attributes.MOVEMENT_SPEED).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.HELVITE.toStack(), Config.Helvite.get(),"ADD_MULTIPLIED_BASE","move_speed");
            attributes.getInstance(Attributes.MOVEMENT_SPEED).removeModifier(modifier);
            attributes.getInstance(Attributes.MOVEMENT_SPEED).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.movement_speed",Config.Helvite.get()*100).withColor(0x0097a7));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.jumpresistance").withColor(0x69fbdd));
        list.add(Component.translatable("tooltip.gemstoneengraving.invisible").withColor(0xca8cfa));



    }

}
