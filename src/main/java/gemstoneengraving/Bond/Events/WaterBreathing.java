package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Capability.ConchPearl;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.function.Supplier;

public class WaterBreathing {

    private static final Supplier<MobEffectInstance> water_breathing = () -> new MobEffectInstance(MobEffects.WATER_BREATHING,1000, 0, true, false);
    public static void onWaterBreathing(PlayerTickEvent.Pre event) {
        if(event.getEntity() instanceof Player player) {
            if (CurioUtils.isCurio(player, ItemRegistery.CONCH_PEARL.get())
                &&CurioUtils.isCurio(player,ItemRegistery.AQUAMARINE.get())
                &&CurioUtils.isCurio(player,ItemRegistery.TOPAZ.get())){

                event.getEntity().addEffect(water_breathing.get());

            }
        }

    }

}
