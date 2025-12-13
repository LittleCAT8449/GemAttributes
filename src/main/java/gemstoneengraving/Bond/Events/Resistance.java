package gemstoneengraving.Bond.Events;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class Resistance {

    public static void onPlayerHurtEvent (LivingDamageEvent.Pre event){

        if((event.getEntity() instanceof Player player)){

            float new_hurt = event.getOriginalDamage()*0.75F;

            event.setNewDamage(new_hurt);


        }

    }

}
