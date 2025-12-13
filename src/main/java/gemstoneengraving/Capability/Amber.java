package gemstoneengraving.Capability;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Count;
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

public class Amber extends Item implements ICurioItem {
    public Amber(Properties properties) {
        super(properties);
    }

    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "burning_time");
        AttributeMap attributes = entity.getAttributes();

        int getCount = Count.getCurioCount(entity, ItemRegistery.AMBER.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                -0.2*getCount,
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
            attributes.getInstance(Attributes.BURNING_TIME).removeModifier(modifier);
            attributes.getInstance(Attributes.BURNING_TIME).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=attributeModifier(slotContext);
            attributes.getInstance(Attributes.BURNING_TIME).removeModifier(modifier);
            attributes.getInstance(Attributes.BURNING_TIME).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.burning_time",0.2).withColor(0xfd832c));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.absorb").withColor(0xb2fb82));
        list.add(Component.translatable("tooltip.gemstoneengraving.abhor").withColor(0x8f8f8f));



    }

}

