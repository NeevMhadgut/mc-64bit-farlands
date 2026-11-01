public class BlockCloth extends Block {
   public BlockCloth() {
      super(35, 64, acn.m);
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return 16777215;
   }

   @Override
   public int a(int par1, int par2) {
      if (par2 == 0) {
         return this.bN;
      }

      par2 = ~(par2 & 15);
      return 113 + ((par2 & 8) >> 3) + (par2 & 7) * 16;
   }

   @Override
   protected int c(int par1) {
      return par1;
   }

   public static int e(int par0) {
      return ~par0 & 15;
   }

   public static int h(int par0) {
      return ~par0 & 15;
   }
}
