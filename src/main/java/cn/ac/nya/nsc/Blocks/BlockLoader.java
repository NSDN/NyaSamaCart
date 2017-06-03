package cn.ac.nya.nsc.Blocks;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.*;

/**
 * Created by drzzm on 2017.4.25.
 */
public class BlockLoader {

    public static LinkedHashMap<String, Block> blocks;

    private static void register(Block block, String name) {
        GameRegistry.registerBlock(block, name);
    }

    public BlockLoader(FMLPreInitializationEvent event) {
        blocks = new LinkedHashMap<String, Block>();

        blocks.put("nsc_logo", new BlockLogo());

        for (String block : blocks.keySet()) {
            register(blocks.get(block), block);
        }

    }

}