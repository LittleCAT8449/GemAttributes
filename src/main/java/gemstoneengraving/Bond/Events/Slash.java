package gemstoneengraving.Bond.Events;

import gemstoneengraving.Capability.AttackKnockBack;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Slash {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void onSlashEvent(LivingDamageEvent.Pre event){

        if(event.getSource().getEntity() instanceof Player player){
            if(AttackKnockBack.getBoolean()){
                LOGGER.info("Slash Successfully");
                if(player.getRandom().nextDouble() <0.15f){
                    float new_damage = event.getEntity().getHealth();
                    event.setNewDamage(new_damage);
                }
            }

        }

    }

}
