public class GenLayerBiome extends GenLayer {
   private BiomeGenBase[] b = new BiomeGenBase[]{BiomeGenBase.d, BiomeGenBase.f, BiomeGenBase.e, BiomeGenBase.h, BiomeGenBase.c, BiomeGenBase.g, BiomeGenBase.w};

   public GenLayerBiome(long par1, GenLayer par3GenLayer, vx par4WorldType) {
      super(par1);
      this.a = par3GenLayer;
      if (par4WorldType == vx.d) {
         this.b = new BiomeGenBase[]{BiomeGenBase.d, BiomeGenBase.f, BiomeGenBase.e, BiomeGenBase.h, BiomeGenBase.c, BiomeGenBase.g};
      }
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      int[] ai = this.a.getInts(par1, par2, par3, par4);
      int[] ai1 = ad.a(par3 * par4);

      for (int i = 0; i < par4; i++) {
         for (int j = 0; j < par3; j++) {
            this.a(j + par1, i + par2);
            int k = ai[j + i * par3];
            if (k == 0) {
               ai1[j + i * par3] = 0;
            } else if (k == BiomeGenBase.p.M) {
               ai1[j + i * par3] = k;
            } else if (k == 1) {
               ai1[j + i * par3] = this.b[this.a(this.b.length)].M;
            } else {
               ai1[j + i * par3] = BiomeGenBase.n.M;
            }
         }
      }

      return ai1;
   }
}
