package cn.ac.nya.nsc.Cart;

import cn.ac.nya.nsc.CreativeTab.CreativeTabLoader;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;

/**
 * Created by drzzm on 2017.4.30.
 */
public class ItemAnchorCart extends ItemMinecart {

    public String cartName;
    public String cartTexture;

    public ItemAnchorCart() {
        super(-1);
        setUnlocalizedName("ItemAnchorCart");
        setTextureName("nsc" + ":" + "item_anchor_cart");
        setMaxStackSize(64);
        setCreativeTab(CreativeTabLoader.tabNSC);
    }

    public ItemAnchorCart(String name, String icon, String texture) {
        super(-1);
        cartName = name;
        setUnlocalizedName(cartName);
        setTextureName("nsc" + ":" + icon);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabLoader.tabNSC);
        cartTexture = texture;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz) {
        if (BlockRailBase.func_150051_a(world.getBlock(x, y, z))) {
            if (!world.isRemote) {
                AnchorCart cart = new AnchorCart(world, (double) x + 0.5, (double) y + 0.5, (double) z + 0.5, cartName, cartTexture);

                if (itemStack.hasDisplayName()) {
                    cart.setMinecartName(itemStack.getDisplayName());
                }

                world.spawnEntityInWorld(cart);
            }

            --itemStack.stackSize;
            return true;
        } else {
            return false;
        }
    }
}
