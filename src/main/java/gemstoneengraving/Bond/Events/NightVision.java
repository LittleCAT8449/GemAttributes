package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Capability.Catseye;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.function.Supplier;

public class NightVision {
    private static final Supplier<MobEffectInstance> night_vision = () -> new MobEffectInstance(MobEffects.NIGHT_VISION,240, 0, true, false);
    public static void onNightVision(PlayerTickEvent.Pre event) {

        if(event.getEntity() instanceof Player player) {
            if(CurioUtils.isCurio(player, ItemRegistery.CATSEYE.get())) {
                boolean isEquipped=true;
                event.getEntity().addEffect(night_vision.get());
            }
        }

    }

}
