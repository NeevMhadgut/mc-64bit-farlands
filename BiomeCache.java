import java.util.ArrayList;
import java.util.List;

public class BiomeCache {
   private final WorldChunkManager a;
   private long b = 0L;
   private en c = new en();
   private List d = new ArrayList();

   public BiomeCache(WorldChunkManager par1WorldChunkManager) {
      this.a = par1WorldChunkManager;
   }

   public BiomeCacheBlock getBiomeCacheBlock(long par1, long par2) {
      par1 >>= 4;
      par2 >>= 4;
      long l = par1 & 4294967295L | (par2 & 4294967295L) << 32;
      BiomeCacheBlock biomecacheblock = (BiomeCacheBlock)this.c.a(l);
      boolean preBiomeTest = false;
      if (biomecacheblock != null && (biomecacheblock.d != par1 || biomecacheblock.e != par2)) {
         this.c.d(l);
         preBiomeTest = true;
      }

      if (biomecacheblock == null || preBiomeTest) {
         biomecacheblock = new BiomeCacheBlock(this, par1, par2);
         this.c.a(l, biomecacheblock);
         this.d.add(biomecacheblock);
      }

      biomecacheblock.f = System.currentTimeMillis();
      return biomecacheblock;
   }

   public BiomeGenBase getBiomeGenAt(long par1, long par2) {
      return this.getBiomeCacheBlock(par1, par2).getBiomeGenAt(par1, par2);
   }

   public void a() {
      long l = System.currentTimeMillis();
      long l1 = l - this.b;
      if (l1 > 7500L || l1 < 0L) {
         this.b = l;

         for (int i = 0; i < this.d.size(); i++) {
            BiomeCacheBlock biomecacheblock = (BiomeCacheBlock)this.d.get(i);
            long l2 = l - biomecacheblock.f;
            if (l2 > 30000L || l2 < 0L) {
               this.d.remove(i--);
               long l3 = biomecacheblock.d & 4294967295L | (biomecacheblock.e & 4294967295L) << 32;
               this.c.d(l3);
            }
         }
      }
   }

   public BiomeGenBase[] getCachedBiomes(long par1, long par2) {
      return this.getBiomeCacheBlock(par1, par2).c;
   }

   static WorldChunkManager a(BiomeCache par0BiomeCache) {
      return par0BiomeCache.a;
   }
}
