package com.misled.prisons.tasks;

import cn.nukkit.block.Block;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.passive.EntityCow;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.Tag;
import com.misled.prisons.PrisonCore;

import java.util.Objects;

public class cowSpawner implements Runnable {

    @Override
    public void run() {
        Block block = PrisonCore.getInstance().getServer().getLevelByName("world").getBlock(new Vector3(-10,212,0));
        boolean cows = false;
        for (Entity value : PrisonCore.getInstance().getServer().getLevelByName("world").getEntities()) {
            if (value instanceof EntityCow) {
                cows = true;
                if (block.getId() == Block.DIAMOND_BLOCK) {
                    if(value.namedTag.getInt("Cows") < 5){
                        value.namedTag.putInt("Cows",value.namedTag.getInt("Cows")+1);
                        value.setNameTag("Cow x"+value.namedTag.getInt("Cows"));
                    }
                }

            }
        }
        if(!cows && block.getId() == Block.DIAMOND_BLOCK){
            Entity cow = Entity.createEntity("Cow", new Position(-10, 213, 0, PrisonCore.getInstance().getServer().getLevelByName("world")));
            cow.setNameTag("Cow x0");
            cow.namedTag.putInt("Cows",0);
            cow.spawnToAll();
        }
    }
}