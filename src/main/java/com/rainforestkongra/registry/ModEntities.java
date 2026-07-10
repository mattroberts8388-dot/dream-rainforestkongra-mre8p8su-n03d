package com.rainforestkongra.registry;

import com.rainforestkongra.RainforestKongraMod;
import com.rainforestkongra.entity.JaguarEntity;
import com.rainforestkongra.entity.KongraEntity;
import com.rainforestkongra.entity.MacawEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    private static boolean registered = false;

    public static EntityType<KongraEntity> KONGRA;
    public static EntityType<JaguarEntity> JAGUAR;
    public static EntityType<MacawEntity> MACAW;

    public static void register() {
        if (registered) return;
        registered = true;

        KONGRA = Registry.register(Registries.ENTITY_TYPE, id("kongra"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KongraEntity::new)
                        .dimensions(EntityDimensions.fixed(1.6f, 3.2f))
                        .trackRangeBlocks(64)
                        .build());

        JAGUAR = Registry.register(Registries.ENTITY_TYPE, id("jaguar"),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JaguarEntity::new)
                        .dimensions(EntityDimensions.fixed(0.9f, 0.8f))
                        .trackRangeBlocks(32)
                        .build());

        MACAW = Registry.register(Registries.ENTITY_TYPE, id("macaw"),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MacawEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.7f))
                        .trackRangeBlocks(32)
                        .build());
    }

    private static Identifier id(String path) {
        return new Identifier(RainforestKongraMod.MOD_ID, path);
    }
}