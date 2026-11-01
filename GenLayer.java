public abstract class GenLayer {
   private long b;
   protected GenLayer a;
   private long c;
   private long d;

   public static GenLayer[] a(long par0, vx par2WorldType) {
      GenLayer obj = new GenLayerIsland(1L);
      obj = new GenLayerFuzzyZoom(2000L, obj);
      obj = new GenLayerAddIsland(1L, obj);
      obj = new GenLayerZoom(2001L, obj);
      obj = new GenLayerAddIsland(2L, obj);
      obj = new GenLayerAddSnow(2L, obj);
      obj = new GenLayerZoom(2002L, obj);
      obj = new GenLayerAddIsland(3L, obj);
      obj = new GenLayerZoom(2003L, obj);
      obj = new GenLayerAddIsland(4L, obj);
      obj = new GenLayerAddMushroomIsland(5L, obj);
      byte byte0 = 4;
      GenLayer obj1 = obj;
      obj1 = GenLayerZoom.a(1000L, obj1, 0);
      obj1 = new GenLayerRiverInit(100L, obj1);
      obj1 = GenLayerZoom.a(1000L, obj1, byte0 + 2);
      obj1 = new GenLayerRiver(1L, obj1);
      obj1 = new GenLayerSmooth(1000L, obj1);
      GenLayer obj2 = obj;
      obj2 = GenLayerZoom.a(1000L, obj2, 0);
      obj2 = new GenLayerBiome(200L, obj2, par2WorldType);
      obj2 = GenLayerZoom.a(1000L, obj2, 2);
      obj2 = new GenLayerHills(1000L, obj2);

      for (int i = 0; i < byte0; i++) {
         obj2 = new GenLayerZoom(1000 + i, obj2);
         if (i == 0) {
            obj2 = new GenLayerAddIsland(3L, obj2);
         }

         if (i == 1) {
            obj2 = new GenLayerShore(1000L, obj2);
         }

         if (i == 1) {
            obj2 = new GenLayerSwampRivers(1000L, obj2);
         }
      }

      obj2 = new GenLayerSmooth(1000L, obj2);
      obj2 = new GenLayerRiverMix(100L, obj2, obj1);
      GenLayerRiverMix genlayerrivermix = (GenLayerRiverMix)obj2;
      GenLayerVoronoiZoom genlayervoronoizoom = new GenLayerVoronoiZoom(10L, obj2);
      obj2.a(par0);
      genlayervoronoizoom.a(par0);
      return new GenLayer[]{obj2, genlayervoronoizoom, genlayerrivermix};
   }

   public GenLayer(long par1) {
      this.d = par1;
      this.d = this.d * (this.d * 6364136223846793005L + 1442695040888963407L);
      this.d += par1;
      this.d = this.d * (this.d * 6364136223846793005L + 1442695040888963407L);
      this.d += par1;
      this.d = this.d * (this.d * 6364136223846793005L + 1442695040888963407L);
      this.d += par1;
   }

   public void a(long par1) {
      this.b = par1;
      if (this.a != null) {
         this.a.a(par1);
      }

      this.b = this.b * (this.b * 6364136223846793005L + 1442695040888963407L);
      this.b = this.b + this.d;
      this.b = this.b * (this.b * 6364136223846793005L + 1442695040888963407L);
      this.b = this.b + this.d;
      this.b = this.b * (this.b * 6364136223846793005L + 1442695040888963407L);
      this.b = this.b + this.d;
   }

   public void a(long par1, long par3) {
      this.c = this.b;
      this.c = this.c * (this.c * 6364136223846793005L + 1442695040888963407L);
      this.c += par1;
      this.c = this.c * (this.c * 6364136223846793005L + 1442695040888963407L);
      this.c += par3;
      this.c = this.c * (this.c * 6364136223846793005L + 1442695040888963407L);
      this.c += par1;
      this.c = this.c * (this.c * 6364136223846793005L + 1442695040888963407L);
      this.c += par3;
   }

   protected int a(int par1) {
      int i = (int)((this.c >> 24) % par1);
      if (i < 0) {
         i += par1;
      }

      this.c = this.c * (this.c * 6364136223846793005L + 1442695040888963407L);
      this.c = this.c + this.b;
      return i;
   }

   public abstract int[] getInts(long var1, long var3, int var5, int var6);
}
