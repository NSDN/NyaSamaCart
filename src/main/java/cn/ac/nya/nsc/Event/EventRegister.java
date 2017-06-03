package cn.ac.nya.nsc.Event;

import cn.ac.nya.nsc.NyaSamaCart;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by drzzm on 2017.4.25.
 */
public class EventRegister {

    public static void registerCommon() {
        ForgeChunkManager.setForcedChunkLoadingCallback(NyaSamaCart.getInstance(), ChunkLoaderHandler.instance());
        MinecraftForge.EVENT_BUS.register(ChunkLoaderHandler.instance());
    }

    public static void registerServer() {  }

    public static void registerClient() { FMLCommonHandler.instance().bus().register(ClientTickHandler.instance()); }

}
