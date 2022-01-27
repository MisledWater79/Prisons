package com.misled.prisons.tasks;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.Level;
import com.misled.prisons.PrisonCore;

import java.util.ArrayList;

public class EntityKiller implements Runnable{

    @Override
    public void run(){
        int entityCount = 0;
        for(Level world : new ArrayList<>(PrisonCore.getInstance().getServer().getLevels().values())){
            for(Entity entity : world.getEntities()) {
                if(!(entity instanceof Player)) {
                    entityCount++;
                }
            }
        }
        if(entityCount > 150){
            PrisonCore.getInstance().getServer().getCommandMap().dispatch(PrisonCore.getInstance().getServer().getConsoleSender(),"kill @e");
            PrisonCore.getInstance().getServer().getCommandMap().dispatch(PrisonCore.getInstance().getServer().getConsoleSender(),"say Entity Cap has been hit, killed all entities.");
        }
    }
}
