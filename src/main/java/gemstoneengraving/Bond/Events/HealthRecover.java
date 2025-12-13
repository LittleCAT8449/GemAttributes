package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.function.Supplier;

public class HealthRecover {

    private static final Supplier<MobEffectInstance> regeneration = () -> new MobEffectInstance(MobEffects.REGENERATION,100, 1, true, false);
    public static void onPlayerRecoverHealth(LivingDamageEvent.Post event) {

        if(event.getEntity() instanceof Player player){

            if(CurioUtils.isCurio(player, ItemRegistery.SPINEL.get())&&CurioUtils.isCurio(player, ItemRegistery.MAHENGE.get())) {

                if(player.getHealth() < player.getMaxHealth()*0.3) {

                    player.addEffect(regeneration.get());

                }

            }

        }

    }

}
