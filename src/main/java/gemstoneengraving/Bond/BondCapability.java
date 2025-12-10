package gemstoneengraving.Bond;

import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.player.Player;

public class BondCapability {


    public static boolean effectCapability (Player player){


        boolean ruby= CurioUtils.isCurio(player, ItemRegistery.RUBY.toStack(1).getItem());
        boolean sapphire = CurioUtils.isCurio(player, ItemRegistery.SAPPHIRE.toStack().getItem());

        if(ruby && sapphire){
            return  true;
        }
        return false;


    }

}
