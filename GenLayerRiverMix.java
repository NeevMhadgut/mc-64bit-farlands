public class GenLayerRiverMix extends GenLayer {
   private GenLayer b;
   private GenLayer c;

   public GenLayerRiverMix(long par1, GenLayer par3GenLayer, GenLayer par4GenLayer) {
      super(par1);
      this.b = par3GenLayer;
      this.c = par4GenLayer;
   }

   @Override
   public void a(long par1) {
      this.b.a(par1);
      this.c.a(par1);
      super.a(par1);
   }

   @Override
   public int[] getInts(long par1, long par2, int par3, int par4) {
      int[] ai = this.b.getInts(par1, par2, par3, par4);
      int[] ai1 = this.c.getInts(par1, par2, par3, par4);
      int[] ai2 = ad.a(par3 * par4);

      for (int i = 0; i < par3 * par4; i++) {
         if (ai[i] == BiomeGenBase.b.M) {
            ai2[i] = ai[i];
         } else if (ai1[i] >= 0) {
            if (ai[i] == BiomeGenBase.n.M) {
               ai2[i] = BiomeGenBase.m.M;
            } else if (ai[i] != BiomeGenBase.p.M && ai[i] != BiomeGenBase.q.M) {
               ai2[i] = ai1[i];
            } else {
               ai2[i] = BiomeGenBase.q.M;
            }
         } else {
            ai2[i] = ai[i];
         }
      }

      return ai2;
   }
}
