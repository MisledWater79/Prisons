package com.misled.prisons.commands;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.GlobalBlockPalette;
import cn.nukkit.network.protocol.UpdateBlockPacket;
import cn.nukkit.utils.TextFormat;
import com.misled.prisons.PrisonCore;

public class blockTrail extends Command {

    public blockTrail(){
        super("bt");
        this.setDescription("Puts a block trail above you");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        if(!sender.isPlayer()){
            sender.sendMessage(TextFormat.RED + "You are not a player!");
            return false;
        }
        Player player = (Player)sender;
        PrisonCore.getInstance().getServer().dispatchCommand(sender,"give @s dirt");
        UpdateBlockPacket updateBlockPacket = new UpdateBlockPacket();
        updateBlockPacket.x = player.getLocation().getFloorX();
        updateBlockPacket.y = player.getLocation().getFloorY() + 2;
        updateBlockPacket.z = player.getLocation().getFloorZ();
        updateBlockPacket.blockRuntimeId = GlobalBlockPalette.getOrCreateRuntimeId(BlockID.CONCRETE, 5);
        updateBlockPacket.encode();
        player.dataPacket(updateBlockPacket);
        return false;
    }

}
