public class GenLayerVoronoiZoom extends GenLayer {
   public GenLayerVoronoiZoom(long par1, GenLayer par3GenLayer) {
      super(par1);
      super.a = par3GenLayer;
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      par1 -= 2L;
      par2 -= 2L;
      byte byte0 = 2;
      int i = 1 << byte0;
      long j = par1 >> byte0;
      long k = par2 >> byte0;
      int l = (par3 >> byte0) + 3;
      int i1 = (par4 >> byte0) + 3;
      int[] ai = this.a.getInts(j, k, l, i1);
      int j1 = l << byte0;
      int k1 = i1 << byte0;
      int[] ai1 = ad.a(j1 * k1);

      for (int l1 = 0; l1 < i1 - 1; l1++) {
         int i2 = ai[0 + (l1 + 0) * l];
         int k2 = ai[0 + (l1 + 1) * l];

         for (int l2 = 0; l2 < l - 1; l2++) {
            double d = i * 0.9;
            this.a(l2 + j << byte0, l1 + k << byte0);
            double d1 = (this.a(1024) / 1024.0 - 0.5) * d;
            double d2 = (this.a(1024) / 1024.0 - 0.5) * d;
            this.a(l2 + j + 1L << byte0, l1 + k << byte0);
            double d3 = (this.a(1024) / 1024.0 - 0.5) * d + i;
            double d4 = (this.a(1024) / 1024.0 - 0.5) * d;
            this.a(l2 + j << byte0, l1 + k + 1L << byte0);
            double d5 = (this.a(1024) / 1024.0 - 0.5) * d;
            double d6 = (this.a(1024) / 1024.0 - 0.5) * d + i;
            this.a(l2 + j + 1L << byte0, l1 + k + 1L << byte0);
            double d7 = (this.a(1024) / 1024.0 - 0.5) * d + i;
            double d8 = (this.a(1024) / 1024.0 - 0.5) * d + i;
            int i3 = ai[l2 + 1 + (l1 + 0) * l];
            int j3 = ai[l2 + 1 + (l1 + 1) * l];

            for (int k3 = 0; k3 < i; k3++) {
               int l3 = ((l1 << byte0) + k3) * j1 + (l2 << byte0);

               for (int i4 = 0; i4 < i; i4++) {
                  double d9 = (k3 - d2) * (k3 - d2) + (i4 - d1) * (i4 - d1);
                  double d10 = (k3 - d4) * (k3 - d4) + (i4 - d3) * (i4 - d3);
                  double d11 = (k3 - d6) * (k3 - d6) + (i4 - d5) * (i4 - d5);
                  double d12 = (k3 - d8) * (k3 - d8) + (i4 - d7) * (i4 - d7);
                  if (d9 < d10 && d9 < d11 && d9 < d12) {
                     ai1[l3++] = i2;
                  } else if (d10 < d9 && d10 < d11 && d10 < d12) {
                     ai1[l3++] = i3;
                  } else if (d11 < d9 && d11 < d10 && d11 < d12) {
                     ai1[l3++] = k2;
                  } else {
                     ai1[l3++] = j3;
                  }
               }
            }

            i2 = i3;
            k2 = j3;
         }
      }

      int[] ai2 = ad.a(par3 * par4);

      for (int j2 = 0; j2 < par4; j2++) {
         System.arraycopy(ai1, (j2 + (int)(par2 & i - 1)) * (l << byte0) + (int)(par1 & i - 1), ai2, j2 * par3, par3);
      }

      return ai2;
   }
}
