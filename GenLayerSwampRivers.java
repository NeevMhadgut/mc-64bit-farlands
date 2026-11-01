public class GenLayerSwampRivers extends GenLayer {
   public GenLayerSwampRivers(long par1, GenLayer par3GenLayer) {
      super(par1);
      this.a = par3GenLayer;
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      int[] ai = this.a.getInts(par1 - 1L, par2 - 1L, par3 + 2, par4 + 2);
      int[] ai1 = ad.a(par3 * par4);

      for (int i = 0; i < par4; i++) {
         for (int j = 0; j < par3; j++) {
            this.a(j + par1, i + par2);
            int k = ai[j + 1 + (i + 1) * (par3 + 2)];
            if (k == BiomeGenBase.h.M && this.a(6) == 0) {
               ai1[j + i * par3] = BiomeGenBase.i.M;
            } else if ((k == BiomeGenBase.w.M || k == BiomeGenBase.x.M) && this.a(8) == 0) {
               ai1[j + i * par3] = BiomeGenBase.i.M;
            } else {
               ai1[j + i * par3] = k;
            }
         }
      }

      return ai1;
   }
}
