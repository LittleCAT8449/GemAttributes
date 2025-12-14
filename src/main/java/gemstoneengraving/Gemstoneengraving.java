package gemstoneengraving;

import com.mojang.logging.LogUtils;
import gemstoneengraving.Bond.BondListener;
import gemstoneengraving.Item.ItemRegistery;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Gemstoneengraving.MODID)
public class Gemstoneengraving {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gemstoneengraving";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "gemstoneengraving" namespace

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Gemstoneengraving(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading

        ItemRegistery.register(modEventBus);
        GemGroup.register(modEventBus);


        NeoForge.EVENT_BUS.register(BondListener.class);

        // Register the item to a creative tab


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }


    // Add the example block item to the building blocks

    // You can use SubscribeEvent and let the Event Bus discover methods to call

    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }




    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent

}
