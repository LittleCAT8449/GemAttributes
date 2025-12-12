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

public class Luck extends Item implements ICurioItem {
    public Luck(Properties properties) {
        super(properties);
    }

    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "move_speed");
        AttributeMap attributes = entity.getAttributes();

        int getCount = Count.getCurioCount(entity, ItemRegistery.TSAVORITE.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                0.5*getCount,
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
            attributes.getInstance(Attributes.LUCK).removeModifier(modifier);
            attributes.getInstance(Attributes.LUCK).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=attributeModifier(slotContext);
            attributes.getInstance(Attributes.LUCK).removeModifier(modifier);
            attributes.getInstance(Attributes.LUCK).addTransientModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> list, TooltipFlag tip ) {

        list.add(Component.translatable("tooltip.gemstoneengraving.luck",0.5).withColor(0x6bff65));
        list.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));



    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {

        LivingEntity wearer = slotContext.entity();
        if (wearer == null || wearer.level().isClientSide()) {
            return;
        }




        boolean tsavorite = CurioUtils.isCurio(wearer,ItemRegistery.TSAVORITE.toStack(1).getItem());
        boolean amber =CurioUtils.isCurio(wearer,ItemRegistery.AMBER.toStack(1).getItem());
        boolean topaz =CurioUtils.isCurio(wearer,ItemRegistery.TOPAZ.toStack(1).getItem());

        isBondActive = tsavorite && amber&& topaz;


    }

    public static boolean isBondActive = false;

    public static boolean getBoolean(){
        return isBondActive;
    }

}
