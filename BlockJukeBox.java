public class BlockJukeBox extends BlockContainer {
   protected BlockJukeBox(int par1, int par2) {
      super(par1, par2, acn.d);
   }

   @Override
   public int a_(int par1) {
      return this.bN + (par1 != 1 ? 0 : 1);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
         return false;
      }

      this.ejectRecord(par1World, par2, par3, par4);
      return true;
   }

   public void insertRecord(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         dk tileentityrecordplayer = (dk)par1World.getBlockTileEntity(par2, par3, par4);
         if (tileentityrecordplayer != null) {
            tileentityrecordplayer.a = par5;
            tileentityrecordplayer.j();
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
         }
      }
   }

   public void ejectRecord(World par1World, long par2, int par3, long par4) {
      if (!par1World.F) {
         dk tileentityrecordplayer = (dk)par1World.getBlockTileEntity(par2, par3, par4);
         if (tileentityrecordplayer != null) {
            int i = tileentityrecordplayer.a;
            if (i != 0) {
               par1World.playAuxSFX(1005, par2, par3, par4, 0);
               par1World.playRecord(null, par2, par3, par4);
               tileentityrecordplayer.a = 0;
               tileentityrecordplayer.j();
               par1World.setBlockMetadataWithNotify(par2, par3, par4, 0);
               int j = i;
               float f = 0.7F;
               double d = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
               double d1 = par1World.r.nextFloat() * f + (1.0F - f) * 0.2 + 0.6;
               double d2 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
               EntityItem entityitem = new EntityItem(par1World, par2 + d, par3 + d1, par4 + d2, new ItemStack(j, 1, 0));
               entityitem.c = 10;
               par1World.a(entityitem);
            }
         }
      }
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      this.ejectRecord(par1World, par2, par3, par4);
      super.onBlockRemoval(par1World, par2, par3, par4);
   }

   @Override
   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (!par1World.F) {
         super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
      }
   }

   @Override
   public TileEntity u_() {
      return new dk();
   }
}
