package gemstoneengraving;

import gemstoneengraving.Item.ItemRegistery;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GemGroup {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,Gemstoneengraving.MODID);

    public static final Supplier<CreativeModeTab> CREATIVE_MODE_TAB_SUPPLIER=
            CREATIVE_MODE_TABS.register("gemstone_tab",()-> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ItemRegistery.RUBY.get()))
                    .title(Component.literal("Gemstones"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemRegistery.RUBY);
                        output.accept(ItemRegistery.SAPPHIRE);
                        output.accept(ItemRegistery.SLIME_CORE);
                        output.accept(ItemRegistery.CONCH_PEARL);
                        output.accept(ItemRegistery.PARTSCHINITE);
                        output.accept(ItemRegistery.JADE);
                        output.accept(ItemRegistery.PHANTOM_CRYSTAL);
                        output.accept(ItemRegistery.AQUAMARINE);
                    }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }


}
