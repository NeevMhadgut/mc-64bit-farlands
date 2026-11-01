public class GenLayerSmooth extends GenLayer {
   public GenLayerSmooth(long par1, GenLayer par3GenLayer) {
      super(par1);
      super.a = par3GenLayer;
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
            int k1 = ai[j1 + 0 + (i1 + 1) * k];
            int l1 = ai[j1 + 2 + (i1 + 1) * k];
            int i2 = ai[j1 + 1 + (i1 + 0) * k];
            int j2 = ai[j1 + 1 + (i1 + 2) * k];
            int k2 = ai[j1 + 1 + (i1 + 1) * k];
            if (k1 == l1 && i2 == j2) {
               this.a(j1 + par1, i1 + par2);
               if (this.a(2) == 0) {
                  k2 = k1;
               } else {
                  k2 = i2;
               }
            } else {
               if (k1 == l1) {
                  k2 = k1;
               }

               if (i2 == j2) {
                  k2 = i2;
               }
            }

            ai1[j1 + i1 * par3] = k2;
         }
      }

      return ai1;
   }
}
