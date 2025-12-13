package gemstoneengraving.Bond.Events;

import gemstoneengraving.Bond.CurioUtils;
import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class GuaranteedDamage {
    public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    public static void onGuaranteedDamage(LivingDamageEvent.Pre event) {

        float OriginalDamage = event.getOriginalDamage();

        if(event.getSource().getEntity() instanceof Player player){
            LOGGER.info("Damage Refix Successfully1");
            if(CurioUtils.isCurio(player, ItemRegistery.MICA.get())
                    &&CurioUtils.isCurio(player, ItemRegistery.CATSEYE.get())) {

                float playerAttackDamage = event.getEntity().getMaxHealth() * 0.05f;
                LOGGER.info("Damage Refix Successfully2");

                event.setNewDamage(Math.max(OriginalDamage, playerAttackDamage));
            }
        }


    }

}
