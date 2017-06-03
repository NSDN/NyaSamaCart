package cn.ac.nya.nsc.CreativeTab;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.event.*;
import net.minecraft.creativetab.CreativeTabs;
import cn.ac.nya.nsc.Blocks.BlockLoader;

/**
 * Created by drzzm on 2017.4.25.
 */
public class CreativeTabLoader {

    public static CreativeTabs tabNSC;

    public CreativeTabLoader(FMLPreInitializationEvent event) {
        tabNSC = new CreativeTabs("tabNSC") {
            @Override
            public Item getTabIconItem() {
                Block logo = BlockLoader.blocks.get("nsc_logo");
                return Item.getItemFromBlock(logo);
            }
        };
    }

}
