package com.misled.prisons;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.scheduler.ServerScheduler;
import cn.nukkit.utils.TextFormat;
import com.misled.prisons.commands.blockTrail;
import com.misled.prisons.commands.worldTp;
import com.misled.prisons.events.cowEvents;
import com.misled.prisons.events.playerEvents;
import com.misled.prisons.tasks.cowSpawner;

public class PrisonCore extends PluginBase {

    public static PrisonCore plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.getLogger().info(TextFormat.GREEN + "Prison Plugin Enabled");
        registerCommands();
        registerEvents();
        registerTasks();
    }

    public void registerEvents(){
        PluginManager pM = getServer().getPluginManager();
        pM.registerEvents(new cowEvents(), this);
        pM.registerEvents(new playerEvents(), this);
    }

    public void registerTasks(){
        ServerScheduler sS = getServer().getScheduler();
        sS.scheduleRepeatingTask(this,new cowSpawner(),40);
    }

    public void registerCommands(){
        SimpleCommandMap cM = this.getServer().getCommandMap();
        cM.register("bt",new blockTrail());
        cM.register("worldTp",new worldTp());
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.RED + "Prison Plugin Disabled");
    }

    public static PrisonCore getInstance() {
        return plugin;
    }

}
