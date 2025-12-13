package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class JumpResistance {
    public static void onPlayerJumpDamage(LivingDamageEvent.Pre event) {

        if (event.getEntity() instanceof Player player){
            if(CurioUtils.isCurio(player, ItemRegistery.JADE.get())&&CurioUtils.isCurio(player,ItemRegistery.HELVITE.get())) {
                if (event.getSource().is(DamageTypes.FALL)) {

                    event.setNewDamage(0);

                }
            }
        }
    }
}
