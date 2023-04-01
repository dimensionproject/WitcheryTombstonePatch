package com.vova7865.witcherytombstonepatch;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, acceptableRemoteVersions = "*", dependencies = "required-after:witchery;required-after:tombstone")
public class Main {
    public static final String MODID = "witcherytombstonepatch";
    public static final String NAME = "Witchery Tombstone Patch";
    public static final String VERSION = "0.1";

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RestoreInventoryEventHandler());
    }
}
