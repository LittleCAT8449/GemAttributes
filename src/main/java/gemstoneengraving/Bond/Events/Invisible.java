package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.function.Supplier;

public class Invisible {

    private static final Supplier<MobEffectInstance> invisible = () -> new MobEffectInstance(MobEffects.INVISIBILITY,20, 0, true, false);
    public static void onNightVision(PlayerTickEvent.Pre event) {

        if(event.getEntity() instanceof Player player) {
           if(CurioUtils.isCurio(player, ItemRegistery.AQUAMARINE.get())
                    &&CurioUtils.isCurio(player,ItemRegistery.HELVITE.get())
                    &&player.isShiftKeyDown()) {
                event.getEntity().addEffect(invisible.get());
            }
        }

    }

}
