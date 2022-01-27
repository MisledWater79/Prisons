package com.misled.prisons.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;

import static com.misled.prisons.utils.PluginValues.cowsEnabled;

public class SpawnerEnable extends Command {

    public SpawnerEnable(){
        super("spawnerEnable");
        this.setDescription("Turn on or off Spawners");
        commandParameters.clear();
        commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newType("Type", CommandParamType.STRING)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        if(!sender.isOp()) return true;
        if(args[0].equals("cows")){
            cowsEnabled = !cowsEnabled;
        }
        return true;
    }
}
