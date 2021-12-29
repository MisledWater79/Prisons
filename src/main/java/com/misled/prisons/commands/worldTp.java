package com.misled.prisons.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Position;
import cn.nukkit.utils.TextFormat;
import com.misled.prisons.PrisonCore;

public class worldTp extends Command {

    public worldTp(){
        super("worldTp");
        this.setDescription("Teleports you to other worlds");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        if(!sender.isPlayer()){
            sender.sendMessage(TextFormat.RED + "You are not a Player!");
            return false;
        }
        if(!sender.isOp()){
            sender.sendMessage(TextFormat.RED + "You do not have proper permissions to run this command!");
            return false;
        }
        Player player = (Player) sender;
        try {
            PrisonCore.getInstance().getServer().loadLevel(args[0]);
            player.teleport(new Position(0, 80, 0, PrisonCore.getInstance().getServer().getLevelByName(args[0])));
        } catch(Exception e) {
            player.sendMessage(TextFormat.RED + args[0] + " is not a world. Please input a proper world!");
        }
        return false;
    }
}
