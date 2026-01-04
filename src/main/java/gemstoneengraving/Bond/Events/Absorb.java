package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Capability.Tsavorite;
import gemstoneengraving.Config;
import gemstoneengraving.CuriosMath;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Absorb {
    //Luck
    public static final Logger LOGGER = LogManager.getLogger();

    public static void getMoreXpEvent(PlayerXpEvent.PickupXp event){
        if(event.getEntity() instanceof Player player){
            if(CurioUtils.isCurio(player, ItemRegistery.TSAVORITE.get())
                    &&CurioUtils.isCurio(player,ItemRegistery.AMBER.get())
                    &&CurioUtils.isCurio(player,ItemRegistery.TOPAZ.get())){

                event.getOrb().value= event.getOrb().value* Config.Absorb.get();
                LOGGER.info("XP Refix "+event.getOrb().value+"Value");

            }
        }
    }

}
