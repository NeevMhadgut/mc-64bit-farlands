public abstract class BlockContainer extends Block {
   protected BlockContainer(int par1, acn par2Material) {
      super(par1, par2Material);
      this.bU = true;
   }

   protected BlockContainer(int par1, int par2, acn par3Material) {
      super(par1, par2, par3Material);
      this.bU = true;
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      par1World.setBlockTileEntity(par2, par3, par4, this.u_());
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      super.onBlockRemoval(par1World, par2, par3, par4);
      par1World.removeBlockTileEntity(par2, par3, par4);
   }

   public abstract TileEntity u_();

   @Override
   public void powerBlock(World par1World, long par2, int par3, long par4, int par5, int par6) {
      super.powerBlock(par1World, par2, par3, par4, par5, par6);
      TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentity != null) {
         tileentity.b(par5, par6);
      }
   }
}
