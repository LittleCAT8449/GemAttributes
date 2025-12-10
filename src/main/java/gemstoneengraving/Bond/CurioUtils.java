package gemstoneengraving.Bond;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.List;

public class CurioUtils {

    public static List<ItemStack> getEquipCurios(Player player){

        List<ItemStack> curios = new ArrayList<>();

            CuriosApi.getCuriosInventory(player).ifPresent(iCuriosItemHandler->{
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

    public static boolean isCurio(Player player,Item item){
        List<ItemStack> curios = getEquipCurios(player);

        for(ItemStack stack:curios){
            Item getCuriosId= stack.getItem();
            if(getCuriosId==item){
                return true;
            }

        }
        return false;
    }
};
