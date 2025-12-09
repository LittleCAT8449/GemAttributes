package gemstoneengraving.Item;

import gemstoneengraving.Capability.*;
import gemstoneengraving.Gemstoneengraving;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
    public static final DeferredItem<Item> PARTSCHINITE =ITEMS.register("partschinite", ()-> new Armor(new Item.Properties()));
    public static final DeferredItem<Item> JADE = ITEMS.register("jade", ()-> new ArmorToughness(new Item.Properties()));
    public static final DeferredItem<Item> PHANTOM_CRYSTAL = ITEMS.register("phantom_crystal", ()-> new ExplosionKnockbackResistance(new Item.Properties()));
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.register("aquamarine", ()-> new WaterMovementEfficiency(new Item.Properties()));






    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
