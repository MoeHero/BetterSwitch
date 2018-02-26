package com.moehero.betterswitch;

import net.minecraftforge.fml.common.event.FMLInterModComms;

public class CommonProxy {
    public void loadModel(BlockSwitch blockSwitch) {}

    public void registerWaila() {
        FMLInterModComms.sendMessage("Waila", "register", "com.moehero.betterswitch.WailaHandler.callbackRegister");
    }
}
