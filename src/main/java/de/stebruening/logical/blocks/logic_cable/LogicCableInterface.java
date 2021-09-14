package de.stebruening.logical.blocks.logic_cable;

import de.stebruening.logical.blockentetiy.LogicCableInterfaceEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;


public class LogicCableInterface extends LogicCable implements BlockEntityProvider
{

    public LogicCableInterface(Settings settings)
    {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world)
    {
        return new LogicCableInterfaceEntity();
    }


}
