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
    public static final DeferredItem<Item> JADE = ITEMS.register("jade", ()-> new SafeFallDistance(new Item.Properties()));
    public static final DeferredItem<Item> PHANTOM_CRYSTAL = ITEMS.register("phantom_crystal", ()-> new ExplosionKnockbackResistance(new Item.Properties()));
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.register("aquamarine", ()-> new WaterMovementEfficiency(new Item.Properties()));
    public static final DeferredItem<Item> TOPAZ = ITEMS.register("topaz", ()-> new OxygenBonus(new Item.Properties()));
    public static final DeferredItem<Item> HELVITE = ITEMS.register("helvite", ()-> new MovementSpeed(new Item.Properties()));
    public static final DeferredItem<Item> TSAVORITE = ITEMS.register("tsavorite", ()-> new Luck(new Item.Properties()));
    public static final DeferredItem<Item> AMBER = ITEMS.register("amber", ()-> new BurningTime(new Item.Properties()));
    public static final DeferredItem<Item> MICA =ITEMS.register("mica", ()-> new KnockBackResistance(new Item.Properties()));
    public static final DeferredItem<Item> CATSEYE = ITEMS.register("catseye", ()-> new SneakingSpeed(new Item.Properties()));
    public static final DeferredItem<Item> MAHENGE =ITEMS.register("mahenge", ()-> new EntityInteractionRange(new Item.Properties()));
    public static final DeferredItem<Item> SPINEL = ITEMS.register("spinel", ()-> new BlockInteractionRange(new Item.Properties()));





    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
