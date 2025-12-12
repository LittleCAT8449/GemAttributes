package gemstoneengraving.Bond.Events;

import gemstoneengraving.Capability.SneakingSpeed;
import gemstoneengraving.Capability.SwimSpeed;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.function.Supplier;

public class WaterBreathing {

    private static final Supplier<MobEffectInstance> water_breathing = () -> new MobEffectInstance(MobEffects.WATER_BREATHING,1000, 0, true, false);
    public static void onWaterBreathing(PlayerTickEvent.Pre event) {

        if(SwimSpeed.getBoolean()){

            event.getEntity().addEffect(water_breathing.get());

        }

    }

}
