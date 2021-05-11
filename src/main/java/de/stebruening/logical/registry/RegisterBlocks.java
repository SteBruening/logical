package de.stebruening.logical.registry;

import de.stebruening.logical.Logical;
import de.stebruening.logical.blocks.logic_cable.LogicCable;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks
{
    public static final LogicCable LOGIC_CABLE = new LogicCable(FabricBlockSettings.of(Material.STONE).hardness(4.0f).nonOpaque());

    public static void registerBlocks()
    {
        Registry.register(Registry.BLOCK, new Identifier(Logical.MOD_ID,"logic_cable"),LOGIC_CABLE);
        Registry.register(Registry.ITEM, new Identifier(Logical.MOD_ID,"logic_cable"),new BlockItem(LOGIC_CABLE, new FabricItemSettings().group(Logical.ITEM_GROUP)));
    }

}
