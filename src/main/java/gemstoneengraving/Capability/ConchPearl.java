package gemstoneengraving.Capability;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Config;
import gemstoneengraving.Count;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.common.NeoForgeMod;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class ConchPearl extends Item implements ICurioItem {
    public ConchPearl(Properties properties) {
        super(properties);
    }

    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "swim_speed");
        AttributeMap attributes = entity.getAttributes();

        int getCount = Count.getCurioCount(entity, ItemRegistery.CONCH_PEARL.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                Config.Conch_Pearl.get()*getCount,
                AttributeModifier.Operation.ADD_VALUE
        );
        return modifier;

    }


    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier=attributeModifier(slotContext);
            //Remove First
            attributes.getInstance(NeoForgeMod.SWIM_SPEED).removeModifier(modifier);
            attributes.getInstance(NeoForgeMod.SWIM_SPEED).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=attributeModifier(slotContext);
            attributes.getInstance(NeoForgeMod.SWIM_SPEED).removeModifier(modifier);
            attributes.getInstance(NeoForgeMod.SWIM_SPEED).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.swim_speed",Config.Conch_Pearl.get()).withColor(0xdfbc12));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.waterbreathing").withColor(0x7494fb));
        list.add(Component.translatable("tooltip.gemstoneengraving.immune").withColor(0xfd4d96));



    }


}
