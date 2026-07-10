package com.rainforestkongra.util;

import com.rainforestkongra.item.KongraArmorItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class KongraArmorHelper {
    public static boolean isWearingFullSet(PlayerEntity player) {
        for (ItemStack stack : player.getArmorItems()) {
            if (stack.isEmpty() || !(stack.getItem() instanceof KongraArmorItem)) {
                return false;
            }
        }
        return true;
    }

    public static int piecesWorn(PlayerEntity player) {
        int count = 0;
        for (ItemStack stack : player.getArmorItems()) {
            if (!stack.isEmpty() && stack.getItem() instanceof KongraArmorItem) {
                count++;
            }
        }
        return count;
    }
}