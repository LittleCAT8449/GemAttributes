package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Capability.PhantomCrystal;
import gemstoneengraving.Config;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BloodThirsty {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void bloodThirstyHurtEvent(LivingDamageEvent.Post event){

        if (event.getSource().getEntity() instanceof Player player){

            float damage =event.getOriginalDamage()/ Config.BloodThirsty.get();
          if(CurioUtils.isCurio(player, ItemRegistery.PHANTOM_CRYSTAL.get())&&CurioUtils.isCurio(player, ItemRegistery.RUBY.get())){


                player.setHealth(Math.min(player.getHealth()+damage,player.getMaxHealth()));
                LOGGER.info("BloodThirsty"+damage+"Value");

            }
        }

    }






}
