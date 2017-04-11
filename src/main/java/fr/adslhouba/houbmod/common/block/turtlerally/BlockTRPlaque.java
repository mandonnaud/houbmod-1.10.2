package fr.adslhouba.houbmod.common.block.turtlerally;

import java.util.List;

import fr.adslhouba.houbmod.common.HoubMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockTRPlaque extends Block {
	
	public static final String NAME = "tr_plaque";
	public static final PropertyEnum<BlockTRPlaque.EnumType> VARIANT = PropertyEnum.<BlockTRPlaque.EnumType>create("variant", BlockTRPlaque.EnumType.class);
	
	public BlockTRPlaque()
	{	
		super(Material.IRON);
		
		setResistance(5.0F);
		setHardness(3.5F);
		setCreativeTab(HoubMod.HoubModCreativeTabs);
		setDefaultState(this.getBlockState().getBaseState().withProperty(VARIANT, BlockTRPlaque.EnumType.FIRST));
		
		// worldObj.getBlockPowerInput(this.xCoord, this.yCoord, this.zCoord) 
	}
	
	@Override
	   public int damageDropped(IBlockState state)
	   {
			return state.getValue(VARIANT).getMetadata();
	   }

		@Override
		public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)  {
		   for (BlockTRPlaque.EnumType type : BlockTRPlaque.EnumType.values())
		   {
		       list.add(new ItemStack(itemIn, 1, type.getMetadata()));
		   }
	   }

	   @Override
	   public IBlockState getStateFromMeta(int meta) {
	       return this.getDefaultState().withProperty(VARIANT, BlockTRPlaque.EnumType.byMetadata(meta));
	   }

	   @Override
	   public int getMetaFromState(IBlockState state)
	   {
	       return ((BlockTRPlaque.EnumType)state.getValue(VARIANT)).getMetadata();
	   }

	   @Override
	   protected BlockStateContainer createBlockState()
	   {
	       return new BlockStateContainer(this, new IProperty[] {VARIANT});
	   }
	   public static enum EnumType implements IStringSerializable
	   {
	       // Nous allons définir ici les différents sous-blocs.
		   FIRST(0, "tr_plaque_rota", "tr_plaque_rota"),
		   SECOND(1, "tr_plaque_rotb", "tr_plaque_rotb");
		   
			private static final BlockTRPlaque.EnumType[] META_LOOKUP = new BlockTRPlaque.EnumType[values().length];
			private final int meta;
			private final String name;
			private final String unlocalizedName;
	      
	       // Nous allons créer ici quelques variables que nous utiliserons dans les fonctions.

	       private EnumType(int metaIn, String nameIn, String unlocalizedIn)
	       {
	    	   this.meta = metaIn;
	    	   this.name = nameIn;
	    	   this.unlocalizedName = unlocalizedIn;
	       }

	       public static String[] getUnlocalizedNames()
	       {
	           // Nous utiliserons cette fonction pour récupérer une liste des noms non-localisés.
	    	   String[] names = new String[values().length];
	            
	    	    for (int i = 0; i < META_LOOKUP.length; i++)
	    	        names[i] = META_LOOKUP[i].unlocalizedName;
	    	            
	    	    return names;
	       }


	       public int getMetadata()
	       {
	    	   return this.meta;
	       }

	       public static BlockTRPlaque.EnumType byMetadata(int meta)
	       {
	           // Nous allons ici obtenir la valeur dans l'énumération correspondant à la métadonnée passée en paramètre. Remplacez TutorialBlock par le nom de votre classe.
	    	   if (meta < 0 || meta >= META_LOOKUP.length)
	    	    {
	    	        meta = 0;
	    	    }

	    	    return META_LOOKUP[meta];
	       }

	       public String toString()
	       {
	           // Nous allons renvoyer le nom de l'objet.
	    	   return this.name;
	       }

	       public String getName()
	       {
	           // Nous allons ici aussi renvoyer le nom de l'objet.
	    	   return this.name;
	       }
	       static
	       {
	           for (BlockTRPlaque.EnumType type : values())
	           {
	               META_LOOKUP[type.getMetadata()] = type;
	           }
	       }
	   }
	
	/*
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{	
		for(int i = 0; i < subBlock.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	public boolean canProvidePower()
    {
        return true;
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		int metadata2=world.getBlockMetadata(x, y, z);
		if (world.isBlockIndirectlyGettingPowered(x,y,z))
		{			
			if (metadata2<subBlock.length) world.setBlockMetadataWithNotify(x, y, z, metadata2+subBlock.length, 3);
		}
		else
		{
			if (metadata2>=subBlock.length) world.setBlockMetadataWithNotify(x, y, z, metadata2-subBlock.length, 3);
			
		}
	}
	public IIcon getIcon(int side, int metadata)
	{
		switch(metadata)
		{
			case 0: // Metadata 0 donc bloc 1.
				if(side == 1) // Si le cï¿½tï¿½ est 1, donc en haut,
				{
					return this.iroth; // on utilise la texture du haut.
				}
				return this.icote; // Dans tous les autres cas, on utilise la texture bloc1.
			case 2:
				if(side == 1) // Si le cï¿½tï¿½ est 1, donc en haut,
				{
					return this.rothAnim; // on utilise la texture du haut.
				}
				return this.icote; // Dans tous les autres cas, on utilise la texture bloc1.	
			case 1:
				if(side == 1) // Si le cï¿½tï¿½ est 1, donc en haut,
				{
					return this.irota; // on utilise la texture du haut.
				}
				return this.icote; // Dans tous les autres cas, on utilise la texture bloc1.
			case 3:
				if(side == 1) // Si le cï¿½tï¿½ est 1, donc en haut,
				{
					return this.rotaAnim; // on utilise la texture du haut.
				}
				return this.icote; // Dans tous les autres cas, on utilise la texture bloc1.			
			default:
				return this.icote; // Dans tous les autres cas, on utilise la texture bloc1.
		}
	}
	public int damageDropped(int metadata)
	{
		if (metadata>=subBlock.length)
		{
			metadata-=2;
		}
		return metadata;
	}*/
}