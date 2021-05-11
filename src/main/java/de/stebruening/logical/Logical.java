package de.stebruening.logical;

import de.stebruening.logical.blocks.logic_cable.LogicCable;
import de.stebruening.logical.registry.RegisterBlocks;
import de.stebruening.logical.registry.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Logical implements ModInitializer
{
    public static final String MOD_ID = "logical";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("logical","locgical"),() -> new ItemStack(Items.REDSTONE));

    @Override
    public void onInitialize()
    {
        RegisterBlocks.registerBlocks();
        RegisterItems.registerItems();
    }
}
