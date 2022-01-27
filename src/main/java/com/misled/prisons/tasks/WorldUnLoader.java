package com.misled.prisons.tasks;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.Level;
import com.misled.prisons.PrisonCore;

import java.util.ArrayList;

public class WorldUnLoader implements Runnable{

    @Override
    public void run(){
        for(Level world : new ArrayList<>(PrisonCore.getInstance().getServer().getLevels().values())){
            boolean hasPlayers = false;
            for(Entity entity : world.getEntities()) {
                if(entity instanceof Player) {
                    hasPlayers = true;
                    break;
                }
            }
            if(!hasPlayers) {
                world.unload();
            }
        }
    }
}
