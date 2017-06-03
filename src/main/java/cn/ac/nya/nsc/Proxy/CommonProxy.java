package cn.ac.nya.nsc.Proxy;

import cn.ac.nya.nsc.Cart.CartLoader;
import cn.ac.nya.nsc.CreativeTab.CreativeTabLoader;
import cn.ac.nya.nsc.Event.EventRegister;
import cpw.mods.fml.common.event.*;
import cn.ac.nya.nsc.Blocks.BlockLoader;

/**
 * Created by drzzm on 2017.4.25.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        new CreativeTabLoader(event);
        CartLoader.loadItem(event);
        new BlockLoader(event);
    }

    public void init(FMLInitializationEvent event) {
        CartLoader.loadEntity(event);
        EventRegister.registerCommon();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
