package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class ImmuneHarm {

    public static final Logger LOGGER = LogManager.getLogger();

    public static void onImmuneHarm(PlayerTickEvent.Pre event) {

        if(event.getEntity() instanceof Player player) {

          if (CurioUtils.isCurio(player, ItemRegistery.JADE.get())
            && CurioUtils.isCurio(player,ItemRegistery.CONCH_PEARL.get())
           && CurioUtils.isCurio(player,ItemRegistery.MAHENGE.get())){

                if(player.hasEffect(MobEffects.POISON)||player.hasEffect(MobEffects.WITHER)
                ||player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)||player.hasEffect(MobEffects.BLINDNESS)){

                    player.removeEffect(MobEffects.POISON);
                    player.removeEffect(MobEffects.WITHER);
                    player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                    player.removeEffect(MobEffects.BLINDNESS);


                }

            }

        }

    }

}
