package fr.adslhouba.houbmod.proxy;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class CommonProxy {
	public void preInit(File configFile)
    {
        System.out.println("pre init côté commun");
    }

    public void init()
    {
        
    }
    
    public void registerItemTexture(Item item, int metadata, String name){}

    public void registerItemTexture(Item item, String name){}

    public void registerBlockTexture(Block block, int metadata, String name){}

    public void registerBlockTexture(Block block, String name){}
}
