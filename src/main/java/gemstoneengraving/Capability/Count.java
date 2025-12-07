package gemstoneengraving.Capability;

import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.concurrent.atomic.AtomicInteger;

public class Count{

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

}