package gemstoneengraving.Bond.Events;


import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Config;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.geom.Arc2D;

public class Frenzy {
    public static final Logger LOGGER = LogManager.getLogger();
    public static void enhanceDamageEvent(LivingDamageEvent.Pre event){

          if (event.getSource().getEntity() instanceof Player player) {
              ;if (CurioUtils.isCurio(player, ItemRegistery.RUBY.get())&&CurioUtils.isCurio(player, ItemRegistery.SAPPHIRE.get())) {
                float new_damage = (float) (event.getOriginalDamage() * Config.Frenzy.get());
                LOGGER.info("Damage Refix Successfully");
                event.setNewDamage(new_damage);
            }



        }

    }

}
