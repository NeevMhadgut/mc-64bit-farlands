public class BlockNote extends BlockContainer {
   public BlockNote(int par1) {
      super(par1, 74, acn.d);
   }

   @Override
   public int a_(int par1) {
      return this.bN;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 > 0) {
         boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
         TileEntityNote tileentitynote = (TileEntityNote)par1World.getBlockTileEntity(par2, par3, par4);
         if (tileentitynote != null && tileentitynote.b != flag) {
            if (flag) {
               tileentitynote.triggerNote(par1World, par2, par3, par4);
            }

            tileentitynote.b = flag;
         }
      }
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      TileEntityNote tileentitynote = (TileEntityNote)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitynote != null) {
         tileentitynote.a();
         tileentitynote.triggerNote(par1World, par2, par3, par4);
      }

      return true;
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (!par1World.F) {
         TileEntityNote tileentitynote = (TileEntityNote)par1World.getBlockTileEntity(par2, par3, par4);
         if (tileentitynote != null) {
            tileentitynote.triggerNote(par1World, par2, par3, par4);
         }
      }
   }

   @Override
   public TileEntity u_() {
      return new TileEntityNote();
   }

   @Override
   public void powerBlock(World par1World, long par2, int par3, long par4, int par5, int par6) {
      float f = (float)Math.pow(2.0, (par6 - 12) / 12.0);
      String s = "harp";
      if (par5 == 1) {
         s = "bd";
      }

      if (par5 == 2) {
         s = "snare";
      }

      if (par5 == 3) {
         s = "hat";
      }

      if (par5 == 4) {
         s = "bassattack";
      }

      par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "note." + s, 3.0F, f);
      par1World.a("note", par2 + 0.5, par3 + 1.2, par4 + 0.5, par6 / 24.0, 0.0, 0.0);
   }
}
