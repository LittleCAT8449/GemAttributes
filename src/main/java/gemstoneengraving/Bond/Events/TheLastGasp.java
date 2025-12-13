package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.function.Supplier;

public class TheLastGasp {

    private static final Supplier<MobEffectInstance> strength = () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,1200, 1, true, false);
    public static void onPlayerEnhanceStrength(LivingDamageEvent.Post event) {

        if(event.getEntity() instanceof Player player){

            if(CurioUtils.isCurio(player, ItemRegistery.SPINEL.get())&&CurioUtils.isCurio(player, ItemRegistery.MICA.get())) {

                if(player.getHealth() < player.getMaxHealth()*0.25) {

                    player.addEffect(strength.get());

                }

            }

        }

    }


}
