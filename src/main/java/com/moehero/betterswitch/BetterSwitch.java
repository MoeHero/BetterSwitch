package com.moehero.betterswitch;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.logging.log4j.Logger;

@Mod(modid = BetterSwitch.MODID, name = BetterSwitch.NAME, version = BetterSwitch.VERSION, acceptedMinecraftVersions = "1.10.2")
public class BetterSwitch
{
    public static final String MODID = "betterswitch";
    public static final String NAME = "Better Switch";
    public static final String VERSION = "@VERSION@";

//    @Mod.Instance(MODID)
//    public static BetterSwitch instance;

    @SidedProxy(clientSide = "com.moehero.betterswitch.client.ClientProxy", serverSide = "com.moehero.betterswitch.CommonProxy")
    public static CommonProxy proxy;

    private static Logger logger;

//    public static Configuration config;
    public static String[] switchTypes = {"iron", "gold", "diamond", "emerald"};
    public static BlockSwitch[] blockSwitches = new BlockSwitch[switchTypes.length];


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        String[] materialName = {"ingotIron", "ingotGold", "gemDiamond", "gemEmerald"};
        int[] materialAmount = {2, 4, 16, 64};

        for(int i = 0; i < switchTypes.length; i++) {
            blockSwitches[i] = new BlockSwitch("switch_" + switchTypes[i]);

            GameRegistry.register(blockSwitches[i]);
            GameRegistry.register(new ItemBlock(blockSwitches[i]).setRegistryName(MODID, "switch_" + switchTypes[i]));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSwitches[i], materialAmount[i]),
                    "RMG", "MSM", "MMM",
                    'R', "dyeRed",
                    'G', "dyeGreen",
                    'S', Items.REDSTONE,
                    'M', materialName[i]
            ));

            proxy.loadModel(blockSwitches[i]);
            proxy.registerWaila();
        }
    }

    public static Logger logger() {
        return logger;
    }
}
