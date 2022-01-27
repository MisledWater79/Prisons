package com.misled.prisons;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.scheduler.ServerScheduler;
import cn.nukkit.utils.TextFormat;
import com.misled.prisons.commands.SpawnerEnable;
import com.misled.prisons.commands.BlockTrail;
import com.misled.prisons.commands.WarpCommand;
import com.misled.prisons.events.CowEvents;
import com.misled.prisons.events.PlayerEvents;
import com.misled.prisons.tasks.CowSpawner;
import com.misled.prisons.tasks.EntityKiller;
import com.misled.prisons.tasks.WorldUnLoader;

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
        pM.registerEvents(new CowEvents(), this);
        pM.registerEvents(new PlayerEvents(), this);
    }

    public void registerTasks(){
        ServerScheduler sS = getServer().getScheduler();
        sS.scheduleRepeatingTask(this,new CowSpawner(),40);
        sS.scheduleRepeatingTask(this,new WorldUnLoader(),40);
        sS.scheduleRepeatingTask(this,new EntityKiller(),40);
    }

    public void registerCommands(){
        SimpleCommandMap cM = this.getServer().getCommandMap();
        cM.register("bt",new BlockTrail());
        cM.register("warp",new WarpCommand());
        cM.register("spawnerEnable",new SpawnerEnable());
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.RED + "Prison Plugin Disabled");
    }

    public static PrisonCore getInstance() {
        return plugin;
    }

}
