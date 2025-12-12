package gemstoneengraving.Bond.Events;

import gemstoneengraving.Capability.ExplosionKnockbackResistance;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BloodThirsty {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void bloodThirstyHurtEvent(LivingDamageEvent.Post event){

        if (event.getSource().getEntity() instanceof Player player){

            float damage =event.getOriginalDamage()/2;
            if(ExplosionKnockbackResistance.getBoolean()){


                player.setHealth(Math.min(player.getHealth()+damage,player.getMaxHealth()));

            }
        }

    }






}
