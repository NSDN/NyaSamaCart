package cn.ac.nya.nsc.Proxy;

import cn.ac.nya.nsc.Cart.CartModelBinder;
import cn.ac.nya.nsc.Event.EventRegister;
import cpw.mods.fml.common.event.*;

/**
 * Created by drzzm on 2017.4.25.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        CartModelBinder.loadRenderer(event);
        EventRegister.registerClient();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) { super.postInit(event); }


}
