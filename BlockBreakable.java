public class BlockBreakable extends Block {
   private boolean a;

   protected BlockBreakable(int par1, int par2, acn par3Material, boolean par4) {
      super(par1, par2, par3Material);
      this.a = par4;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      int i = par1IBlockAccess.getBlockId(par2, par3, par4);
      return !this.a && i == this.bO ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
   }
}
