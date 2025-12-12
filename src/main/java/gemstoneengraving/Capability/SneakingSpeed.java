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

public class SneakingSpeed extends Item implements ICurioItem {
    public SneakingSpeed(Properties properties) {
        super(properties);
    }

    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "phantom_crystal");
        AttributeMap attributes = entity.getAttributes();

        int getCount = Count.getCurioCount(entity, ItemRegistery.CATSEYE.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                1+(0.2*getCount),
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
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
            attributes.getInstance(Attributes.SNEAKING_SPEED).removeModifier(modifier);
            attributes.getInstance(Attributes.SNEAKING_SPEED).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=attributeModifier(slotContext);
            attributes.getInstance(Attributes.SNEAKING_SPEED).removeModifier(modifier);
            attributes.getInstance(Attributes.SNEAKING_SPEED).addTransientModifier(modifier);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.sneaking_speed",20).withColor(0x0097a7));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        list.add(Component.translatable("tooltip.gemstoneengraving.nightvision").withColor(0x6fdb16));



    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {

        LivingEntity wearer = slotContext.entity();
        if (wearer == null || wearer.level().isClientSide()) {
            return;
        }




        boolean catseye = CurioUtils.isCurio(wearer,ItemRegistery.CATSEYE.toStack(1).getItem());


        isBondActive = catseye;


    }

    public static boolean isBondActive = false;

    public static boolean getBoolean(){
        return isBondActive;
    }

}
