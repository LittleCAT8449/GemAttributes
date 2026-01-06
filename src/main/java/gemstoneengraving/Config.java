package gemstoneengraving;

import gemstoneengraving.Bond.Events.Wither;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Config {

    public static final Logger LOGGER = LogManager.getLogger();

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder().comment("All Config").push("Config");

    public static final ModConfigSpec.DoubleValue Amber_Value = BUILDER.comment("Amber Basic,Range -1.0~0").defineInRange("amber_multiple",-0.2, -0.9, 0.0);

    public static final ModConfigSpec.DoubleValue Aquamarine_Value = BUILDER.comment("Aquamarine Basic,Range 0.1~0.5").defineInRange("aquamarine_multiple",0.1, 0.1, 1.0);

    public static final ModConfigSpec.DoubleValue Cats_Eye = BUILDER.comment("Cats_eye Basic,Range 0.1~1.0").defineInRange("catseye_multiple",0.2, 0.1, 1.0);

    public static final ModConfigSpec.DoubleValue Conch_Pearl = BUILDER.comment("Conch_pearl Basic,Range 0.1~2.0").defineInRange("conch_pearl_multiple",0.25, 0.1, 1.0);

    public static final ModConfigSpec.DoubleValue Helvite = BUILDER.comment("Helvite Basic,Range 0.05~0.1").defineInRange("helvite_multiple",0.2, 0.1, 1.0);

    public static final ModConfigSpec.DoubleValue Jade = BUILDER.comment("Jade Basic,Range 1.0~10.0").defineInRange("jade_multiple",1.0, 1.0, 10.0);

    public static final ModConfigSpec.DoubleValue Mahenge = BUILDER.comment("Mahenge Basic,Range 0.1~1.0").defineInRange("mahenge_multiple",0.2, 0.1, 1.0);

    public static final ModConfigSpec.DoubleValue Mica = BUILDER.comment("Mica Basic,Range 0.1~0.5").defineInRange("mica_multiple",0.2, 0.1, 1.0);

    public static final ModConfigSpec.IntValue Partschinite = BUILDER.comment("Partschinite Basic,Range 1~20").defineInRange("partschinite_multiple",2 ,1, 20);

    public static final ModConfigSpec.DoubleValue PhantomCrystal = BUILDER.comment("PhantomCrystal Basic,Range 0.1~1.0").defineInRange("phantomCrystal_multiple",0.2 ,0.1, 1.0);

    public static final ModConfigSpec.IntValue Ruby = BUILDER.comment("Ruby Basic,Range 1~100").defineInRange("ruby_multiple",4 ,1, 100);

    public static final ModConfigSpec.DoubleValue Sapphire = BUILDER.comment("Sapphire Basic,Range 0.5~3.0").defineInRange("sapphire_multiple",0.25 ,0.1, 2.0);

    public static final ModConfigSpec.DoubleValue Slime_Core = BUILDER.comment("Slime_Core Basic,Range 1.0~3.0").defineInRange("slime_core_multiple",0.2 ,0.1, 2.0);

    public static final ModConfigSpec.DoubleValue Spinel = BUILDER.comment("Spinel Basic,Range 0.5~3.0").defineInRange("spinel_multiple",0.2 ,0.5, 3.0);

    public static final ModConfigSpec.DoubleValue Topaz = BUILDER.comment("Topaz Basic,Range 1.0~2.0").defineInRange("topaz_multiple",0.2,0.1, 1.0);

    public static final ModConfigSpec.DoubleValue Tsavorite=BUILDER.comment("Tsavorite Basic,Range 0.1~2.0").defineInRange("tsavorite_multiple",1.0,0.1,2.0);


    public static final ModConfigSpec.IntValue Absorb=BUILDER.comment("Absorb experience multiple,Range 1~10").defineInRange("tsavorite",2,1,10);

    public static final ModConfigSpec.IntValue BloodThirsty=BUILDER.comment("Blood suction volume(The Small The Better),Range 1~5").defineInRange("tsavorite",2,1,5);

    public static final ModConfigSpec.DoubleValue Frenzy=BUILDER.comment("Inflicts Range% of damage in attack.,Range 1.0~3.0").defineInRange("frenzy",1.3,1.0,3.0);

    public static final ModConfigSpec.DoubleValue GuaranteedDamage=BUILDER.comment("When attacked, the creature will suffer damage equal to its Range% of its maximum health.,Range 0.01~0.5").defineInRange("guaranteedDamage",0.05,0.01,0.5);

    public static final ModConfigSpec.IntValue HealthRecover_Duration=BUILDER.comment("HealthRecover_Duration,Range 3~100").defineInRange("health_recover_duration_multiple",5,3,100);

    public static final ModConfigSpec.DoubleValue HealthRecover_Duration_Multiple=BUILDER.comment("When health is below 'Range', health recovery is obtained.,Range 0.01~0.5").defineInRange("healthRecover_duration_multiple",0.05,0.01,0.5);

    public static final ModConfigSpec.IntValue Perseverance=BUILDER.comment("When suffering a fatal injury, deduct the experience based on the Range% level.,Range 0~100").defineInRange("perseverance",10,0,100);

    public static final ModConfigSpec.DoubleValue Resistance=BUILDER.comment("When getting injured, the player only receives Range% of the damage.,Range 0~1").defineInRange("resistance",0.75,0.0,1.0);

    public static final ModConfigSpec.DoubleValue Slash_Under=BUILDER.comment("When the health of the hostile creature drops below Range%, a kill will be triggered.,Range 0~1").defineInRange("slash_under",0.45,0.0,1.0);

    public static final ModConfigSpec.DoubleValue Slash_Probability=BUILDER.comment("The probability of triggering a kill attack.,Range 0~1").defineInRange("slash_probability",0.10,0.0,1.0);

    public static final ModConfigSpec.DoubleValue The_Last_Gasp_Health=BUILDER.comment("It triggers when the health value drops below Range%.,Range 0~1").defineInRange("last_health",0.5,0.0,1.0);

    public static final ModConfigSpec.IntValue The_Last_Gasp_Duration=BUILDER.comment("Strength Duration.,Range 1~120").defineInRange("last_duration",60,1,120);

    public static final ModConfigSpec.IntValue Wither=BUILDER.comment("The duration of the decay effect that targets hostile creatures when attacking them..,Range 1~120").defineInRange("last_duration",60,1,120);

    public static final ModConfigSpec.ConfigValue<String>  Absorb_Bond = BUILDER.comment("The list of items that can get absorb synergy").define("absorb_bond", "gemstoneengraving:catseye");

    static final ModConfigSpec SPEC = BUILDER.build();




}
