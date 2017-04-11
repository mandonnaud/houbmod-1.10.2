package fr.adslhouba.houbmod.common;

import org.apache.logging.log4j.Logger;

import fr.adslhouba.houbmod.common.block.turtlerally.*;
import fr.adslhouba.houbmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = HoubMod.MODID, name = "HoubMod", version = "1.3.0", acceptedMinecraftVersions = "[1.10.2]")

public class HoubMod {
	public static final String MODID = "houbmod";

	@Instance(HoubMod.MODID)
	public static HoubMod instance;
	
	public static CreativeTabs HoubModCreativeTabs = new CreativeTabs("houb_tabs")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(HoubMod.tr_plaque);
        }

        @SideOnly(Side.CLIENT)
        public int func_151243_f()
        {
             return 0; // mettez ici votre metadata
        }
    };
    @SidedProxy(clientSide = "fr.adslhouba.houbmod.proxy.ClientProxy", serverSide = "fr.adslhouba.houbmod.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public static Block trPlaque, tr_plaque, trTapisDroite, trTapisGauche, genLaser, ccMaj;
	public static Item projectil, itemMaj;
    
	public static Logger logger;
	
    @EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
    	logger = event.getModLog(); // initialise le logger.  event.getModLog() retourne un logger avec votre modid
    	proxy.preInit(event.getSuggestedConfigurationFile());
    	
    	tr_plaque = new BlockTRPlaque();
		GameRegistry.registerBlock(tr_plaque, "tr_plaque");
		//GameRegistry.registerBlock(trPlaque,BlockTRPlaqueItem.class,"trplaque", MODID, new Object[]{BlockTRPlaque.subBlock});
		
		/*
		trTapis = new BlockTRTapis().setUnlocalizedName("trtapis");
		GameRegistry.registerBlock(trTapis,BlockTRTapisItem.class,"trtapis");
		
		trTapisDroite = new BlockTRTapisDroite().setUnlocalizedName("trtapisdroite");
		GameRegistry.registerBlock(trTapisDroite,BlockTRTapisItem.class,"trtapisdroite");
		
		trTapisGauche = new BlockTRTapisGauche().setUnlocalizedName("trtapisgauche");
		GameRegistry.registerBlock(trTapisGauche,BlockTRTapisItem.class,"trtapisgauche");
		
		genLaser = new BlockGenLaser();
		GameRegistry.registerBlock(genLaser, "genLaser");
		proxy.registerBlockTexture(genLaser,"genlaser");
		
		projectil = new ItemProjectil().setUnlocalizedName("itemHbProjectil");
		GameRegistry.registerItem(projectil, "projectil");
		proxy.registerItemTexture(projectil, "projectil");
		
		ccMaj = new blockMaj();
		GameRegistry.registerBlock(ccMaj, "ccUpgrader");
		*/
		
		/*
		itemMaj = new itemMaj().setUnlocalizedName("itemHbMaj").setTextureName(HoubMod.MODID + ":maj").setCreativeTab(HoubMod.HoubModCreativeTabs);
		GameRegistry.registerItem(itemMaj, "CC_maj");
		*/
		
		
/*
		GameRegistry.registerTileEntity(TileEntityGenLaser.class, "houbmod:genlaserentity");
		GameRegistry.registerTileEntity(TileEntityMaj.class, "houbmod:tileEntityMaj");
		EntityRegistry.registerModEntity(EntityProjectil.class, "tire", 0, this, 32, 1, false);
		*/
		//event.getModConfigurationDirectory(),
		
		//majApi.init(event.getModConfigurationDirectory());
		
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.init();
		proxy.registerBlockTexture(tr_plaque, "tr_plaque");
		
		//ComputerCraftAPI.registerPeripheralProvider(new houbPeripheral.Provider());

		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandlerMaj());
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//GameRegistry.addRecipe(new ItemStack(trTapis, 9, 0), new Object[] {"XXX", "YYY", "   ", 'X', new ItemStack(Blocks.WOOL, 1, 1), 'Y',new ItemStack(Blocks.WOOL, 1, 15)});
		//GameRegistry.addRecipe(new ItemStack(trTapisGauche, 9, 0), new Object[] {"YXX", "YYY", "   ", 'X', new ItemStack(Blocks.WOOL, 1, 1), 'Y',new ItemStack(Blocks.WOOL, 1, 15)});
		//GameRegistry.addRecipe(new ItemStack(trTapisDroite, 9, 0), new Object[] {"YYX", "YYY", "   ", 'X', new ItemStack(Blocks.WOOL, 1, 1), 'Y',new ItemStack(Blocks.WOOL, 1, 15)});
		
		GameRegistry.addRecipe(new ItemStack(tr_plaque, 9, 0), new Object[] {"YXY", "YYY", "   ", 'X', new ItemStack(Blocks.WOOL, 1, 11), 'Y',new ItemStack(Blocks.WOOL, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(tr_plaque, 9, 1), new Object[] {"YXY", "YYY", "   ", 'X', new ItemStack(Blocks.WOOL, 1, 14), 'Y',new ItemStack(Blocks.WOOL, 1, 8)});
		
		GameRegistry.addRecipe(new ItemStack(tr_plaque, 1, 1), new Object[] {"X ", "  ", 'X', new ItemStack(tr_plaque, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(tr_plaque, 1, 0), new Object[] {"X ", "  ", 'X', new ItemStack(tr_plaque, 1, 1)});
		/*
		GameRegistry.addRecipe(new ItemStack(trTapis, 1, 0), new Object[] {"X ", "  ", 'X', new ItemStack(trTapisDroite, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(trTapisDroite, 1, 0), new Object[] {"X ", "  ", 'X', new ItemStack(trTapisGauche, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(trTapisGauche, 1, 0), new Object[] {"X ", "  ", 'X', new ItemStack(trTapis, 1, 0)});
		
		GameRegistry.addRecipe(new ItemStack(genLaser), new Object[] {
				"YXY",
				"YZY",
				"YVY", 
				'V', Blocks.DISPENSER,
				'X', new ItemStack(Items.DYE, 1, 1),
				'Z', Items.ARROW,
				'Y', Items.IRON_INGOT
		});
		
		GameRegistry.addRecipe(new ItemStack(ccMaj), new Object[] {
				"SSS",
				"SRS",
				"SGS", 
				'R', Items.REDSTONE,
				'G', Items.GOLD_INGOT,
				'S', new ItemStack(Items.DYE,1,2)
		});*/
	}
}
