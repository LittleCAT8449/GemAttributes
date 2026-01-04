package gemstoneengraving;

import gemstoneengraving.Bond.CurioUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class CuriosMath {

    public  static AttributeModifier setAttributes(SlotContext slotContext , ItemStack itemStack,double value,String countType,String  resourceLocationPath){

        LivingEntity entity = slotContext.entity();
        ResourceLocation id =ResourceLocation.fromNamespaceAndPath("gemstoneengraving",resourceLocationPath);
        AttributeMap attributes = entity.getAttributes();

        int getCount = CurioUtils.getCurioCount(entity, itemStack);

        if(countType.equals("ADD_VALUE")){

            AttributeModifier modifier = new AttributeModifier(
                    id,
                    value*getCount,
                    AttributeModifier.Operation.ADD_VALUE
            );
            return modifier;
        }
        else if(countType.equals("ADD_MULTIPLIED_BASE")){

            AttributeModifier modifier = new AttributeModifier(
                    id,
                    1+(value*getCount),
                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            return modifier;

        }

        return null;
    }

}
