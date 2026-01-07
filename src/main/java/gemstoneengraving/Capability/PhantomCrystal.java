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

public class PhantomCrystal extends Item implements ICurioItem, ToolTip {
    public PhantomCrystal(Properties properties) {
        super(properties);
    }
    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

        LivingEntity entity= slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){

            AttributeModifier modifier= CuriosMath.setAttributes(slotContext,ItemRegistery.PHANTOM_CRYSTAL.toStack(), Config.PhantomCrystal.get(),"ADD_MULTIPLIED_BASE","explosion_knockback_resistance");
            //Remove First
            attributes.getInstance(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).removeModifier(modifier);
            attributes.getInstance(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
            AttributeModifier modifier=CuriosMath.setAttributes(slotContext,ItemRegistery.PHANTOM_CRYSTAL.toStack(), Config.PhantomCrystal.get(),"ADD_MULTIPLIED_BASE","explosion_knockback_resistance");
            attributes.getInstance(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).removeModifier(modifier);
            attributes.getInstance(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).addTransientModifier(modifier);
        }
    }

    @Override
    public void addToolTip(ItemStack itemStack, List<Component> tooltip) {
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.explosion_resistance",Config.PhantomCrystal.get()*100).withColor(0x5530a5));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.bond").withColor(0xffffff));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.bloodthirst").withColor(0xff5c00));
        tooltip.add(Component.translatable("tooltip.gemstoneengraving.perseverance").withColor(0xb7bc00));
    }
}
