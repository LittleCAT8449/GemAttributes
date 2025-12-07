package gemstoneengraving.Item;

import gemstoneengraving.Capability.AttackDamage;
import gemstoneengraving.Capability.AttackKnockBack;
import gemstoneengraving.Capability.AttackSpeed;
import gemstoneengraving.Capability.SwimSpeed;
import gemstoneengraving.Gemstoneengraving;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistery {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gemstoneengraving.MODID);
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", ()-> new AttackDamage(new Item.Properties()));
    public static final DeferredItem<Item> SAPPHIRE = ITEMS.register("sapphire", ()-> new AttackSpeed(new Item.Properties()));
    public static final DeferredItem<Item> SLIME_CORE = ITEMS.register("slime_core", ()-> new AttackKnockBack(new Item.Properties()));
    public static final DeferredItem<Item> CONCH_PEARL = ITEMS.register("conch_pearl", ()-> new SwimSpeed(new Item.Properties()));






    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
