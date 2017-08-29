package cn.ac.nya.nsc.Cart;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class CartModelBinder {

    public static void loadRenderer(FMLInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                AnchorCart.class, new CartRenderer(new CartModel()));

        RenderingRegistry.registerEntityRenderingHandler(
                Cart.class, new CartRenderer(new CartModel()));
    }

}
