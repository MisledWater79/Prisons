package com.misled.prisons.events;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.passive.EntityCow;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDeathEvent;

public class CowEvents implements Listener {
    @EventHandler
    public void onKill(EntityDeathEvent event){
        Entity killed = event.getEntity();
        if(killed instanceof EntityCow){
            if(killed.namedTag.getInt("Cows") > 0){
                killed.namedTag.putInt("Cows",killed.namedTag.getInt("Cows")-1);
                killed.setNameTag("Cow x"+killed.namedTag.getInt("Cows"));
                killed.setHealth(10);
            }
        }
    }
    @EventHandler
    public void onHurt(EntityDamageByEntityEvent event){
        Entity damaged = event.getEntity();
        if(damaged.getName().equals("Cow")){
            if(damaged.namedTag.getInt("Cows") == 0) {
                event.setCancelled(true);
            }
        }
    }
}
