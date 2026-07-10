package com.rainforestkongra.registry;

import com.rainforestkongra.RainforestKongraMod;
import com.rainforestkongra.item.KongraArmorItem;
import com.rainforestkongra.item.KongraArmorMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item KONGRA_SCALE = new Item(new Item.Settings());
    public static final Item KONGRA_FANG = new Item(new Item.Settings());
    public static final Item JUNGLE_ESSENCE = new Item(new Item.Settings());

    public static final Item KONGRA_HELMET =
            new KongraArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item KONGRA_CHESTPLATE =
            new KongraArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item KONGRA_LEGGINGS =
            new KongraArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item KONGRA_BOOTS =
            new KongraArmorItem(KongraArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings());

    public static SpawnEggItem KONGRA_SPAWN_EGG;
    public static SpawnEggItem JAGUAR_SPAWN_EGG;
    public static SpawnEggItem MACAW_SPAWN_EGG;

    public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, id("main"));

    public static void register() {
        // Register entities first so we can create spawn eggs referencing them
        ModEntities.register();

        registerItem("kongra_scale", KONGRA_SCALE);
        registerItem("kongra_fang", KONGRA_FANG);
        registerItem("jungle_essence", JUNGLE_ESSENCE);
        registerItem("kongra_helmet", KONGRA_HELMET);
        registerItem("kongra_chestplate", KONGRA_CHESTPLATE);
        registerItem("kongra_leggings", KONGRA_LEGGINGS);
        registerItem("kongra_boots", KONGRA_BOOTS);

        KONGRA_SPAWN_EGG = new SpawnEggItem(ModEntities.KONGRA, 0x3d3d3d, 0x5aa02c, new Item.Settings());
        JAGUAR_SPAWN_EGG = new SpawnEggItem(ModEntities.JAGUAR, 0xd9a441, 0x2b1a0a, new Item.Settings());
        MACAW_SPAWN_EGG = new SpawnEggItem(ModEntities.MACAW, 0xcc2222, 0x2255cc, new Item.Settings());

        registerItem("kongra_spawn_egg", KONGRA_SPAWN_EGG);
        registerItem("jaguar_spawn_egg", JAGUAR_SPAWN_EGG);
        registerItem("macaw_spawn_egg", MACAW_SPAWN_EGG);

        ItemGroup group = FabricItemGroup.builder()
                .icon(() -> new ItemStack(KONGRA_CHESTPLATE))
                .displayName(Text.translatable("itemGroup.rainforestkongra.main"))
                .build();
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, group);

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY).register(entries -> {
            entries.add(KONGRA_SCALE);
            entries.add(KONGRA_FANG);
            entries.add(JUNGLE_ESSENCE);
            entries.add(KONGRA_HELMET);
            entries.add(KONGRA_CHESTPLATE);
            entries.add(KONGRA_LEGGINGS);
            entries.add(KONGRA_BOOTS);
            entries.add(KONGRA_SPAWN_EGG);
            entries.add(JAGUAR_SPAWN_EGG);
            entries.add(MACAW_SPAWN_EGG);
        });
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, id(name), item);
    }

    private static Identifier id(String path) {
        return new Identifier(RainforestKongraMod.MOD_ID, path);
    }
}