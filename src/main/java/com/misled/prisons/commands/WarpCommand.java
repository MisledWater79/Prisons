package com.misled.prisons.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.level.Position;
import cn.nukkit.utils.TextFormat;
import com.misled.prisons.PrisonCore;

import static com.misled.prisons.utils.PluginValues.*;

public class WarpCommand extends Command {

    public WarpCommand(){
        super("warp");
        this.setDescription("Allows you to warp to different areas!");
        commandParameters.clear();
        commandParameters.put("default",new CommandParameter[]{
                CommandParameter.newType("place", CommandParamType.STRING)
        });
        commandParameters.put("byString",new CommandParameter[]{
                CommandParameter.newEnum("place",new String[]{"ward-a","ward-b","ward-c","ward-d","hub"})
        });
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        if (!sender.isPlayer()){
            sender.sendMessage(TextFormat.RED + "You need to be a player to run this command.");
            return false;
        }
        if(args.length == 0){
            sender.sendMessage(TextFormat.RED + "You need to specify a region to warp to.");
            return false;
        }
        if(args.length > 1){
            sender.sendMessage(TextFormat.RED + "You can only specify one region to warp to.");
            return false;
        }
        Player player = (Player) sender;
        switch (args[0]){
            case "ward-a":
                PrisonCore.getInstance().getServer().loadLevel("ward-a");
                player.teleport(new Position(WARD_A_CORDS.x,WARD_A_CORDS.y,WARD_A_CORDS.z,PrisonCore.getInstance().getServer().getLevelByName("ward-a")));
                break;
            case "ward-b":
                PrisonCore.getInstance().getServer().loadLevel("ward-b");
                player.teleport(new Position(WARD_B_CORDS.x,WARD_B_CORDS.y,WARD_B_CORDS.z,PrisonCore.getInstance().getServer().getLevelByName("ward-b")));
                break;
            case "ward-c":
                PrisonCore.getInstance().getServer().loadLevel("ward-c");
                player.teleport(new Position(WARD_C_CORDS.x,WARD_C_CORDS.y,WARD_C_CORDS.z,PrisonCore.getInstance().getServer().getLevelByName("ward-c")));
                break;
            case "ward-d":
                PrisonCore.getInstance().getServer().loadLevel("ward-d");
                player.teleport(new Position(WARD_D_CORDS.x,WARD_D_CORDS.y,WARD_D_CORDS.z,PrisonCore.getInstance().getServer().getLevelByName("ward-d")));
                break;
            case "hub":
                PrisonCore.getInstance().getServer().loadLevel("world");
                player.teleport(new Position(0,80,0,PrisonCore.getInstance().getServer().getLevelByName("world")));
                break;
            default:
                player.sendMessage(TextFormat.RED + "That isn't a acceptable warp area.");
                break;
        }
        return true;
    }
}
