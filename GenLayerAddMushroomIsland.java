public class GenLayerAddMushroomIsland extends GenLayer {
   public GenLayerAddMushroomIsland(long par1, GenLayer par3GenLayer) {
      super(par1);
      this.a = par3GenLayer;
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      long i = par1 - 1L;
      long j = par2 - 1L;
      int k = par3 + 2;
      int l = par4 + 2;
      int[] ai = this.a.getInts(i, j, k, l);
      int[] ai1 = ad.a(par3 * par4);

      for (int i1 = 0; i1 < par4; i1++) {
         for (int j1 = 0; j1 < par3; j1++) {
            int k1 = ai[j1 + 0 + (i1 + 0) * k];
            int l1 = ai[j1 + 2 + (i1 + 0) * k];
            int i2 = ai[j1 + 0 + (i1 + 2) * k];
            int j2 = ai[j1 + 2 + (i1 + 2) * k];
            int k2 = ai[j1 + 1 + (i1 + 1) * k];
            this.a(j1 + par1, i1 + par2);
            if (k2 == 0 && k1 == 0 && l1 == 0 && i2 == 0 && j2 == 0 && this.a(100) == 0) {
               ai1[j1 + i1 * par3] = BiomeGenBase.p.M;
            } else {
               ai1[j1 + i1 * par3] = k2;
            }
         }
      }

      return ai1;
   }
}
