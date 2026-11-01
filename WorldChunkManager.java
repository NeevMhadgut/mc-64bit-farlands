import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldChunkManager {
   private GenLayer a;
   private GenLayer b;
   private BiomeCache c = new BiomeCache(this);
   private List d = new ArrayList();

   protected WorldChunkManager() {
      this.d.add(BiomeGenBase.f);
      this.d.add(BiomeGenBase.c);
      this.d.add(BiomeGenBase.g);
      this.d.add(BiomeGenBase.u);
      this.d.add(BiomeGenBase.t);
      this.d.add(BiomeGenBase.w);
      this.d.add(BiomeGenBase.x);
   }

   public WorldChunkManager(long par1, vx par3WorldType) {
      this();
      GenLayer[] agenlayer = GenLayer.a(par1, par3WorldType);
      this.a = agenlayer[0];
      this.b = agenlayer[1];
   }

   public WorldChunkManager(World par1World) {
      this(par1World.v(), par1World.B().t());
   }

   public List a() {
      return this.d;
   }

   public BiomeGenBase getBiomeGenAt(long par1, long par2) {
      return this.c.getBiomeGenAt(par1, par2);
   }

   public float[] getRainfall(float[] par1ArrayOfFloat, long par2, long par3, int par4, int par5) {
      ad.a();
      if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
      }

      int[] ai = this.b.getInts(par2, par3, par4, par5);

      for (int i = 0; i < par4 * par5; i++) {
         float f = BiomeGenBase.a[ai[i]].g() / 65536.0F;
         if (f > 1.0F) {
            f = 1.0F;
         }

         par1ArrayOfFloat[i] = f;
      }

      return par1ArrayOfFloat;
   }

   public float a(float par1, int par2) {
      return par1;
   }

   public float[] getTemperatures(float[] par1ArrayOfFloat, long par2, long par3, int par4, int par5) {
      ad.a();
      if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
      }

      int[] ai = this.b.getInts(par2, par3, par4, par5);

      for (int i = 0; i < par4 * par5; i++) {
         float f = BiomeGenBase.a[ai[i]].h() / 65536.0F;
         if (f > 1.0F) {
            f = 1.0F;
         }

         par1ArrayOfFloat[i] = f;
      }

      return par1ArrayOfFloat;
   }

   public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, long par2, long par3, int par4, int par5) {
      ad.a();
      if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
      }

      int[] ai = this.a.getInts(par2, par3, par4, par5);

      for (int i = 0; i < par4 * par5; i++) {
         par1ArrayOfBiomeGenBase[i] = BiomeGenBase.a[ai[i]];
      }

      return par1ArrayOfBiomeGenBase;
   }

   public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, long par2, long par3, int par4, int par5) {
      return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
   }

   public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, long par2, long par3, int par4, int par5, boolean par6) {
      ad.a();
      if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
      }

      if (par6 && par4 == 16 && par5 == 16 && (par2 & 15L) == 0L && (par3 & 15L) == 0L) {
         BiomeGenBase[] abiomegenbase = this.c.getCachedBiomes(par2, par3);
         System.arraycopy(abiomegenbase, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
         return par1ArrayOfBiomeGenBase;
      }

      int[] ai = this.b.getInts(par2, par3, par4, par5);

      for (int i = 0; i < par4 * par5; i++) {
         par1ArrayOfBiomeGenBase[i] = BiomeGenBase.a[ai[i]];
      }

      return par1ArrayOfBiomeGenBase;
   }

   public boolean areBiomesViable(long par1, long par2, long par3, List par4List) {
      long i = par1 - par3 >> 2;
      long j = par2 - par3 >> 2;
      long k = par1 + par3 >> 2;
      long l = par2 + par3 >> 2;
      int i1 = (int)(k - i) + 1;
      int j1 = (int)(l - j) + 1;
      int[] ai = this.a.getInts(i, j, i1, j1);

      for (int k1 = 0; k1 < i1 * j1; k1++) {
         BiomeGenBase biomegenbase = BiomeGenBase.a[ai[k1]];
         if (!par4List.contains(biomegenbase)) {
            return false;
         }
      }

      return true;
   }

   public ChunkPosition findBiomePosition(long par1, long par2, int par3, List par4List, Random par5Random) {
      long i = par1 - par3 >> 2;
      long j = par2 - par3 >> 2;
      long k = par1 + par3 >> 2;
      long l = par2 + par3 >> 2;
      int i1 = (int)(k - i) + 1;
      int j1 = (int)(l - j) + 1;
      int[] ai = this.a.getInts(i, j, i1, j1);
      ChunkPosition chunkposition = null;
      int k1 = 0;

      for (int l1 = 0; l1 < ai.length; l1++) {
         long i2 = i + l1 % i1 << 2;
         long j2 = j + l1 / i1 << 2;
         BiomeGenBase biomegenbase = BiomeGenBase.a[ai[l1]];
         if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(k1 + 1) == 0)) {
            chunkposition = new ChunkPosition(i2, 0, j2);
            k1++;
         }
      }

      return chunkposition;
   }

   public void b() {
      this.c.a();
   }
}
