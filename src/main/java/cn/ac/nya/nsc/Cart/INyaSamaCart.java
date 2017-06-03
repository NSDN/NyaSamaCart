package cn.ac.nya.nsc.Cart;

/**
 * Created by drzzm on 2017.4.30.
 */
public interface INyaSamaCart {

    public static final int CART_NAME = 29;
    public static final int CART_TEXT = 30;

    public String getData(int index);
    public void updateData(int index, String data);

}
