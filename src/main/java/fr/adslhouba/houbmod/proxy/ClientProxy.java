package fr.adslhouba.houbmod.proxy;

import fr.adslhouba.houbmod.common.HoubMod;
import fr.adslhouba.houbmod.common.entity.EntityProjectil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
    public void preInit(File configFile)
    {
        // TODO Auto-generated method stub
        super.preInit(configFile);
        
    }

    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        super.init();
        //RenderingRegistry.registerEntityRenderingHandler(EntityProjectil.class, new RenderSnowball(HoubMod.projectil));
    }
    
    @Override
    public void registerItemTexture(Item item, int metadata, String name)
    {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation("houbmod:" + name, "inventory"));
    }
    
    @Override
    public void registerItemTexture(Item item, String name)
    {
        registerItemTexture(item, 0, name);
    }
    
    @Override
    public void registerBlockTexture(Block block, int metadata, String name)
    {
        registerItemTexture(Item.getItemFromBlock(block), metadata, name);
    }
    
    @Override
    public void registerBlockTexture(Block block, String name)
    {
        registerBlockTexture(block, 0, name);
    }
}
