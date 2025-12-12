package gemstoneengraving.Bond.Events;

import gemstoneengraving.Capability.AttackDamage;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Frenzy {
    public static final Logger LOGGER = LogManager.getLogger();
    public static void enhanceDamageEvent(LivingDamageEvent.Pre event){

          if (event.getSource().getEntity() instanceof Player player) {
              ;
            if (AttackDamage.getBoolean()) {
                float new_damage = event.getOriginalDamage() * 1.3F;
                LOGGER.info("Damage Refix Successfully");
                event.setNewDamage(new_damage);
            }


        }

    }

}
