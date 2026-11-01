public class BlockLilyPad extends BlockFlower {
   protected BlockLilyPad(int par1, int par2) {
      super(par1, par2);
      float f = 0.5F;
      float f1 = 0.015625F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
   }

   @Override
   public int d() {
      return 23;
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      return AxisAlignedBB.b(par2 + this.bV, par3 + this.bW, par4 + this.bX, par2 + this.bY, par3 + this.bZ, par4 + this.IChunkProvider);
   }

   @Override
   public int i() {
      return 2129968;
   }

   @Override
   public int d(int par1) {
      return 2129968;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return super.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return 2129968;
   }

   @Override
   protected boolean f_(int par1) {
      return par1 == Block.B.bO;
   }

   @Override
   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      return par3 >= 0 && par3 < 256
         ? par1World.getBlockMaterial(par2, par3 - 1, par4) == acn.g && par1World.getBlockMetadata(par2, par3 - 1, par4) == 0
         : false;
   }
}
