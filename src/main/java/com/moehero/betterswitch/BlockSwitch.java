package com.moehero.betterswitch;

import net.minecraft.block.BlockLever;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSwitch extends BlockLever {
    protected static final AxisAlignedBB SWITCH_UP = new AxisAlignedBB(0.375, 0, 0.375, 0.625, 0.125, 0.625);
    protected static final AxisAlignedBB SWITCH_DOWN = new AxisAlignedBB(0.375, 0.875, 0.375, 0.625, 1, 0.625);
    protected static final AxisAlignedBB SWITCH_NORTH = new AxisAlignedBB(0.375, 0.375, 0.875, 0.625, 0.625, 1);
    protected static final AxisAlignedBB SWITCH_SOUTH = new AxisAlignedBB(0.375, 0.375, 0, 0.625, 0.625, 0.125);
    protected static final AxisAlignedBB SWITCH_WEST = new AxisAlignedBB(0.875, 0.375, 0.375, 1, 0.625, 0.625);
    protected static final AxisAlignedBB SWITCH_EAST = new AxisAlignedBB(0, 0.375, 0.375, 0.125, 0.625, 0.625);

    public BlockSwitch(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(BetterSwitch.MODID, name);

        this.setSoundType(SoundType.METAL);
        this.setHardness(0.5F);
        this.setHarvestLevel("pickaxe", -1);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch(state.getValue(FACING)) {
            case EAST:
            default:
                return SWITCH_EAST;
            case WEST:
                return SWITCH_WEST;
            case SOUTH:
                return SWITCH_SOUTH;
            case NORTH:
                return SWITCH_NORTH;
            case UP_Z:
            case UP_X:
                return SWITCH_UP;
            case DOWN_X:
            case DOWN_Z:
                return SWITCH_DOWN;
        }
    }
}
