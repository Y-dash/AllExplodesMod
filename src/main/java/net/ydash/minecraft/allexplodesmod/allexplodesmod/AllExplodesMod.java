package net.ydash.minecraft.allexplodesmod.allexplodesmod;

import net.minecraft.block.TNTBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod("all-explodes-mod")
public class AllExplodesMod {
    public AllExplodesMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onExplosionDetonateEvent(ExplosionEvent.Detonate event) {
        World world = event.getWorld();

        List<BlockPos> blockPosList = event.getAffectedBlocks();
        blockPosList.forEach(blockPos -> TNTBlock.explode(world, blockPos));

        List<Entity> entityList = event.getAffectedEntities();
        entityList.forEach(entity -> TNTBlock.explode(world, entity.getPosition()));
    }
}
