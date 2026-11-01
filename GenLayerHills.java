public class GenLayerHills extends GenLayer {
   public GenLayerHills(long par1, GenLayer par3GenLayer) {
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
            if (this.a(3) == 0) {
               int l = k;
               if (k == BiomeGenBase.d.M) {
                  l = BiomeGenBase.s.M;
               } else if (k == BiomeGenBase.f.M) {
                  l = BiomeGenBase.t.M;
               } else if (k == BiomeGenBase.g.M) {
                  l = BiomeGenBase.u.M;
               } else if (k == BiomeGenBase.c.M) {
                  l = BiomeGenBase.f.M;
               } else if (k == BiomeGenBase.n.M) {
                  l = BiomeGenBase.o.M;
               } else if (k == BiomeGenBase.w.M) {
                  l = BiomeGenBase.x.M;
               }

               if (l != k) {
                  int i1 = ai[j + 1 + (i + 1 - 1) * (par3 + 2)];
                  int j1 = ai[j + 1 + 1 + (i + 1) * (par3 + 2)];
                  int k1 = ai[j + 1 - 1 + (i + 1) * (par3 + 2)];
                  int l1 = ai[j + 1 + (i + 1 + 1) * (par3 + 2)];
                  if (i1 == k && j1 == k && k1 == k && l1 == k) {
                     ai1[j + i * par3] = l;
                  } else {
                     ai1[j + i * par3] = k;
                  }
               } else {
                  ai1[j + i * par3] = k;
               }
            } else {
               ai1[j + i * par3] = k;
            }
         }
      }

      return ai1;
   }
}
