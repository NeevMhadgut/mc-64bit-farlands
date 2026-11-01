public class BlockFence extends Block {
   public BlockFence(int par1, int par2) {
      super(par1, par2, acn.d);
   }

   public BlockFence(int par1, int par2, acn par3Material) {
      super(par1, par2, par3Material);
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return super.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      boolean flag = this.canConnectFenceTo(par1World, par2, par3, par4 - 1L);
      boolean flag1 = this.canConnectFenceTo(par1World, par2, par3, par4 + 1L);
      boolean flag2 = this.canConnectFenceTo(par1World, par2 - 1L, par3, par4);
      boolean flag3 = this.canConnectFenceTo(par1World, par2 + 1L, par3, par4);
      double f = 0.375;
      double f1 = 0.625;
      double f2 = 0.375;
      double f3 = 0.625;
      if (flag) {
         f2 = 0.0;
      }

      if (flag1) {
         f3 = 1.0;
      }

      if (flag2) {
         f = 0.0;
      }

      if (flag3) {
         f1 = 1.0;
      }

      return AxisAlignedBB.b(par2 + f, par3, par4 + f2, par2 + f1, par3 + 1.5, par4 + f3);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      boolean flag = this.canConnectFenceTo(par1IBlockAccess, par2, par3, par4 - 1L);
      boolean flag1 = this.canConnectFenceTo(par1IBlockAccess, par2, par3, par4 + 1L);
      boolean flag2 = this.canConnectFenceTo(par1IBlockAccess, par2 - 1L, par3, par4);
      boolean flag3 = this.canConnectFenceTo(par1IBlockAccess, par2 + 1L, par3, par4);
      float f = 0.375F;
      float f1 = 0.625F;
      float f2 = 0.375F;
      float f3 = 0.625F;
      if (flag) {
         f2 = 0.0F;
      }

      if (flag1) {
         f3 = 1.0F;
      }

      if (flag2) {
         f = 0.0F;
      }

      if (flag3) {
         f1 = 1.0F;
      }

      this.a(f, 0.0F, f2, f1, 1.0F, f3);
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long i) {
      return false;
   }

   @Override
   public int d() {
      return 11;
   }

   public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockId(par2, par3, par4);
      if (i != this.bO && i != Block.bv.bO) {
         Block block = Block.m[i];
         return block != null && block.cd.j() && block.b() ? block.cd != acn.z : false;
      } else {
         return true;
      }
   }
}
