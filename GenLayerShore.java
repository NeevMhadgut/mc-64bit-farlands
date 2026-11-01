public class GenLayerShore extends GenLayer {
   public GenLayerShore(long par1, GenLayer par3GenLayer) {
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
            if (k == BiomeGenBase.p.M) {
               int l = ai[j + 1 + (i + 1 - 1) * (par3 + 2)];
               int k1 = ai[j + 1 + 1 + (i + 1) * (par3 + 2)];
               int j2 = ai[j + 1 - 1 + (i + 1) * (par3 + 2)];
               int i3 = ai[j + 1 + (i + 1 + 1) * (par3 + 2)];
               if (l != BiomeGenBase.b.M && k1 != BiomeGenBase.b.M && j2 != BiomeGenBase.b.M && i3 != BiomeGenBase.b.M) {
                  ai1[j + i * par3] = k;
               } else {
                  ai1[j + i * par3] = BiomeGenBase.q.M;
               }
            } else if (k != BiomeGenBase.b.M && k != BiomeGenBase.i.M && k != BiomeGenBase.h.M && k != BiomeGenBase.e.M) {
               int i1 = ai[j + 1 + (i + 1 - 1) * (par3 + 2)];
               int l1 = ai[j + 1 + 1 + (i + 1) * (par3 + 2)];
               int k2 = ai[j + 1 - 1 + (i + 1) * (par3 + 2)];
               int j3 = ai[j + 1 + (i + 1 + 1) * (par3 + 2)];
               if (i1 != BiomeGenBase.b.M && l1 != BiomeGenBase.b.M && k2 != BiomeGenBase.b.M && j3 != BiomeGenBase.b.M) {
                  ai1[j + i * par3] = k;
               } else {
                  ai1[j + i * par3] = BiomeGenBase.r.M;
               }
            } else if (k == BiomeGenBase.e.M) {
               int j1 = ai[j + 1 + (i + 1 - 1) * (par3 + 2)];
               int i2 = ai[j + 1 + 1 + (i + 1) * (par3 + 2)];
               int l2 = ai[j + 1 - 1 + (i + 1) * (par3 + 2)];
               int k3 = ai[j + 1 + (i + 1 + 1) * (par3 + 2)];
               if (j1 == BiomeGenBase.e.M && i2 == BiomeGenBase.e.M && l2 == BiomeGenBase.e.M && k3 == BiomeGenBase.e.M) {
                  ai1[j + i * par3] = k;
               } else {
                  ai1[j + i * par3] = BiomeGenBase.v.M;
               }
            } else {
               ai1[j + i * par3] = k;
            }
         }
      }

      return ai1;
   }
}
