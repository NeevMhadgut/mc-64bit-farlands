public class GenLayerIsland extends GenLayer {
   public GenLayerIsland(long par1) {
      super(par1);
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      int[] ai = ad.a(par3 * par4);

      for (int i = 0; i < par4; i++) {
         for (int j = 0; j < par3; j++) {
            this.a(par1 + j, par2 + i);
            ai[j + i * par3] = this.a(10) != 0 ? 0 : 1;
         }
      }

      if (par1 > -par3 && par1 <= 0L && par2 > -par4 && par2 <= 0L) {
         ai[(int)(-par1 + -par2 * par3)] = 1;
      }

      return ai;
   }
}
