package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Config;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.function.Supplier;

public class Perseverance {
    private static final Supplier<MobEffectInstance> absorption = () -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 4, true, false);
    public static void onFatalInjury(LivingDamageEvent.Pre event){

        if(event.getEntity() instanceof Player player) {
            if (CurioUtils.isCurio(player, ItemRegistery.PARTSCHINITE.get())
                    && CurioUtils.isCurio(player, ItemRegistery.PHANTOM_CRYSTAL.get())) {
                float getOriginalDamage = event.getOriginalDamage();
                float getPlayerHealth = player.getHealth();
                float getPlayerXp = player.experienceLevel;

                if (getOriginalDamage > getPlayerHealth) {
                    if (getPlayerXp > Config.Perseverance.get()) {

                        event.setNewDamage(0);
                        event.getEntity().setHealth(2);
                        player.addEffect(absorption.get());
                        if (player instanceof ServerPlayer player1) {
                            player1.setExperienceLevels((int) getPlayerXp - Config.Perseverance.get());
                        }

                    }
                }

            }
        }

    }

}
