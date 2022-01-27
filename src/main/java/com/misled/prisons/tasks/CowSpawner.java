package com.misled.prisons.tasks;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.passive.EntityCow;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;
import com.misled.prisons.PrisonCore;

import static com.misled.prisons.utils.PluginValues.*;

public class CowSpawner implements Runnable {

    @Override
    public void run() {
        if(!cowsEnabled) return;
        int cows = 0;
        if(PrisonCore.getInstance().getServer().getLevelByName("ward-d") == null) return;
        for (Entity value : PrisonCore.getInstance().getServer().getLevelByName("ward-d").getEntities()) {
            if (value instanceof EntityCow) {
                cows++;
                if(value.namedTag.getInt("Cows") < 5){
                    value.namedTag.putInt("Cows",value.namedTag.getInt("Cows")+1);
                    value.setNameTag("Cow x"+value.namedTag.getInt("Cows"));
                }
            }
        }
        if(cows < cowCords.length){
            for (Vector3 cowCord : cowCords) {
                Entity cow = Entity.createEntity("Cow", new Position(cowCord.x, cowCord.y, cowCord.z, PrisonCore.getInstance().getServer().getLevelByName("ward-d")));
                cow.setNameTag("Cow x0");
                cow.namedTag.putInt("Cows", 0);
                cow.spawnToAll();
            }
        }
    }
}