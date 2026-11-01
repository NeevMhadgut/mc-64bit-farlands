public class GenLayerRiverInit extends GenLayer {
   public GenLayerRiverInit(long par1, GenLayer par3GenLayer) {
      super(par1);
      this.a = par3GenLayer;
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      int[] ai = this.a.getInts(par1, par2, par3, par4);
      int[] ai1 = ad.a(par3 * par4);

      for (int i = 0; i < par4; i++) {
         for (int j = 0; j < par3; j++) {
            this.a(j + par1, i + par2);
            ai1[j + i * par3] = ai[j + i * par3] <= 0 ? 0 : this.a(2) + 2;
         }
      }

      return ai1;
   }
}
