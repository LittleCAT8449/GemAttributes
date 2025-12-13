package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class Perseverance {

    public static void onFatalInjury(LivingDamageEvent.Pre event){

        if(event.getEntity() instanceof Player player) {
            if (CurioUtils.isCurio(player, ItemRegistery.PARTSCHINITE.get())
                    && CurioUtils.isCurio(player, ItemRegistery.PHANTOM_CRYSTAL.get())) {
                float getOriginalDamage = event.getOriginalDamage();
                float getPlayerHealth = player.getHealth();
                float getPlayerXp = player.experienceLevel;

                if (getOriginalDamage > getPlayerHealth) {
                    if (getPlayerXp > 10) {

                        event.setNewDamage(0);
                        event.getEntity().setHealth(Math.max(player.getMaxHealth(), player.getHealth()));
                        if (player instanceof ServerPlayer player1) {
                            player1.setExperienceLevels((int) getPlayerXp - 10);
                        }

                    }
                }

            }
        }

    }

}
