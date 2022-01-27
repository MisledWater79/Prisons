package com.misled.prisons.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerJoinEvent;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        event.getItem();
    }
    @EventHandler
    public void onJoinWorld(PlayerJoinEvent event){

        event.getPlayer().sendMessage("test");
    }
}
