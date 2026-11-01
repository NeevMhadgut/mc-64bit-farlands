public class BiomeCacheBlock {
   public float[] a;
   public float[] b;
   public BiomeGenBase[] c;
   public long d;
   public long e;
   public long f;
   final BiomeCache g;

   public BiomeCacheBlock(BiomeCache par1BiomeCache, long par2, long par3) {
      this.g = par1BiomeCache;
      this.a = new float[256];
      this.b = new float[256];
      this.c = new BiomeGenBase[256];
      this.d = par2;
      this.e = par3;
      BiomeCache.a(par1BiomeCache).getTemperatures(this.a, par2 << 4, par3 << 4, 16, 16);
      BiomeCache.a(par1BiomeCache).getRainfall(this.b, par2 << 4, par3 << 4, 16, 16);
      BiomeCache.a(par1BiomeCache).getBiomeGenAt(this.c, par2 << 4, par3 << 4, 16, 16, false);
   }

   public BiomeGenBase getBiomeGenAt(long par1, long par2) {
      return this.c[(int)(par1 & 15L | (par2 & 15L) << 4)];
   }
}
