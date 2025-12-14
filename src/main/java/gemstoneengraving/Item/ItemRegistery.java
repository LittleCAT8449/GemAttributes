package gemstoneengraving.Item;

import gemstoneengraving.Capability.*;
import gemstoneengraving.Gemstoneengraving;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistery {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gemstoneengraving.MODID);
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", ()-> new Ruby(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SAPPHIRE = ITEMS.register("sapphire", ()-> new Sapphire(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SLIME_CORE = ITEMS.register("slime_core", ()-> new SlimeCore(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CONCH_PEARL = ITEMS.register("conch_pearl", ()-> new ConchPearl(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PARTSCHINITE =ITEMS.register("partschinite", ()-> new Partschinite(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> JADE = ITEMS.register("jade", ()-> new Jade(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PHANTOM_CRYSTAL = ITEMS.register("phantom_crystal", ()-> new PhantomCrystal(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.register("aquamarine", ()-> new Aquamarine(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> TOPAZ = ITEMS.register("topaz", ()-> new Topaz(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> HELVITE = ITEMS.register("helvite", ()-> new Helvite(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> TSAVORITE = ITEMS.register("tsavorite", ()-> new Tsavorite(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> AMBER = ITEMS.register("amber", ()-> new Amber(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MICA =ITEMS.register("mica", ()-> new Mica(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CATSEYE = ITEMS.register("catseye", ()-> new Catseye(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MAHENGE =ITEMS.register("mahenge", ()-> new Mahenge(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> SPINEL = ITEMS.register("spinel", ()-> new Spinel(new Item.Properties().stacksTo(1)));





    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
