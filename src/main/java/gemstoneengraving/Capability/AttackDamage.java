package gemstoneengraving.Capability;


import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;



public class AttackDamage extends Item implements ICurioItem {
    public AttackDamage(Properties properties) {
        super(properties);
    }
//Define Final Damage
    public static AttributeModifier attributeModifier(SlotContext slotContext) {

        LivingEntity entity = slotContext.entity();
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("gemstoneengraving", "attack_damage");
        AttributeMap attributes = entity.getAttributes();

        int getCount = Count.getCurioCount(entity, ItemRegistery.RUBY.toStack());


        AttributeModifier modifier = new AttributeModifier(
                id,
                4*getCount,
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
            attributes.getInstance(Attributes.ATTACK_DAMAGE).removeModifier(modifier);
            attributes.getInstance(Attributes.ATTACK_DAMAGE).addTransientModifier(modifier);


        }

    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        LivingEntity entity = slotContext.entity();
        AttributeMap attributes = entity.getAttributes();

        if(entity!=null){
           AttributeModifier modifier=attributeModifier(slotContext);
           attributes.getInstance(Attributes.ATTACK_DAMAGE).removeModifier(modifier);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context,List<Component> list,TooltipFlag tip ) {

        list.add(Component.literal("Attack Damage "+4).withColor(0xdfbc12));



    }





}
