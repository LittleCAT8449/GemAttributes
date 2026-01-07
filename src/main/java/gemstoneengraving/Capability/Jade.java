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

public class Jade extends Item implements ICurioItem , ToolTip {


    public Jade(Properties properties) {
        super(properties);
    }

    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "safe_fall_distance");
        AttributeMap attributes = entity.getAttributes();

        int getCount = CurioUtils.getCurioCount(entity, ItemRegistery.JADE.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                Config.Jade.get()*getCount,
                AttributeModifier.Operation.ADD_VALUE
        );
        return modifier;

    }


    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.JADE.toStack(), Config.Jade.get(),"ADD_VALUE","safe_fall_distance");
            //Remove First
            attributes.getInstance(Attributes.SAFE_FALL_DISTANCE).removeModifier(modifier);
            attributes.getInstance(Attributes.SAFE_FALL_DISTANCE).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=CuriosMath.setAttributes(slotContext,ItemRegistery.JADE.toStack(), Config.Jade.get(),"ADD_VALUE","safe_fall_distance");
            attributes.getInstance(Attributes.SAFE_FALL_DISTANCE).removeModifier(modifier);
            attributes.getInstance(Attributes.SAFE_FALL_DISTANCE).addTransientModifier(modifier);
        }
    }

    @Override
    public void addToolTip(ItemStack itemStack, List<Component> tooltip) {
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.safe_fall_distance",Config.Jade.get()).withColor(0xe8281d));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.jumpresistance").withColor(0x69fbdd));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.immune").withColor(0xfd4d96));
    }
}
