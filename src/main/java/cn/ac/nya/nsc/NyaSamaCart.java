package cn.ac.nya.nsc;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cn.ac.nya.nsc.Proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by drzzm on 2017.4.25.
 */
@Mod(modid = NyaSamaCart.MODID, version = NyaSamaCart.VERSION)
public class NyaSamaCart {

    @Mod.Instance("NyaSamaCart")
    public static NyaSamaCart instance;
    public static final String MODID = "NyaSamaCart";
    public static final String VERSION = "1.0";
    public static final boolean isDebug = false;
    public static Logger log = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "cn.ac.nya.nsc.Proxy.ClientProxy",
                serverSide = "cn.ac.nya.nsc.Proxy.ServerProxy")
    public static CommonProxy proxy;

    public static NyaSamaCart getInstance() { return instance; }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

}
