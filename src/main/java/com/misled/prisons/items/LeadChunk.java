package com.misled.prisons.items;


import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.ItemCustom;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;

public class LeadChunk extends ItemCustom {

    public static int ID;
    public static final String NAMESPACE_ID = "madblock:lead_chunk";

    public LeadChunk() {
        super(NAMESPACE_ID, "Lead Chunk", "lead_chunk");
        ID = this.getId();
    }

    @Override
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition.simpleBuilder(this, ItemCreativeCategory.ITEMS).build();
    }
}