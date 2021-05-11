package de.stebruening.logical.registry;

import de.stebruening.logical.Logical;
import de.stebruening.logical.items.Wrench;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems
{
    public static final Wrench WRENCH = new Wrench(new FabricItemSettings().group(Logical.ITEM_GROUP).maxCount(1));

    public static void registerItems()
    {
        Registry.register(Registry.ITEM,new Identifier(Logical.MOD_ID,"wrench"),WRENCH);
    }

}
