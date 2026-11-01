public class GenLayerAddIsland extends GenLayer {
   public GenLayerAddIsland(long par1, GenLayer par3GenLayer) {
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
            if (k2 != 0 || k1 == 0 && l1 == 0 && i2 == 0 && j2 == 0) {
               if (k2 > 0 && (k1 == 0 || l1 == 0 || i2 == 0 || j2 == 0)) {
                  if (this.a(5) == 0) {
                     if (k2 == BiomeGenBase.n.M) {
                        ai1[j1 + i1 * par3] = BiomeGenBase.l.M;
                     } else {
                        ai1[j1 + i1 * par3] = 0;
                     }
                  } else {
                     ai1[j1 + i1 * par3] = k2;
                  }
               } else {
                  ai1[j1 + i1 * par3] = k2;
               }
            } else {
               int l2 = 1;
               int i3 = 1;
               if (k1 != 0 && this.a(l2++) == 0) {
                  i3 = k1;
               }

               if (l1 != 0 && this.a(l2++) == 0) {
                  i3 = l1;
               }

               if (i2 != 0 && this.a(l2++) == 0) {
                  i3 = i2;
               }

               if (j2 != 0 && this.a(l2++) == 0) {
                  i3 = j2;
               }

               if (this.a(3) == 0) {
                  ai1[j1 + i1 * par3] = i3;
               } else if (i3 == BiomeGenBase.n.M) {
                  ai1[j1 + i1 * par3] = BiomeGenBase.l.M;
               } else {
                  ai1[j1 + i1 * par3] = 0;
               }
            }
         }
      }

      return ai1;
   }
}
