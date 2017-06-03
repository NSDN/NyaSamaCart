package cn.ac.nya.nsc.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cn.ac.nya.nsc.CreativeTab.CreativeTabLoader;

/**
 * Created by drzzm on 2017.4.25.
 */
public class BlockLogo extends Block {

    public BlockLogo() {
        super(Material.glass);
        setBlockName("NyaSamaCartLogo");
        setBlockTextureName("nsc:logo");
        setHardness(0.5F);
        setLightLevel(1);
        setStepSound(Block.soundTypeGlass);
        setResistance(1.0F);
        setCreativeTab(CreativeTabLoader.tabNSC);
    }

}
