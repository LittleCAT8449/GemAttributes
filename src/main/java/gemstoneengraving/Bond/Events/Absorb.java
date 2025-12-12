package gemstoneengraving.Bond.Events;

import gemstoneengraving.Capability.Luck;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Absorb {
    //Luck
    public static final Logger LOGGER = LogManager.getLogger();

    public static void getMoreXpEvent(PlayerXpEvent.PickupXp event){
        if(Luck.getBoolean()){

            int new_xp = event.getOrb().value*2;
            event.getOrb().value=new_xp;
            LOGGER.info("XP Refix Successfully");
        }
    }

}
