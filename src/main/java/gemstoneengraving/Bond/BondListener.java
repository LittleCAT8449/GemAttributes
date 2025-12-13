package gemstoneengraving.Bond;

import gemstoneengraving.Bond.Events.*;

import gemstoneengraving.Gemstoneengraving;
import net.neoforged.bus.api.SubscribeEvent;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;



@Mod(Gemstoneengraving.MODID)
public class BondListener {

    @SubscribeEvent
    public static void onLivingHurtEventPre(LivingDamageEvent.Pre event){
        Frenzy.enhanceDamageEvent(event);
        Slash.onSlashEvent(event);


    }
    @SubscribeEvent
    public static void onLivingHurtEventPost(LivingDamageEvent.Post event){
        BloodThirsty.bloodThirstyHurtEvent(event);
        Wither.onWither(event);
    }
    @SubscribeEvent
    public static void onPlayerXpEvent(PlayerXpEvent.PickupXp event){
        Absorb.getMoreXpEvent(event);

    }
    @SubscribeEvent
    public static void onPlayerTickEvent(PlayerTickEvent.Pre event){
        NightVision.onNightVision(event);
        WaterBreathing.onWaterBreathing(event);
    }




}
