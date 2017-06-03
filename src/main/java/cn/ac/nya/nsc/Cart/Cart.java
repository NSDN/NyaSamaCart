package cn.ac.nya.nsc.Cart;

import cn.ac.nya.nsc.NyaSamaCart;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by drzzm on 2017.4.30.
 */
public class Cart extends EntityMinecartEmpty implements INyaSamaCart {

    public Cart(World world) {
        super(world);
        getDataWatcher().addObject(CART_NAME, "");
        getDataWatcher().addObject(CART_TEXT, "");
    }

    public Cart(World world, double x, double y, double z) {
        super(world, x, y, z);
        getDataWatcher().addObject(CART_NAME, "");
        getDataWatcher().addObject(CART_TEXT, "");
    }

    public Cart(World world, double x, double y, double z, String name, String texture) {
        super(world, x, y, z);
        getDataWatcher().addObject(CART_NAME, name);
        getDataWatcher().addObject(CART_TEXT, texture);
    }

    public String getData(int index) {
        return getDataWatcher().getWatchableObjectString(index);
    }

    public void updateData(int index, String data) {
        getDataWatcher().updateObject(index, data);
    }

    @Override
    public int getMinecartType() {
        return -1;
    }

    @Override
    public double getMountedYOffset() {
        return -0.1;
    }

    @Override
    public float getMaxCartSpeedOnRail() {
        return 1.0F;
    }

    @Override
    public void killMinecart(DamageSource source) {
        this.setDead();
        if (!CartLoader.itemCarts.containsKey(getData(CART_NAME))) return;
        ItemStack itemstack = new ItemStack(CartLoader.itemCarts.get(getData(CART_NAME)), 1);
        itemstack.setStackDisplayName(itemstack.getDisplayName());
        this.entityDropItem(itemstack, 0.0F);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        updateData(CART_NAME, tagCompound.getString("cartName"));
        updateData(CART_TEXT, tagCompound.getString("cartTexture"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setString("cartName", getData(CART_NAME));
        tagCompound.setString("cartTexture", getData(CART_TEXT));
    }

}
