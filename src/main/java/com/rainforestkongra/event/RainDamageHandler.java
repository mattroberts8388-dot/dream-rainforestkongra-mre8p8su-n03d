package com.rainforestkongra.event;

import com.rainforestkongra.util.KongraArmorHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RainDamageHandler {
    // How long (ticks) a player must be exposed before taking damage.
    private static final int EXPOSURE_THRESHOLD = 100; // 5 seconds
    private static final int DAMAGE_INTERVAL = 40; // every 2 seconds after threshold
    private static final float DAMAGE_AMOUNT = 2.0f; // 1 heart

    private static final Map<UUID, Integer> exposureTicks = new HashMap<>();

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerWorld world : server.getWorlds()) {
                for (ServerPlayerEntity player : world.getPlayers()) {
                    tickPlayer(world, player);
                }
            }
        });
    }

    private static void tickPlayer(ServerWorld world, ServerPlayerEntity player) {
        UUID id = player.getUuid();

        if (player.isCreative() || player.isSpectator() || !player.isAlive()) {
            exposureTicks.remove(id);
            return;
        }

        boolean rainyJungle = isRainingOn(world, player) && isJungleBiome(world, player);
        boolean protectedByArmor = KongraArmorHelper.piecesWorn(player) >= 4;

        if (rainyJungle && !protectedByArmor) {
            int ticks = exposureTicks.getOrDefault(id, 0) + 1;
            exposureTicks.put(id, ticks);

            if (ticks >= EXPOSURE_THRESHOLD && (ticks - EXPOSURE_THRESHOLD) % DAMAGE_INTERVAL == 0) {
                DamageSource source = world.getDamageSources().create(DamageTypes.DROWN);
                player.damage(source, DAMAGE_AMOUNT);
            }
        } else {
            // Recover exposure quickly when sheltered or protected.
            int ticks = exposureTicks.getOrDefault(id, 0);
            if (ticks > 0) {
                exposureTicks.put(id, Math.max(0, ticks - 4));
            }
        }
    }

    private static boolean isRainingOn(ServerWorld world, ServerPlayerEntity player) {
        if (!world.isRaining()) return false;
        return world.isSkyVisible(player.getBlockPos())
                && world.getTopY(net.minecraft.world.Heightmap.Type.MOTION_BLOCKING, player.getBlockX(), player.getBlockZ())
                <= player.getBlockPos().getY();
    }

    private static boolean isJungleBiome(ServerWorld world, ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = world.getBiome(player.getBlockPos());
        // Treat any biome that can rain and is warm/humid as "rainforest".
        return biome.matchesKey(net.minecraft.world.biome.BiomeKeys.JUNGLE)
                || biome.matchesKey(net.minecraft.world.biome.BiomeKeys.SPARSE_JUNGLE)
                || biome.matchesKey(net.minecraft.world.biome.BiomeKeys.BAMBOO_JUNGLE);
    }
}