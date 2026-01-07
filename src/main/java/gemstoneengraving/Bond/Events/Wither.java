package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Capability.Amber;
import gemstoneengraving.Config;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class Wither {
    public static final Logger LOGGER = LogManager.getLogger();
    private static final Supplier<MobEffectInstance> wither = () -> new MobEffectInstance(MobEffects.WITHER, Config.Wither.get()*100, 2, true, false);
    public static void onWither(LivingDamageEvent.Post event) {
        if(event.getSource().getEntity() instanceof Player player){
            if(CurioUtils.isCurio(player, ItemRegistery.AMBER.get())
                &&CurioUtils.isCurio(player,ItemRegistery.PARTSCHINITE.get())) {
                boolean isEquipped=true;
                event.getEntity().addEffect(wither.get());
                LOGGER.info(("Abhor Successfully"));
            }
        }
    }

}
