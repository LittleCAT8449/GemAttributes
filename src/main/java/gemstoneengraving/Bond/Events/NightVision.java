package gemstoneengraving.Bond.Events;

import gemstoneengraving.Capability.SneakingSpeed;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.function.Supplier;

public class NightVision {
    private static final Supplier<MobEffectInstance> night_vision = () -> new MobEffectInstance(MobEffects.NIGHT_VISION,1000, 0, true, false);
    public static void onNightVision(PlayerTickEvent.Pre event) {

        if(SneakingSpeed.getBoolean()){

            event.getEntity().addEffect(night_vision.get());

        }

    }

}
