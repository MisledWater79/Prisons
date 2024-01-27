package com.misled.prisons.blocks;

import cn.nukkit.block.Block;
import cn.nukkit.block.customblock.CustomBlock;
import cn.nukkit.block.customblock.CustomBlockDefinition;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemTool;
import com.misled.prisons.items.LeadChunk;
import org.jetbrains.annotations.NotNull;

public class LeadBlock extends Block implements CustomBlock {

    public static int ID;

    @Override
    public String getName() {
        return "Lead Ore";
    }

    @NotNull
    @Override
    public String getNamespaceId() {
        return "madblock:lead_ore";
    }

    @Override
    public CustomBlockDefinition getDefinition() {
        return CustomBlockDefinition.builder(this, "lead_ore").build();
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{new LeadChunk()};
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getId() {
        ID = CustomBlock.super.getId();
        return ID;
    }

}