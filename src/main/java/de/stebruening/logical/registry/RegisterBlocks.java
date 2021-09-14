package de.stebruening.logical.registry;

import de.stebruening.logical.Logical;
import de.stebruening.logical.blockentetiy.LogicCableInterfaceEntity;
import de.stebruening.logical.blocks.logic_cable.LogicCable;
import de.stebruening.logical.blocks.logic_cable.LogicCableInterface;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks
{
    //Logic Cable
    public static final LogicCable LOGIC_CABLE = new LogicCable(FabricBlockSettings.of(Material.STONE).hardness(4.0f).nonOpaque());

    //LogicCableInterface
    public static final LogicCableInterface LOGIC_CABLE_INTERFACE = new LogicCableInterface(FabricBlockSettings.of(Material.STONE).hardness(4.0f).nonOpaque());
    public static BlockEntityType<LogicCableInterfaceEntity> LOGIC_CABLE_INTERFACE_ENTITY;


    public static void registerBlocks()
    {
        //LogicCable
        Registry.register(Registry.BLOCK, new Identifier(Logical.MOD_ID,"logic_cable"),LOGIC_CABLE);
        Registry.register(Registry.ITEM, new Identifier(Logical.MOD_ID,"logic_cable"),new BlockItem(LOGIC_CABLE, new FabricItemSettings().group(Logical.ITEM_GROUP)));
        //LogicCableInterface
        Registry.register(Registry.BLOCK,new Identifier(Logical.MOD_ID,"logic_cable_interface"),LOGIC_CABLE_INTERFACE);
        Registry.register(Registry.ITEM, new Identifier(Logical.MOD_ID,"logic_cable_interface"), new BlockItem(LOGIC_CABLE_INTERFACE,new FabricItemSettings().group(Logical.ITEM_GROUP)));
        LOGIC_CABLE_INTERFACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,Logical.MOD_ID+":logic_cable_interface_entity",BlockEntityType.Builder.create(LogicCableInterfaceEntity::new,LOGIC_CABLE_INTERFACE).build(null));
    }

}
