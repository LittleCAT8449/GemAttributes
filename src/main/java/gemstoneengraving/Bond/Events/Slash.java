package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Capability.SlimeCore;
import gemstoneengraving.Config;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Slash {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void onSlashEvent(LivingDamageEvent.Pre event){

        if(event.getSource().getEntity() instanceof Player player){
            if(CurioUtils.isCurio(player, ItemRegistery.SLIME_CORE.get())
                    &&CurioUtils.isCurio(player,ItemRegistery.SAPPHIRE.get())){

                    if(event.getEntity().getHealth()<event.getEntity().getHealth()* Config.Slash_Under.get()){
                    if(player.getRandom().nextDouble() <Config.Slash_Probability.get()){
                        LOGGER.info("Slash Successfully");
                        float new_damage = event.getEntity().getHealth();
                        event.setNewDamage(new_damage);
                    }
                }
            }

        }

    }

}
