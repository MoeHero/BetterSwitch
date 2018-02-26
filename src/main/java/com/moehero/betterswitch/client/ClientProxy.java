package com.moehero.betterswitch.client;

import com.moehero.betterswitch.BlockSwitch;
import com.moehero.betterswitch.CommonProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    @Override
    public void loadModel(BlockSwitch blockSwitch) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockSwitch), 0, new ModelResourceLocation(blockSwitch.getRegistryName(), "inventory"));
    }
}
