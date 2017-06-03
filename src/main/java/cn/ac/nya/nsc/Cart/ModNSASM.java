package cn.ac.nya.nsc.Cart;

import cn.ac.nya.nsasm.NSASM;

/**
 * Created by drzzm on 2017.4.30.
 */
public class ModNSASM extends NSASM {

    public ModNSASM(String[][] code) {
        super(32, 16, 16, code);
    }

    @Override
    protected void loadFunList() {
        super.loadFunList();

        funList.put("cart", (dst, src) -> {
            if (dst != null) return NSASM.Result.ERR;
            if (src != null) return NSASM.Result.ERR;

            if (CartLoader.infos == null) return NSASM.Result.ERR;

            CartLoader.infos.add(new CartLoader.CartInfo(
                    Integer.valueOf(regGroup[0].data.toString()),
                    regGroup[1].data.toString(),
                    regGroup[2].data.toString(),
                    regGroup[3].data.toString()
            ));

            return NSASM.Result.OK;
        });
    }

}
