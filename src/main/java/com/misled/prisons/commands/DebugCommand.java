package com.misled.prisons.commands;


import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.misled.prisons.blocks.LeadBlock;
import com.misled.prisons.items.LeadChunk;

public class DebugCommand extends Command {
    public DebugCommand(){
        super("debug");
        this.setDescription("Debug for quick testing!");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        sender.asPlayer().getInventory().addItem(new LeadChunk());
        sender.asPlayer().getInventory().addItem(new LeadBlock().toItem());
        return true;
    }
}
