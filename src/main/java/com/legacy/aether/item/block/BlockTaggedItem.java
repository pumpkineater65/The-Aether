package com.legacy.aether.item.block;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

import java.util.Set;

public class BlockTaggedItem extends BlockItem {

    private Set<Tag<Item>> tags;

    @SafeVarargs
    public BlockTaggedItem(Block block, Settings settings, Tag<Item>... tags) {
        super(block, settings);

        this.tags = Sets.newHashSet(tags);
    }

}