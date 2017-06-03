package cn.ac.nya.nsc.Cart;

import cn.ac.nya.nsasm.NSASM;
import cn.ac.nya.nsasm.Util;
import cn.ac.nya.nsc.NyaSamaCart;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by drzzm on 2017.4.30.
 */
public class CartLoader {

    public static class CartInfo {
        public boolean isAnchor;
        public String cartName;
        public String cartIcon;
        public String cartTexture;

        public CartInfo(int isAnchor, String cartName, String cartIcon, String cartTexture) {
            this.isAnchor = isAnchor > 0;
            this.cartName = cartName;
            this.cartIcon = cartIcon;
            this.cartTexture = cartTexture;
        }
    }

    public static LinkedList<CartInfo> infos;
    public static LinkedHashMap<String, Item> itemCarts;

    public static void loadEntity(FMLInitializationEvent event) {
        EntityRegistry.registerModEntity(
                AnchorCart.class,
                "AnchorCart",
                2223,
                NyaSamaCart.getInstance(), 256, 3, true);

        EntityRegistry.registerModEntity(
                Cart.class,
                "Cart",
                2224,
                NyaSamaCart.getInstance(), 256, 3, true);
    }

    public static void loadRenderer(FMLInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                AnchorCart.class, new CartRenderer(new CartModel()));

        RenderingRegistry.registerEntityRenderingHandler(
                Cart.class, new CartRenderer(new CartModel()));
    }

    private static void register(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

    public static void loadItem(FMLPreInitializationEvent event) {
        infos = new LinkedList<CartInfo>();
        itemCarts = new LinkedHashMap<String, Item>();

        String[][] code = Util.getSegments(Util.read("config/config.ns"));
        ModNSASM nsasm = new ModNSASM(code);

        Util.print("\n\nNyaSama Assembly Script Module\n");
        Util.print("Version: ");
        Util.print(ModNSASM.version);
        Util.print("\n\n");
        nsasm.run();
        Util.print("\nNSASM running finished.\n\n");

        for (CartInfo i : infos) {
            if (i.isAnchor) {
                itemCarts.put(i.cartName, new ItemAnchorCart(i.cartName, i.cartIcon, i.cartTexture));
            } else {
                itemCarts.put(i.cartName, new ItemCart(i.cartName, i.cartIcon, i.cartTexture));
            }
            register(itemCarts.get(i.cartName), i.cartIcon);
        }

    }

}
