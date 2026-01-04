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

public class Catseye extends Item implements ICurioItem {
    public Catseye(Properties properties) {
        super(properties);
    }

    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "phantom_crystal");
        AttributeMap attributes = entity.getAttributes();

        int getCount =CurioUtils.getCurioCount(entity, ItemRegistery.CATSEYE.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                1+(Config.Cats_Eye.get() *getCount),
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
        return modifier;

    }


    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.CATSEYE.toStack(), Config.Cats_Eye.get(),"ADD_MULTIPLIED_BASE","sneaking_speed");
            //Remove First
            attributes.getInstance(Attributes.SNEAKING_SPEED).removeModifier(modifier);
            attributes.getInstance(Attributes.SNEAKING_SPEED).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=CuriosMath.setAttributes(slotContext,ItemRegistery.CATSEYE.toStack(), Config.Cats_Eye.get(),"ADD_MULTIPLIED_BASE","sneaking_speed");
            attributes.getInstance(Attributes.SNEAKING_SPEED).removeModifier(modifier);
            attributes.getInstance(Attributes.SNEAKING_SPEED).addTransientModifier(modifier);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.sneaking_speed",Config.Cats_Eye.get()*100).withColor(0x0097a7));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.nightvision").withColor(0x6fdb16));
        list.add(Component.translatable("tooltip.gemstoneengraving.Fixed").withColor(0x204300));



    }

}
