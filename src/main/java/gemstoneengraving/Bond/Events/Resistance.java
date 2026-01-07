package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Config;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class Resistance {

    public static void onPlayerGetDamage(LivingDamageEvent.Pre event) {

        if(event.getEntity() instanceof Player player){
            if(CurioUtils.isCurio(player, ItemRegistery.SLIME_CORE.get())
            &&CurioUtils.isCurio(player,ItemRegistery.TSAVORITE.get())) {
                boolean isEquipped=true;
                float new_damage = (float) (event.getOriginalDamage() * Config.Resistance.get());
                event.setNewDamage(new_damage);
            }
        }


    }

}
