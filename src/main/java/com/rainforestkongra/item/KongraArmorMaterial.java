package com.rainforestkongra.item;

import com.rainforestkongra.registry.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public class KongraArmorMaterial implements ArmorMaterial {
    public static final KongraArmorMaterial INSTANCE = new KongraArmorMaterial();

    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};
    private static final int[] PROTECTION = {4, 8, 7, 4};

    private final Lazy<Ingredient> repairIngredient =
            new Lazy<>(() -> Ingredient.ofItems(ModItems.KONGRA_SCALE));

    public static void init() {
        // Forces class load; INSTANCE already created.
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * 45;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return "kongra";
    }

    @Override
    public float getToughness() {
        return 3.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.15f;
    }
}