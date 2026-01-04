package gemstoneengraving.Bond;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.Mod;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CurioUtils {

    public static List<ItemStack> getEquipCurios(LivingEntity entity){

        List<ItemStack> curios = new ArrayList<>();

            CuriosApi.getCuriosInventory(entity).ifPresent(iCuriosItemHandler->{
                iCuriosItemHandler.getCurios().forEach((slotType,slotHandler)->{

                        for(int i=0;i<slotHandler.getSlots();i++){
                            ItemStack stack=slotHandler.getStacks().getStackInSlot(i);
                            if(!stack.isEmpty()){
                                curios.add(stack);
                            }

                    }
                }

            );

        });
            return curios;

    }

    public static boolean isCurio(LivingEntity entity, Item item){
        List<ItemStack> curios = getEquipCurios(entity);

        for(ItemStack stack:curios){
            Item getCuriosId= stack.getItem();
            if(getCuriosId.equals(item)){
                return true;
            }

        }
        return false;
    }

    public static int getCurioCount(LivingEntity livingEntity,ItemStack targetItem){

        AtomicInteger count=new AtomicInteger(0);
        CuriosApi.getCuriosInventory(livingEntity).ifPresent(iCuriosItemHandler -> {
            iCuriosItemHandler.getCurios().forEach((slotType,slotHandler)->{
                for(int i=0;i<slotHandler.getSlots();i++){
                    ItemStack stack=slotHandler.getStacks().getStackInSlot(i);
                    if(stack.getItem()==targetItem.getItem()){
                        count.incrementAndGet();
                    }
                }
            });
        });
        return count.get();
    }


};
