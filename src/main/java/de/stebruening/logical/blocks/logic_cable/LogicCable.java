package de.stebruening.logical.blocks.logic_cable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;
import java.util.List;


public class LogicCable extends Block
{

    public static final BooleanProperty EAST = BooleanProperty.of("east");
    public static final BooleanProperty WEST = BooleanProperty.of("west");
    public static final BooleanProperty NORTH = BooleanProperty.of("north");
    public static final BooleanProperty SOUTH = BooleanProperty.of("south");
    public static final BooleanProperty UP = BooleanProperty.of("up");
    public static final BooleanProperty DOWN = BooleanProperty.of("down");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
    {
        stateManager.add(EAST, WEST, NORTH, SOUTH, UP, DOWN);
    }


    public LogicCable(Settings settings)
    {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(EAST, false).with(WEST, false).with(NORTH, false)
                .with(SOUTH, false).with(UP, false).with(DOWN, false));
    }



    private BlockState makeConnections(World world, BlockPos pos)
    {
        Boolean down = canConnectTo(world, pos.down());
        Boolean up = canConnectTo(world, pos.up());
        Boolean north = canConnectTo(world, pos.north());
        Boolean east = canConnectTo(world, pos.east());
        Boolean south = canConnectTo(world, pos.south());
        Boolean west = canConnectTo(world, pos.west());

        return this.getDefaultState().with(DOWN, down).with(UP, up).with(NORTH, north).with(EAST, east)
                .with(SOUTH, south).with(WEST, west);
    }


    private Boolean canConnectTo(WorldAccess world, BlockPos pos)
    {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof LogicCable)
        {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //Updates the Blockstate when Cable is placed
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return makeConnections(context.getWorld(), context.getBlockPos());
    }

    //Updates the Neighbours of the Cable
    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(BlockState ourState, Direction ourFacing, BlockState otherState,
                                                WorldAccess worldIn, BlockPos ourPos, BlockPos otherPos) {

        Boolean value = canConnectTo(worldIn, otherPos);
        return ourState.with(getProperty(ourFacing), value);
    }

    public BooleanProperty getProperty(Direction facing) {
        switch (facing) {
            case WEST:
                return WEST;
            case NORTH:
                return NORTH;
            case SOUTH:
                return SOUTH;
            case UP:
                return UP;
            case DOWN:
                return DOWN;
            default:
                return EAST;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext shapeContext) {

        final double size = 6;

        final List<VoxelShape> connections = new ArrayList<>();
        final VoxelShape baseShape = Block.createCuboidShape(size, size, size, 16.0D - size, 16.0D - size, 16.0D - size);

        for(Direction dir : Direction.values())
        {
            if(state.get(getProperty(dir)))
            {
                double x = dir == Direction.WEST ? 0 : dir == Direction.EAST ? 16D : size;
                double z = dir == Direction.NORTH ? 0 : dir == Direction.SOUTH ? 16D : size;
                double y = dir == Direction.DOWN ? 0 : dir == Direction.UP ? 16D : size;

                VoxelShape shape = Block.createCuboidShape(x, y, z, 16.0D - size, 16.0D - size, 16.0D - size);
                connections.add(shape);
            }
        }


        return VoxelShapes.union(baseShape, connections.toArray(new VoxelShape[]{}));
    }



}
