import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class World implements IBlockAccess {
   public boolean a;
   public List b;
   private List G;
   private TreeSet H;
   private Set I;
   public List c;
   private List J;
   private List K;
   public List d;
   public List e;
   private long L;
   public int f;
   protected int g;
   protected final int h = 1013904223;
   protected float i;
   protected float j;
   protected float k;
   protected float l;
   protected int m;
   public int n;
   public boolean o;
   private long M;
   protected int p;
   public int q;
   public Random r;
   public boolean s;
   public final WorldProvider t;
   protected List u;
   protected IChunkProvider v;
   protected final akp w;
   protected WorldInfo x;
   public boolean y;
   private boolean N;
   public za z;
   public final VillageCollection A;
   private final VillageSiege O;
   private ArrayList P;
   private boolean Q;
   protected boolean B;
   protected boolean C;
   protected Set D;
   private int R;
   int[] E;
   private List S;
   public boolean F;

   @Override
   public BiomeGenBase getBiomeGenForCoords(long par1, long par2) {
      if (this.blockExists(par1, 0, par2)) {
         Chunk chunk = this.getChunkFromBlockCoords(par1, par2);
         if (chunk != null) {
            return chunk.a((int)(par1 & 15L), (int)(par2 & 15L), this.t.c);
         }
      }

      return this.t.c.getBiomeGenAt(par1, par2);
   }

   public WorldChunkManager i() {
      return this.t.c;
   }

   public World(akp par1ISaveHandler, String par2Str, WorldProvider par3WorldProvider, fj par4WorldSettings) {
      this.a = false;
      this.b = new ArrayList();
      this.G = new ArrayList();
      this.H = new TreeSet();
      this.I = new HashSet();
      this.c = new ArrayList();
      this.J = new ArrayList();
      this.K = new ArrayList();
      this.d = new ArrayList();
      this.e = new ArrayList();
      this.L = 16777215L;
      this.f = 0;
      this.g = new Random().nextInt();
      this.m = 0;
      this.n = 0;
      this.o = false;
      this.M = System.currentTimeMillis();
      this.p = 40;
      this.r = new Random();
      this.s = false;
      this.u = new ArrayList();
      this.A = new VillageCollection(this);
      this.O = new VillageSiege(this);
      this.P = new ArrayList();
      this.B = true;
      this.C = true;
      this.D = new HashSet();
      this.R = this.r.nextInt(12000);
      this.E = new int[32768];
      this.S = new ArrayList();
      this.F = false;
      this.w = par1ISaveHandler;
      this.x = new WorldInfo(par4WorldSettings, par2Str);
      this.t = par3WorldProvider;
      this.z = new za(par1ISaveHandler);
      par3WorldProvider.a(this);
      this.v = this.d();
      this.q();
      this.K();
   }

   public World(World par1World, WorldProvider par2WorldProvider) {
      this.a = false;
      this.b = new ArrayList();
      this.G = new ArrayList();
      this.H = new TreeSet();
      this.I = new HashSet();
      this.c = new ArrayList();
      this.J = new ArrayList();
      this.K = new ArrayList();
      this.d = new ArrayList();
      this.e = new ArrayList();
      this.L = 16777215L;
      this.f = 0;
      this.g = new Random().nextInt();
      this.m = 0;
      this.n = 0;
      this.o = false;
      this.M = System.currentTimeMillis();
      this.p = 40;
      this.r = new Random();
      this.s = false;
      this.u = new ArrayList();
      this.A = new VillageCollection(this);
      this.O = new VillageSiege(this);
      this.P = new ArrayList();
      this.B = true;
      this.C = true;
      this.D = new HashSet();
      this.R = this.r.nextInt(12000);
      this.E = new int[32768];
      this.S = new ArrayList();
      this.F = false;
      this.M = par1World.M;
      this.w = par1World.w;
      this.x = new WorldInfo(par1World.x);
      this.z = new za(this.w);
      this.t = par2WorldProvider;
      par2WorldProvider.a(this);
      this.v = this.d();
      this.q();
      this.K();
   }

   public World(akp par1ISaveHandler, String par2Str, fj par3WorldSettings) {
      this(par1ISaveHandler, par2Str, par3WorldSettings, (WorldProvider)null);
   }

   public World(akp par1ISaveHandler, String par2Str, fj par3WorldSettings, WorldProvider par4WorldProvider) {
      this.a = false;
      this.b = new ArrayList();
      this.G = new ArrayList();
      this.H = new TreeSet();
      this.I = new HashSet();
      this.c = new ArrayList();
      this.J = new ArrayList();
      this.K = new ArrayList();
      this.d = new ArrayList();
      this.e = new ArrayList();
      this.L = 16777215L;
      this.f = 0;
      this.g = new Random().nextInt();
      this.m = 0;
      this.n = 0;
      this.o = false;
      this.M = System.currentTimeMillis();
      this.p = 40;
      this.r = new Random();
      this.s = false;
      this.u = new ArrayList();
      this.A = new VillageCollection(this);
      this.O = new VillageSiege(this);
      this.P = new ArrayList();
      this.B = true;
      this.C = true;
      this.D = new HashSet();
      this.R = this.r.nextInt(12000);
      this.E = new int[32768];
      this.S = new ArrayList();
      this.F = false;
      this.w = par1ISaveHandler;
      this.z = new za(par1ISaveHandler);
      this.x = par1ISaveHandler.c();
      this.s = this.x == null;
      if (par4WorldProvider != null) {
         this.t = par4WorldProvider;
      } else if (this.x != null && this.x.i() != 0) {
         this.t = WorldProvider.a(this.x.i());
      } else {
         this.t = WorldProvider.a(0);
      }

      boolean flag = false;
      if (this.x == null) {
         this.x = new WorldInfo(par3WorldSettings, par2Str);
         flag = true;
      } else {
         this.x.a(par2Str);
      }

      this.t.a(this);
      this.v = this.d();
      if (flag) {
         this.j();
      }

      this.q();
      this.K();
   }

   protected IChunkProvider d() {
      IChunkLoader ichunkloader = this.w.a(this.t);
      return new ChunkProvider(this, ichunkloader, this.t.b());
   }

   protected void j() {
      if (!this.t.d()) {
         this.x.setSpawnPosition(0L, this.t.h(), 0L);
      } else {
         this.y = true;
         WorldChunkManager worldchunkmanager = this.t.c;
         List list = worldchunkmanager.a();
         Random random = new Random(this.v());
         ChunkPosition chunkposition = worldchunkmanager.findBiomePosition(0L, 0L, 256, list, random);
         long i = 0L;
         int j = this.t.h();
         long k = 0L;
         if (chunkposition != null) {
            i = chunkposition.a;
            k = chunkposition.c;
         } else {
            System.out.println("Unable WorldGenTallGrass find spawn biome");
         }

         int l = 0;

         while (!this.t.canCoordinateBeSpawn(i, k)) {
            i += random.nextInt(64) - random.nextInt(64);
            k += random.nextInt(64) - random.nextInt(64);
            if (++l == 1000) {
               break;
            }
         }

         this.x.setSpawnPosition(i, j, k);
         this.y = false;
      }
   }

   public ChunkCoordinates k() {
      return this.t.g();
   }

   public void e() {
      if (this.x.d() <= 0) {
         this.x.b(64);
      }

      long i = this.x.getSpawnX();
      long j = this.x.getSpawnZ();
      int k = 0;

      while (this.getFirstUncoveredBlock(i, j) == 0) {
         i += this.r.nextInt(8) - this.r.nextInt(8);
         j += this.r.nextInt(8) - this.r.nextInt(8);
         if (++k == 10000) {
            break;
         }
      }

      this.x.setSpawnX(i);
      this.x.setSpawnZ(j);
   }

   public int getFirstUncoveredBlock(long par1, long par2) {
      int i = 63;

      while (!this.isAirBlock(par1, i + 1, par2)) {
         i++;
      }

      return this.getBlockId(par1, i, par2);
   }

   public void l() {
   }

   public void a(EntityPlayer par1EntityPlayer) {
      try {
         ady nbttagcompound = this.x.h();
         if (nbttagcompound != null) {
            par1EntityPlayer.e(nbttagcompound);
            this.x.a((ady)null);
         }

         if (this.v instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate chunkproviderloadorgenerate = (ChunkProviderLoadOrGenerate)this.v;
            long i = MathHelper.d(par1EntityPlayer.o) >> 4;
            long j = MathHelper.d(par1EntityPlayer.q) >> 4;
            chunkproviderloadorgenerate.setCurrentChunkOver(i, j);
         }

         this.a((Entity)par1EntityPlayer);
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }

   public void a(boolean par1, rw par2IProgressUpdate) {
      if (this.v.b()) {
         if (par2IProgressUpdate != null) {
            par2IProgressUpdate.b("Saving level");
         }

         this.J();
         if (par2IProgressUpdate != null) {
            par2IProgressUpdate.d("Saving chunks");
         }

         this.v.a(par1, par2IProgressUpdate);
      }
   }

   private void J() {
      this.u();
      this.w.a(this.x, this.d);
      this.z.a();
   }

   public boolean c(int par1) {
      if (!this.v.b()) {
         return true;
      }

      if (par1 == 0) {
         this.J();
      }

      return this.v.a(false, null);
   }

   @Override
   public int getBlockId(long par1, int par2, long par3) {
      if (par2 < 0) {
         return 0;
      } else {
         return par2 >= 256 ? 0 : this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4).a((int)(par1 & 15L), par2, (int)(par3 & 15L));
      }
   }

   public int func_48462_d(long par1, int par2, long par3) {
      if (par2 < 0) {
         return 0;
      } else {
         return par2 >= 256 ? 0 : this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4).b((int)(par1 & 15L), par2, (int)(par3 & 15L));
      }
   }

   @Override
   public boolean isAirBlock(long par1, int par2, long par3) {
      return this.getBlockId(par1, par2, par3) == 0;
   }

   public boolean blockExists(long par1, int par2, long par3) {
      return par2 >= 0 && par2 < 256 ? this.chunkExists(par1 >> 4, par3 >> 4) : false;
   }

   public boolean doChunksNearChunkExist(long par1, int par2, long par3, int par4) {
      return this.checkChunksExist(par1 - par4, par2 - par4, par3 - par4, par1 + par4, par2 + par4, par3 + par4);
   }

   public boolean checkChunksExist(long par1, int par2, long par3, long par4, int par5, long par6) {
      if (par5 >= 0 && par2 < 256) {
         par1 >>= 4;
         par3 >>= 4;
         par4 >>= 4;
         par6 >>= 4;

         for (long i = par1; i <= par4; i++) {
            for (long j = par3; j <= par6; j++) {
               if (!this.chunkExists(i, j)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean chunkExists(long par1, long par2) {
      return this.v.chunkExists(par1, par2);
   }

   public Chunk getChunkFromBlockCoords(long par1, long par2) {
      return this.getChunkFromChunkCoords(par1 >> 4, par2 >> 4);
   }

   public Chunk getChunkFromChunkCoords(long par1, long par2) {
      return this.v.provideChunk(par1, par2);
   }

   public boolean setBlockAndMetadata(long par1, int par2, long par3, int par4, int par5) {
      if (par2 < 0) {
         return false;
      }

      if (par2 >= 256) {
         return false;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
      boolean flag = chunk.a((int)(par1 & 15L), par2, (int)(par3 & 15L), par4, par5);
      lv.a("checkLight");
      this.updateAllLightTypes(par1, par2, par3);
      lv.b();
      return flag;
   }

   public boolean setBlock(long par1, int par2, long par3, int par4) {
      if (par2 < 0) {
         return false;
      }

      if (par2 >= 256) {
         return false;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
      boolean flag = chunk.a((int)(par1 & 15L), par2, (int)(par3 & 15L), par4);
      lv.a("checkLight");
      this.updateAllLightTypes(par1, par2, par3);
      lv.b();
      return flag;
   }

   @Override
   public acn getBlockMaterial(long par1, int par2, long par3) {
      int i = this.getBlockId(par1, par2, par3);
      return i == 0 ? acn.a : Block.m[i].cd;
   }

   @Override
   public int getBlockMetadata(long par1, int par2, long par3) {
      if (par2 < 0) {
         return 0;
      }

      if (par2 >= 256) {
         return 0;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
      par1 &= 15L;
      par3 &= 15L;
      return chunk.c((int)par1, par2, (int)par3);
   }

   public void setBlockMetadataWithNotify(long par1, int par2, long par3, int par4) {
      if (this.setBlockMetadata(par1, par2, par3, par4)) {
         int i = this.getBlockId(par1, par2, par3);
         if (Block.r[i & 4095]) {
            this.notifyBlockChange(par1, par2, par3, i);
         } else {
            this.notifyBlocksOfNeighborChange(par1, par2, par3, i);
         }
      }
   }

   public boolean setBlockMetadata(long par1, int par2, long par3, int par4) {
      if (par2 < 0) {
         return false;
      }

      if (par2 >= 256) {
         return false;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
      par1 &= 15L;
      par3 &= 15L;
      return chunk.b((int)par1, par2, (int)par3, par4);
   }

   public boolean setBlockWithNotify(long par1, int par2, long par3, int par4) {
      if (this.setBlock(par1, par2, par3, par4)) {
         this.notifyBlockChange(par1, par2, par3, par4);
         return true;
      } else {
         return false;
      }
   }

   public boolean setBlockAndMetadataWithNotify(long par1, int par2, long par3, int par4, int par5) {
      if (this.setBlockAndMetadata(par1, par2, par3, par4, par5)) {
         this.notifyBlockChange(par1, par2, par3, par4);
         return true;
      } else {
         return false;
      }
   }

   public void markBlockNeedsUpdate(long par1, int par2, long par3) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).markBlockNeedsUpdate(par1, par2, par3);
      }
   }

   public void notifyBlockChange(long par1, int par2, long par3, int par4) {
      this.markBlockNeedsUpdate(par1, par2, par3);
      this.notifyBlocksOfNeighborChange(par1, par2, par3, par4);
   }

   public void markBlocksDirtyVertical(long par1, long par2, int par3, int par4) {
      if (par3 > par4) {
         int i = par4;
         par4 = par3;
         par3 = i;
      }

      if (!this.t.e) {
         for (int j = par3; j <= par4; j++) {
            this.updateLightByType(wl.a, par1, j, par2);
         }
      }

      this.markBlocksDirty(par1, par3, par2, par1, par4, par2);
   }

   public void markBlockAsNeedsUpdate(long par1, int par2, long par3) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).markBlockRangeNeedsUpdate(par1, par2, par3, par1, par2, par3);
      }
   }

   public void markBlocksDirty(long par1, int par2, long par3, long par4, int par5, long par6) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).markBlockRangeNeedsUpdate(par1, par2, par3, par4, par5, par6);
      }
   }

   public void notifyBlocksOfNeighborChange(long par1, int par2, long par3, int par4) {
      this.notifyBlockOfNeighborChange(par1 - 1L, par2, par3, par4);
      this.notifyBlockOfNeighborChange(par1 + 1L, par2, par3, par4);
      this.notifyBlockOfNeighborChange(par1, par2 - 1, par3, par4);
      this.notifyBlockOfNeighborChange(par1, par2 + 1, par3, par4);
      this.notifyBlockOfNeighborChange(par1, par2, par3 - 1L, par4);
      this.notifyBlockOfNeighborChange(par1, par2, par3 + 1L, par4);
   }

   private void notifyBlockOfNeighborChange(long par1, int par2, long par3, int par4) {
      if (!this.o && !this.F) {
         Block block = Block.m[this.getBlockId(par1, par2, par3)];
         if (block != null) {
            block.onNeighborBlockChange(this, par1, par2, par3, par4);
         }
      }
   }

   public boolean canBlockSeeTheSky(long par1, int par2, long par3) {
      return this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4).d((int)(par1 & 15L), par2, (int)(par3 & 15L));
   }

   public int getFullBlockLightValue(long par1, int par2, long par3) {
      if (par2 < 0) {
         return 0;
      }

      if (par2 >= 256) {
         par2 = 255;
      }

      return this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4).c((int)(par1 & 15L), par2, (int)(par3 & 15L), 0);
   }

   public int getBlockLightValue(long par1, int par2, long par3) {
      return this.getBlockLightValue_do(par1, par2, par3, true);
   }

   public int getBlockLightValue_do(long par1, int par2, long par3, boolean par4) {
      if (par4) {
         int i = this.getBlockId(par1, par2, par3);
         if (i == Block.ak.bO || i == Block.aA.bO || i == Block.aH.bO || i == Block.at.bO) {
            int j = this.getBlockLightValue_do(par1, par2 + 1, par3, false);
            int k = this.getBlockLightValue_do(par1 + 1L, par2, par3, false);
            int l = this.getBlockLightValue_do(par1 - 1L, par2, par3, false);
            int i1 = this.getBlockLightValue_do(par1, par2, par3 + 1L, false);
            int j1 = this.getBlockLightValue_do(par1, par2, par3 - 1L, false);
            if (k > j) {
               j = k;
            }

            if (l > j) {
               j = l;
            }

            if (i1 > j) {
               j = i1;
            }

            if (j1 > j) {
               j = j1;
            }

            return j;
         }
      }

      if (par2 < 0) {
         return 0;
      }

      if (par2 >= 256) {
         par2 = 255;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
      par1 &= 15L;
      par3 &= 15L;
      return chunk.c((int)par1, par2, (int)par3, this.f);
   }

   public int getHeightValue(long par1, long par2) {
      if (!this.chunkExists(par1 >> 4, par2 >> 4)) {
         return 0;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par2 >> 4);
      return chunk.b((int)(par1 & 15L), (int)(par2 & 15L));
   }

   public int getSkyBlockTypeBrightness(wl par1EnumSkyBlock, long par2, int par3, long par4) {
      if (this.t.e && par1EnumSkyBlock == wl.a) {
         return 0;
      }

      if (par3 < 0) {
         par3 = 0;
      }

      if (par3 >= 256) {
         return par1EnumSkyBlock.c;
      }

      long i = par2 >> 4;
      long j = par4 >> 4;
      if (!this.chunkExists(i, j)) {
         return par1EnumSkyBlock.c;
      }

      if (Block.s[this.getBlockId(par2, par3, par4)]) {
         int k = this.getSavedLightValue(par1EnumSkyBlock, par2, par3 + 1, par4);
         int l = this.getSavedLightValue(par1EnumSkyBlock, par2 + 1L, par3, par4);
         int i1 = this.getSavedLightValue(par1EnumSkyBlock, par2 - 1L, par3, par4);
         int j1 = this.getSavedLightValue(par1EnumSkyBlock, par2, par3, par4 + 1L);
         int k1 = this.getSavedLightValue(par1EnumSkyBlock, par2, par3, par4 - 1L);
         if (l > k) {
            k = l;
         }

         if (i1 > k) {
            k = i1;
         }

         if (j1 > k) {
            k = j1;
         }

         if (k1 > k) {
            k = k1;
         }

         return k;
      } else {
         Chunk chunk = this.getChunkFromChunkCoords(i, j);
         return chunk.a(par1EnumSkyBlock, (int)(par2 & 15L), par3, (int)(par4 & 15L));
      }
   }

   public int getSavedLightValue(wl par1EnumSkyBlock, long par2, int par3, long par4) {
      if (par3 < 0) {
         par3 = 0;
      }

      if (par3 >= 256) {
         par3 = 255;
      }

      long i = par2 >> 4;
      long j = par4 >> 4;
      if (!this.chunkExists(i, j)) {
         return par1EnumSkyBlock.c;
      }

      Chunk chunk = this.getChunkFromChunkCoords(i, j);
      return chunk.a(par1EnumSkyBlock, (int)(par2 & 15L), par3, (int)(par4 & 15L));
   }

   public void setLightValue(wl par1EnumSkyBlock, long par2, int par3, long par4, int par5) {
      if (par3 >= 0) {
         if (par3 < 256) {
            if (this.chunkExists(par2 >> 4, par4 >> 4)) {
               Chunk chunk = this.getChunkFromChunkCoords(par2 >> 4, par4 >> 4);
               chunk.a(par1EnumSkyBlock, (int)(par2 & 15L), par3, (int)(par4 & 15L), par5);

               for (int i = 0; i < this.u.size(); i++) {
                  ((IWorldAccess)this.u.get(i)).markBlockNeedsUpdate2(par2, par3, par4);
               }
            }
         }
      }
   }

   public void func_48464_p(long par1, int par2, long par3) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).markBlockNeedsUpdate2(par1, par2, par3);
      }
   }

   @Override
   public int getLightBrightnessForSkyBlocks(long par1, int par2, long par3, int par4) {
      int i = this.getSkyBlockTypeBrightness(wl.a, par1, par2, par3);
      int j = this.getSkyBlockTypeBrightness(wl.b, par1, par2, par3);
      if (j < par4) {
         j = par4;
      }

      return i << 20 | j << 4;
   }

   @Override
   public float getBrightness(long par1, int par2, long par3, int par4) {
      int i = this.getBlockLightValue(par1, par2, par3);
      if (i < par4) {
         i = par4;
      }

      return this.t.f[i];
   }

   @Override
   public float getLightBrightness(long par1, int par2, long par3) {
      return this.t.f[this.getBlockLightValue(par1, par2, par3)];
   }

   public boolean m() {
      return this.f < 4;
   }

   public MovingObjectPosition a(bo par1Vec3D, bo par2Vec3D) {
      return this.a(par1Vec3D, par2Vec3D, false, false);
   }

   public MovingObjectPosition a(bo par1Vec3D, bo par2Vec3D, boolean par3) {
      return this.a(par1Vec3D, par2Vec3D, par3, false);
   }

   public MovingObjectPosition a(bo par1Vec3D, bo par2Vec3D, boolean par3, boolean par4) {
      if (Double.isNaN(par1Vec3D.a) || Double.isNaN(par1Vec3D.b) || Double.isNaN(par1Vec3D.c)) {
         return null;
      }

      if (!Double.isNaN(par2Vec3D.a) && !Double.isNaN(par2Vec3D.b) && !Double.isNaN(par2Vec3D.c)) {
         long i = MathHelper.d(par2Vec3D.a);
         int j = MathHelper.c(par2Vec3D.b);
         long k = MathHelper.d(par2Vec3D.c);
         long l = MathHelper.d(par1Vec3D.a);
         int i1 = MathHelper.c(par1Vec3D.b);
         long j1 = MathHelper.d(par1Vec3D.c);
         int k1 = this.getBlockId(l, i1, j1);
         int i2 = this.getBlockMetadata(l, i1, j1);
         Block block = Block.m[k1];
         if ((!par4 || block == null || block.getCollisionBoundingBoxFromPool(this, l, i1, j1) != null) && k1 > 0 && block.a(i2, par3)) {
            MovingObjectPosition movingobjectposition = block.collisionRayTrace(this, l, i1, j1, par1Vec3D, par2Vec3D);
            if (movingobjectposition != null) {
               return movingobjectposition;
            }
         }

         int l1 = 200;

         while (l1-- >= 0) {
            if (Double.isNaN(par1Vec3D.a) || Double.isNaN(par1Vec3D.b) || Double.isNaN(par1Vec3D.c)) {
               return null;
            }

            if (l == i && i1 == j && j1 == k) {
               return null;
            }

            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            double d = 999.0;
            double d1 = 999.0;
            double d2 = 999.0;
            if (i > l) {
               d = l + 1.0;
            } else if (i < l) {
               d = l + 0.0;
            } else {
               flag = false;
            }

            if (j > i1) {
               d1 = i1 + 1.0;
            } else if (j < i1) {
               d1 = i1 + 0.0;
            } else {
               flag1 = false;
            }

            if (k > j1) {
               d2 = j1 + 1.0;
            } else if (k < j1) {
               d2 = j1 + 0.0;
            } else {
               flag2 = false;
            }

            double d3 = 999.0;
            double d4 = 999.0;
            double d5 = 999.0;
            double d6 = par2Vec3D.a - par1Vec3D.a;
            double d7 = par2Vec3D.b - par1Vec3D.b;
            double d8 = par2Vec3D.c - par1Vec3D.c;
            if (flag) {
               d3 = (d - par1Vec3D.a) / d6;
            }

            if (flag1) {
               d4 = (d1 - par1Vec3D.b) / d7;
            }

            if (flag2) {
               d5 = (d2 - par1Vec3D.c) / d8;
            }

            byte byte0 = 0;
            if (d3 < d4 && d3 < d5) {
               if (i > l) {
                  byte0 = 4;
               } else {
                  byte0 = 5;
               }

               par1Vec3D.a = d;
               par1Vec3D.b += d7 * d3;
               par1Vec3D.c += d8 * d3;
            } else if (d4 < d5) {
               if (j > i1) {
                  byte0 = 0;
               } else {
                  byte0 = 1;
               }

               par1Vec3D.a += d6 * d4;
               par1Vec3D.b = d1;
               par1Vec3D.c += d8 * d4;
            } else {
               if (k > j1) {
                  byte0 = 2;
               } else {
                  byte0 = 3;
               }

               par1Vec3D.a += d6 * d5;
               par1Vec3D.b += d7 * d5;
               par1Vec3D.c = d2;
            }

            bo vec3d = bo.b(par1Vec3D.a, par1Vec3D.b, par1Vec3D.c);
            l = (long)(vec3d.a = MathHelper.d(par1Vec3D.a));
            if (byte0 == 5) {
               l--;
               vec3d.a++;
            }

            i1 = (int)(vec3d.b = MathHelper.c(par1Vec3D.b));
            if (byte0 == 1) {
               i1--;
               vec3d.b++;
            }

            j1 = (long)(vec3d.c = MathHelper.d(par1Vec3D.c));
            if (byte0 == 3) {
               j1--;
               vec3d.c++;
            }

            int j2 = this.getBlockId(l, i1, j1);
            int k2 = this.getBlockMetadata(l, i1, j1);
            Block block1 = Block.m[j2];
            if ((!par4 || block1 == null || block1.getCollisionBoundingBoxFromPool(this, l, i1, j1) != null) && j2 > 0 && block1.a(k2, par3)) {
               MovingObjectPosition movingobjectposition1 = block1.collisionRayTrace(this, l, i1, j1, par1Vec3D, par2Vec3D);
               if (movingobjectposition1 != null) {
                  return movingobjectposition1;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public void a(Entity par1Entity, String par2Str, float par3, float par4) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).a(par2Str, par1Entity.o, par1Entity.p - par1Entity.H, par1Entity.q, par3, par4);
      }
   }

   public void a(double par1, double par3, double par5, String par7Str, float par8, float par9) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).a(par7Str, par1, par3, par5, par8, par9);
      }
   }

   public void playRecord(String par1Str, long par2, int par3, long par4) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).playRecord(par1Str, par2, par3, par4);
      }
   }

   public void a(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).a(par1Str, par2, par4, par6, par8, par10, par12);
      }
   }

   public boolean e(Entity par1Entity) {
      this.e.add(par1Entity);
      return true;
   }

   public boolean a(Entity par1Entity) {
      long i = MathHelper.d(par1Entity.o / 16.0);
      long j = MathHelper.d(par1Entity.q / 16.0);
      boolean flag = false;
      if (par1Entity instanceof EntityPlayer) {
         flag = true;
      }

      if (!flag && !this.chunkExists(i, j)) {
         return false;
      }

      if (par1Entity instanceof EntityPlayer) {
         EntityPlayer entityplayer = (EntityPlayer)par1Entity;
         this.d.add(entityplayer);
         this.C();
      }

      this.getChunkFromChunkCoords(i, j).a(par1Entity);
      this.b.add(par1Entity);
      this.c(par1Entity);
      return true;
   }

   protected void c(Entity par1Entity) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).a(par1Entity);
      }
   }

   protected void d(Entity par1Entity) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).b(par1Entity);
      }
   }

   public void b(Entity par1Entity) {
      if (par1Entity.i != null) {
         par1Entity.i.h(null);
      }

      if (par1Entity.j != null) {
         par1Entity.h(null);
      }

      par1Entity.A();
      if (par1Entity instanceof EntityPlayer) {
         this.d.remove((EntityPlayer)par1Entity);
         this.C();
      }
   }

   public void a(IWorldAccess par1IWorldAccess) {
      this.u.add(par1IWorldAccess);
   }

   public void b(IWorldAccess par1IWorldAccess) {
      this.u.remove(par1IWorldAccess);
   }

   public List a(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB) {
      this.P.clear();
      long i = MathHelper.d(par2AxisAlignedBB.a);
      long j = MathHelper.d(par2AxisAlignedBB.d + 1.0);
      int k = MathHelper.c(par2AxisAlignedBB.b);
      int l = MathHelper.c(par2AxisAlignedBB.e + 1.0);
      long i1 = MathHelper.d(par2AxisAlignedBB.c);
      long j1 = MathHelper.d(par2AxisAlignedBB.f + 1.0);

      for (long k1 = i; k1 < j; k1++) {
         for (long l1 = i1; l1 < j1; l1++) {
            if (this.blockExists(k1, 64, l1)) {
               for (int i2 = k - 1; i2 < l; i2++) {
                  Block block = Block.m[this.getBlockId(k1, i2, l1)];
                  if (block != null) {
                     block.getCollidingBoundingBoxes(this, k1, i2, l1, par2AxisAlignedBB, this.P);
                  }
               }
            }
         }
      }

      double d = 0.25;
      List list = this.b(par1Entity, par2AxisAlignedBB.b(d, d, d));

      for (int j2 = 0; j2 < list.size(); j2++) {
         AxisAlignedBB axisalignedbb = ((Entity)list.get(j2)).f_();
         if (axisalignedbb != null && axisalignedbb.a(par2AxisAlignedBB)) {
            this.P.add(axisalignedbb);
         }

         axisalignedbb = par1Entity.b((Entity)list.get(j2));
         if (axisalignedbb != null && axisalignedbb.a(par2AxisAlignedBB)) {
            this.P.add(axisalignedbb);
         }
      }

      return this.P;
   }

   public int a(float par1) {
      float f = this.c(par1);
      float f1 = 1.0F - (MathHelper.b(f * (float) Math.PI * 2.0F) * 2.0F + 0.5F);
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f1 > 1.0F) {
         f1 = 1.0F;
      }

      f1 = 1.0F - f1;
      f1 = (float)(f1 * (1.0 - this.j(par1) * 5.0F / 16.0));
      f1 = (float)(f1 * (1.0 - this.i(par1) * 5.0F / 16.0));
      f1 = 1.0F - f1;
      return (int)(f1 * 11.0F);
   }

   public float b(float par1) {
      float f = this.c(par1);
      float f1 = 1.0F - (MathHelper.b(f * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f1 > 1.0F) {
         f1 = 1.0F;
      }

      f1 = 1.0F - f1;
      f1 = (float)(f1 * (1.0 - this.j(par1) * 5.0F / 16.0));
      f1 = (float)(f1 * (1.0 - this.i(par1) * 5.0F / 16.0));
      return f1 * 0.8F + 0.2F;
   }

   public bo a(Entity par1Entity, float par2) {
      float f = this.c(par2);
      float f1 = MathHelper.b(f * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f1 > 1.0F) {
         f1 = 1.0F;
      }

      long i = MathHelper.d(par1Entity.o);
      long j = MathHelper.d(par1Entity.q);
      BiomeGenBase biomegenbase = this.getBiomeGenForCoords(i, j);
      float f2 = biomegenbase.j();
      int k = biomegenbase.a(f2);
      float f3 = (k >> 16 & 0xFF) / 255.0F;
      float f4 = (k >> 8 & 0xFF) / 255.0F;
      float f5 = (k & 0xFF) / 255.0F;
      f3 *= f1;
      f4 *= f1;
      f5 *= f1;
      float f6 = this.j(par2);
      if (f6 > 0.0F) {
         float f7 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.6F;
         float f9 = 1.0F - f6 * 0.75F;
         f3 = f3 * f9 + f7 * (1.0F - f9);
         f4 = f4 * f9 + f7 * (1.0F - f9);
         f5 = f5 * f9 + f7 * (1.0F - f9);
      }

      float f8 = this.i(par2);
      if (f8 > 0.0F) {
         float f10 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
         float f12 = 1.0F - f8 * 0.75F;
         f3 = f3 * f12 + f10 * (1.0F - f12);
         f4 = f4 * f12 + f10 * (1.0F - f12);
         f5 = f5 * f12 + f10 * (1.0F - f12);
      }

      if (this.n > 0) {
         float f11 = this.n - par2;
         if (f11 > 1.0F) {
            f11 = 1.0F;
         }

         f11 *= 0.45F;
         f3 = f3 * (1.0F - f11) + 0.8F * f11;
         f4 = f4 * (1.0F - f11) + 0.8F * f11;
         f5 = f5 * (1.0F - f11) + 1.0F * f11;
      }

      return bo.b(f3, f4, f5);
   }

   public float c(float par1) {
      return this.t.a(this.x.f(), par1);
   }

   public int d(float par1) {
      return this.t.b(this.x.f(), par1);
   }

   public float e(float par1) {
      float f = this.c(par1);
      return f * (float) Math.PI * 2.0F;
   }

   public bo f(float par1) {
      float f = this.c(par1);
      float f1 = MathHelper.b(f * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f1 > 1.0F) {
         f1 = 1.0F;
      }

      float f2 = (float)(this.L >> 16 & 255L) / 255.0F;
      float f3 = (float)(this.L >> 8 & 255L) / 255.0F;
      float f4 = (float)(this.L & 255L) / 255.0F;
      float f5 = this.j(par1);
      if (f5 > 0.0F) {
         float f6 = (f2 * 0.3F + f3 * 0.59F + f4 * 0.11F) * 0.6F;
         float f8 = 1.0F - f5 * 0.95F;
         f2 = f2 * f8 + f6 * (1.0F - f8);
         f3 = f3 * f8 + f6 * (1.0F - f8);
         f4 = f4 * f8 + f6 * (1.0F - f8);
      }

      f2 *= f1 * 0.9F + 0.1F;
      f3 *= f1 * 0.9F + 0.1F;
      f4 *= f1 * 0.85F + 0.15F;
      float f7 = this.i(par1);
      if (f7 > 0.0F) {
         float f9 = (f2 * 0.3F + f3 * 0.59F + f4 * 0.11F) * 0.2F;
         float f10 = 1.0F - f7 * 0.95F;
         f2 = f2 * f10 + f9 * (1.0F - f10);
         f3 = f3 * f10 + f9 * (1.0F - f10);
         f4 = f4 * f10 + f9 * (1.0F - f10);
      }

      return bo.b(f2, f3, f4);
   }

   public bo g(float par1) {
      float f = this.c(par1);
      return this.t.b(f, par1);
   }

   public int getPrecipitationHeight(long par1, long par2) {
      return this.getChunkFromBlockCoords(par1, par2).d((int)(par1 & 15L), (int)(par2 & 15L));
   }

   public int getTopSolidOrLiquidBlock(long par1, long par2) {
      Chunk chunk = this.getChunkFromBlockCoords(par1, par2);
      int i = chunk.h() + 16;
      par1 &= 15L;
      par2 &= 15L;

      while (i > 0) {
         int j = chunk.a((int)par1, i, (int)par2);
         if (j != 0 && Block.m[j].cd.c() && Block.m[j].cd != acn.i) {
            return i + 1;
         }

         i--;
      }

      return -1;
   }

   public float h(float par1) {
      float f = this.c(par1);
      float f1 = 1.0F - (MathHelper.b(f * (float) Math.PI * 2.0F) * 2.0F + 0.75F);
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f1 > 1.0F) {
         f1 = 1.0F;
      }

      return f1 * f1 * 0.5F;
   }

   public void scheduleBlockUpdate(long par1, int par2, long par3, int par4, int par5) {
      NextTickListEntry nextticklistentry = new NextTickListEntry(par1, par2, par3, par4);
      byte byte0 = 8;
      if (this.a) {
         if (this.checkChunksExist(
            nextticklistentry.a - byte0,
            nextticklistentry.b - byte0,
            nextticklistentry.c - byte0,
            nextticklistentry.a + byte0,
            nextticklistentry.b + byte0,
            nextticklistentry.c + byte0
         )) {
            int i = this.getBlockId(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
            if (i == nextticklistentry.d && i > 0) {
               Block.m[i].updateTick(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.r);
            }
         }
      } else {
         if (this.checkChunksExist(par1 - byte0, par2 - byte0, par3 - byte0, par1 + byte0, par2 + byte0, par3 + byte0)) {
            if (par4 > 0) {
               nextticklistentry.a(par5 + this.x.f());
            }

            if (!this.I.contains(nextticklistentry)) {
               this.I.add(nextticklistentry);
               this.H.add(nextticklistentry);
            }
         }
      }
   }

   public void scheduleBlockUpdateFromLoad(long par1, int par2, long par3, int par4, int par5) {
      NextTickListEntry nextticklistentry = new NextTickListEntry(par1, par2, par3, par4);
      if (par4 > 0) {
         nextticklistentry.a(par5 + this.x.f());
      }

      if (!this.I.contains(nextticklistentry)) {
         this.I.add(nextticklistentry);
         this.H.add(nextticklistentry);
      }
   }

   public void n() {
      lv.a("entities");
      lv.a("global");

      for (int i = 0; i < this.e.size(); i++) {
         Entity entity = (Entity)this.e.get(i);
         entity.J_();
         if (entity.G) {
            this.e.remove(i--);
         }
      }

      lv.c("remove");
      this.b.removeAll(this.G);

      for (int j = 0; j < this.G.size(); j++) {
         Entity entity1 = (Entity)this.G.get(j);
         long i1 = entity1.BlockTNT;
         long k1 = entity1.ag;
         if (entity1.ad && this.chunkExists(i1, k1)) {
            this.getChunkFromChunkCoords(i1, k1).b(entity1);
         }
      }

      for (int k = 0; k < this.G.size(); k++) {
         this.d((Entity)this.G.get(k));
      }

      this.G.clear();
      lv.c("regular");

      for (int l = 0; l < this.b.size(); l++) {
         Entity entity2 = (Entity)this.b.get(l);
         if (entity2.j != null) {
            if (!entity2.j.G && entity2.j.i == entity2) {
               continue;
            }

            entity2.j.i = null;
            entity2.j = null;
         }

         if (!entity2.G) {
            this.f(entity2);
         }

         lv.a("remove");
         if (entity2.G) {
            long j1 = entity2.BlockTNT;
            long l1 = entity2.ag;
            if (entity2.ad && this.chunkExists(j1, l1)) {
               this.getChunkFromChunkCoords(j1, l1).b(entity2);
            }

            this.b.remove(l--);
            this.d(entity2);
         }

         lv.b();
      }

      lv.c("tileEntities");
      this.Q = true;
      Iterator iterator = this.c.iterator();

      while (iterator.hasNext()) {
         TileEntity tileentity = (TileEntity)iterator.next();
         if (!tileentity.l() && tileentity.i != null && this.blockExists(tileentity.j, tileentity.k, tileentity.l)) {
            tileentity.n_();
         }

         if (tileentity.l()) {
            iterator.remove();
            if (this.chunkExists(tileentity.j >> 4, tileentity.l >> 4)) {
               Chunk chunk = this.getChunkFromChunkCoords(tileentity.j >> 4, tileentity.l >> 4);
               if (chunk != null) {
                  chunk.f((int)(tileentity.j & 15L), tileentity.k, (int)(tileentity.l & 15L));
               }
            }
         }
      }

      this.Q = false;
      if (!this.K.isEmpty()) {
         this.c.removeAll(this.K);
         this.K.clear();
      }

      lv.c("pendingTileEntities");
      if (!this.J.isEmpty()) {
         for (TileEntity tileentity1 : this.J) {
            if (!tileentity1.l()) {
               if (!this.c.contains(tileentity1)) {
                  this.c.add(tileentity1);
               }

               if (this.chunkExists(tileentity1.j >> 4, tileentity1.l >> 4)) {
                  Chunk chunk1 = this.getChunkFromChunkCoords(tileentity1.j >> 4, tileentity1.l >> 4);
                  if (chunk1 != null) {
                     chunk1.a((int)(tileentity1.j & 15L), tileentity1.k, (int)(tileentity1.l & 15L), tileentity1);
                  }
               }

               this.markBlockNeedsUpdate(tileentity1.j, tileentity1.k, tileentity1.l);
            }
         }

         this.J.clear();
      }

      lv.b();
      lv.b();
   }

   public void a(Collection par1Collection) {
      if (this.Q) {
         this.J.addAll(par1Collection);
      } else {
         this.c.addAll(par1Collection);
      }
   }

   public void f(Entity par1Entity) {
      this.a(par1Entity, true);
   }

   public void a(Entity par1Entity, boolean par2) {
      long i = MathHelper.d(par1Entity.o);
      long j = MathHelper.d(par1Entity.q);
      byte byte0 = 32;
      if (!par2 || this.checkChunksExist(i - byte0, 0, j - byte0, i + byte0, 0, j + byte0)) {
         par1Entity.N = par1Entity.o;
         par1Entity.O = par1Entity.p;
         par1Entity.P = par1Entity.q;
         par1Entity.w = par1Entity.u;
         par1Entity.x = par1Entity.v;
         if (par2 && par1Entity.ad) {
            if (par1Entity.j != null) {
               par1Entity.O();
            } else {
               par1Entity.J_();
            }
         }

         lv.a("chunkCheck");
         if (Double.isNaN(par1Entity.o) || Double.isInfinite(par1Entity.o)) {
            par1Entity.o = par1Entity.N;
         }

         if (Double.isNaN(par1Entity.p) || Double.isInfinite(par1Entity.p)) {
            par1Entity.p = par1Entity.O;
         }

         if (Double.isNaN(par1Entity.q) || Double.isInfinite(par1Entity.q)) {
            par1Entity.q = par1Entity.P;
         }

         if (Double.isNaN(par1Entity.v) || Double.isInfinite(par1Entity.v)) {
            par1Entity.v = par1Entity.x;
         }

         if (Double.isNaN(par1Entity.u) || Double.isInfinite(par1Entity.u)) {
            par1Entity.u = par1Entity.w;
         }

         long k = MathHelper.d(par1Entity.o / 16.0);
         int l = MathHelper.c(par1Entity.p / 16.0);
         long i1 = MathHelper.d(par1Entity.q / 16.0);
         if (!par1Entity.ad || par1Entity.BlockTNT != k || par1Entity.TileEntityMobSpawnerRenderer != l || par1Entity.ag != i1) {
            if (par1Entity.ad && this.chunkExists(par1Entity.BlockTNT, par1Entity.ag)) {
               this.getChunkFromChunkCoords(par1Entity.BlockTNT, par1Entity.ag).a(par1Entity, par1Entity.TileEntityMobSpawnerRenderer);
            }

            if (this.chunkExists(k, i1)) {
               par1Entity.ad = true;
               this.getChunkFromChunkCoords(k, i1).a(par1Entity);
            } else {
               par1Entity.ad = false;
            }
         }

         lv.b();
         if (par2 && par1Entity.ad && par1Entity.i != null) {
            if (!par1Entity.i.G && par1Entity.i.j == par1Entity) {
               this.f(par1Entity.i);
            } else {
               par1Entity.i.j = null;
               par1Entity.i = null;
            }
         }
      }
   }

   public boolean a(AxisAlignedBB par1AxisAlignedBB) {
      List list = this.b(null, par1AxisAlignedBB);

      for (int i = 0; i < list.size(); i++) {
         Entity entity = (Entity)list.get(i);
         if (!entity.G && entity.h) {
            return false;
         }
      }

      return true;
   }

   public boolean b(AxisAlignedBB par1AxisAlignedBB) {
      long i = MathHelper.d(par1AxisAlignedBB.a);
      long j = MathHelper.d(par1AxisAlignedBB.d + 1.0);
      int k = MathHelper.c(par1AxisAlignedBB.b);
      int l = MathHelper.c(par1AxisAlignedBB.e + 1.0);
      long i1 = MathHelper.d(par1AxisAlignedBB.c);
      long j1 = MathHelper.d(par1AxisAlignedBB.f + 1.0);
      if (par1AxisAlignedBB.a < 0.0) {
         i--;
      }

      if (par1AxisAlignedBB.b < 0.0) {
         k--;
      }

      if (par1AxisAlignedBB.c < 0.0) {
         i1--;
      }

      for (long k1 = i; k1 < j; k1++) {
         for (int l1 = k; l1 < l; l1++) {
            for (long i2 = i1; i2 < j1; i2++) {
               Block block = Block.m[this.getBlockId(k1, l1, i2)];
               if (block != null && block.cd.d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean c(AxisAlignedBB par1AxisAlignedBB) {
      long i = MathHelper.d(par1AxisAlignedBB.a);
      long j = MathHelper.d(par1AxisAlignedBB.d + 1.0);
      int k = MathHelper.c(par1AxisAlignedBB.b);
      int l = MathHelper.c(par1AxisAlignedBB.e + 1.0);
      long i1 = MathHelper.d(par1AxisAlignedBB.c);
      long j1 = MathHelper.d(par1AxisAlignedBB.f + 1.0);
      if (this.checkChunksExist(i, k, i1, j, l, j1)) {
         for (long k1 = i; k1 < j; k1++) {
            for (int l1 = k; l1 < l; l1++) {
               for (long i2 = i1; i2 < j1; i2++) {
                  int j2 = this.getBlockId(k1, l1, i2);
                  if (j2 == Block.ar.bO || j2 == Block.C.bO || j2 == Block.D.bO) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean a(AxisAlignedBB par1AxisAlignedBB, acn par2Material, Entity par3Entity) {
      long i = MathHelper.d(par1AxisAlignedBB.a);
      long j = MathHelper.d(par1AxisAlignedBB.d + 1.0);
      int k = MathHelper.c(par1AxisAlignedBB.b);
      int l = MathHelper.c(par1AxisAlignedBB.e + 1.0);
      long i1 = MathHelper.d(par1AxisAlignedBB.c);
      long j1 = MathHelper.d(par1AxisAlignedBB.f + 1.0);
      if (!this.checkChunksExist(i, k, i1, j, l, j1)) {
         return false;
      }

      boolean flag = false;
      bo vec3d = bo.b(0.0, 0.0, 0.0);

      for (long k1 = i; k1 < j; k1++) {
         for (int l1 = k; l1 < l; l1++) {
            for (long i2 = i1; i2 < j1; i2++) {
               Block block = Block.m[this.getBlockId(k1, l1, i2)];
               if (block != null && block.cd == par2Material) {
                  double d1 = l1 + 1 - BlockFluid.e(this.getBlockMetadata(k1, l1, i2));
                  if (l >= d1) {
                     flag = true;
                     block.velocityToAddToEntity(this, k1, l1, i2, par3Entity, vec3d);
                  }
               }
            }
         }
      }

      if (vec3d.d() > 0.0) {
         vec3d = vec3d.c();
         double d = 0.014;
         par3Entity.r = par3Entity.r + vec3d.a * d;
         par3Entity.s = par3Entity.s + vec3d.b * d;
         par3Entity.t = par3Entity.t + vec3d.c * d;
      }

      return flag;
   }

   public boolean a(AxisAlignedBB par1AxisAlignedBB, acn par2Material) {
      long i = MathHelper.d(par1AxisAlignedBB.a);
      long j = MathHelper.d(par1AxisAlignedBB.d + 1.0);
      int k = MathHelper.c(par1AxisAlignedBB.b);
      int l = MathHelper.c(par1AxisAlignedBB.e + 1.0);
      long i1 = MathHelper.d(par1AxisAlignedBB.c);
      long j1 = MathHelper.d(par1AxisAlignedBB.f + 1.0);

      for (long k1 = i; k1 < j; k1++) {
         for (int l1 = k; l1 < l; l1++) {
            for (long i2 = i1; i2 < j1; i2++) {
               Block block = Block.m[this.getBlockId(k1, l1, i2)];
               if (block != null && block.cd == par2Material) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean b(AxisAlignedBB par1AxisAlignedBB, acn par2Material) {
      long i = MathHelper.d(par1AxisAlignedBB.a);
      long j = MathHelper.d(par1AxisAlignedBB.d + 1.0);
      int k = MathHelper.c(par1AxisAlignedBB.b);
      int l = MathHelper.c(par1AxisAlignedBB.e + 1.0);
      long i1 = MathHelper.d(par1AxisAlignedBB.c);
      long j1 = MathHelper.d(par1AxisAlignedBB.f + 1.0);

      for (long k1 = i; k1 < j; k1++) {
         for (int l1 = k; l1 < l; l1++) {
            for (long i2 = i1; i2 < j1; i2++) {
               Block block = Block.m[this.getBlockId(k1, l1, i2)];
               if (block != null && block.cd == par2Material) {
                  int j2 = this.getBlockMetadata(k1, l1, i2);
                  double d = l1 + 1;
                  if (j2 < 8) {
                     d = l1 + 1 - j2 / 8.0;
                  }

                  if (d >= par1AxisAlignedBB.b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public Explosion a(Entity par1Entity, double par2, double par4, double par6, float par8) {
      return this.a(par1Entity, par2, par4, par6, par8, false);
   }

   public Explosion a(Entity par1Entity, double par2, double par4, double par6, float par8, boolean par9) {
      Explosion explosion = new Explosion(this, par1Entity, par2, par4, par6, par8);
      explosion.a = par9;
      explosion.a();
      explosion.a(true);
      return explosion;
   }

   public float a(bo par1Vec3D, AxisAlignedBB par2AxisAlignedBB) {
      double d = 1.0 / ((par2AxisAlignedBB.d - par2AxisAlignedBB.a) * 2.0 + 1.0);
      double d1 = 1.0 / ((par2AxisAlignedBB.e - par2AxisAlignedBB.b) * 2.0 + 1.0);
      double d2 = 1.0 / ((par2AxisAlignedBB.f - par2AxisAlignedBB.c) * 2.0 + 1.0);
      int i = 0;
      int j = 0;

      for (float f = 0.0F; f <= 1.0F; f = (float)(f + d)) {
         for (float f1 = 0.0F; f1 <= 1.0F; f1 = (float)(f1 + d1)) {
            for (float f2 = 0.0F; f2 <= 1.0F; f2 = (float)(f2 + d2)) {
               double d3 = par2AxisAlignedBB.a + (par2AxisAlignedBB.d - par2AxisAlignedBB.a) * f;
               double d4 = par2AxisAlignedBB.b + (par2AxisAlignedBB.e - par2AxisAlignedBB.b) * f1;
               double d5 = par2AxisAlignedBB.c + (par2AxisAlignedBB.f - par2AxisAlignedBB.c) * f2;
               if (this.a(bo.b(d3, d4, d5), par1Vec3D) == null) {
                  i++;
               }

               j++;
            }
         }
      }

      return (float)i / j;
   }

   public boolean func_48457_a(EntityPlayer par1EntityPlayer, long par2, int par3, long par4, int par5) {
      if (par5 == 0) {
         par3--;
      }

      if (par5 == 1) {
         par3++;
      }

      if (par5 == 2) {
         par4--;
      }

      if (par5 == 3) {
         par4++;
      }

      if (par5 == 4) {
         par2--;
      }

      if (par5 == 5) {
         par2++;
      }

      if (this.getBlockId(par2, par3, par4) == Block.ar.bO) {
         this.playAuxSFXAtEntity(par1EntityPlayer, 1004, par2, par3, par4, 0);
         this.setBlockWithNotify(par2, par3, par4, 0);
         return true;
      } else {
         return false;
      }
   }

   public Entity a(Class par1Class) {
      return null;
   }

   public String o() {
      return "All: " + this.b.size();
   }

   public String p() {
      return this.v.c();
   }

   @Override
   public TileEntity getBlockTileEntity(long par1, int par2, long par3) {
      if (par2 >= 256) {
         return null;
      }

      Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
      if (chunk == null) {
         return null;
      }

      TileEntity tileentity = chunk.e((int)(par1 & 15L), par2, (int)(par3 & 15L));
      if (tileentity == null) {
         for (TileEntity tileentity1 : this.J) {
            if (!tileentity1.l() && tileentity1.j == par1 && tileentity1.k == par2 && tileentity1.l == par3) {
               tileentity = tileentity1;
               break;
            }
         }
      }

      return tileentity;
   }

   public void setBlockTileEntity(long par1, int par2, long par3, TileEntity par4TileEntity) {
      if (par4TileEntity != null && !par4TileEntity.l()) {
         if (this.Q) {
            par4TileEntity.j = par1;
            par4TileEntity.k = par2;
            par4TileEntity.l = par3;
            this.J.add(par4TileEntity);
         } else {
            this.c.add(par4TileEntity);
            Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
            if (chunk != null) {
               chunk.a((int)(par1 & 15L), par2, (int)(par3 & 15L), par4TileEntity);
            }
         }
      }
   }

   public void removeBlockTileEntity(long par1, int par2, long par3) {
      TileEntity tileentity = this.getBlockTileEntity(par1, par2, par3);
      if (tileentity != null && this.Q) {
         tileentity.h();
         this.J.remove(tileentity);
      } else {
         if (tileentity != null) {
            this.J.remove(tileentity);
            this.c.remove(tileentity);
         }

         Chunk chunk = this.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
         if (chunk != null) {
            chunk.f((int)(par1 & 15L), par2, (int)(par3 & 15L));
         }
      }
   }

   public void a(TileEntity par1TileEntity) {
      this.K.add(par1TileEntity);
   }

   @Override
   public boolean isBlockOpaqueCube(long par1, int par2, long par3) {
      Block block = Block.m[this.getBlockId(par1, par2, par3)];
      return block == null ? false : block.a();
   }

   @Override
   public boolean isBlockNormalCube(long par1, int par2, long par3) {
      return Block.g(this.getBlockId(par1, par2, par3));
   }

   public boolean isBlockNormalCubeDefault(long par1, int par2, long par3, boolean par4) {
      Chunk chunk = this.v.provideChunk(par1 >> 4, par3 >> 4);
      if (chunk != null && !chunk.g()) {
         Block block = Block.m[this.getBlockId(par1, par2, par3)];
         return block == null ? false : block.cd.j() && block.b();
      } else {
         return par4;
      }
   }

   public void a(rw par1IProgressUpdate) {
      this.a(true, par1IProgressUpdate);

      try {
         ce.a.a();
      } catch (InterruptedException interruptedexception) {
         interruptedexception.printStackTrace();
      }
   }

   public void q() {
      int i = this.a(1.0F);
      if (i != this.f) {
         this.f = i;
      }
   }

   public void a(boolean par1, boolean par2) {
      this.B = par1;
      this.C = par2;
   }

   public void c() {
      if (this.B().s() && this.q < 3) {
         this.q = 3;
      }

      this.t.c.b();
      this.h();
      if (this.E()) {
         boolean flag = false;
         if (this.B && this.q < 1) {
         }

         if (!flag) {
            long l = this.x.f() + 24000L;
            this.x.a(l - l % 24000L);
            this.D();
         }
      }

      lv.a("mobSpawner");
      SpawnerAnimals.a(this, this.B, this.C && this.x.f() % 400L == 0L);
      lv.c("chunkSource");
      this.v.a();
      int i = this.a(1.0F);
      if (i != this.f) {
         this.f = i;
      }

      long l1 = this.x.f() + 1L;
      if (l1 % this.p == 0L) {
         lv.c("save");
         this.a(false, null);
      }

      this.x.a(l1);
      lv.c("tickPending");
      this.a(false);
      lv.c("tickTiles");
      this.f();
      lv.c("village");
      this.A.a();
      this.O.a();
      lv.b();
   }

   private void K() {
      if (this.x.o()) {
         this.j = 1.0F;
         if (this.x.m()) {
            this.l = 1.0F;
         }
      }
   }

   protected void h() {
      if (!this.t.e) {
         if (this.m > 0) {
            this.m--;
         }

         int i = this.x.n();
         if (i <= 0) {
            if (this.x.m()) {
               this.x.e(this.r.nextInt(12000) + 3600);
            } else {
               this.x.e(this.r.nextInt(168000) + 12000);
            }
         } else {
            this.x.e(--i);
            if (i <= 0) {
               this.x.a(!this.x.m());
            }
         }

         int j = this.x.p();
         if (j <= 0) {
            if (this.x.o()) {
               this.x.f(this.r.nextInt(12000) + 12000);
            } else {
               this.x.f(this.r.nextInt(168000) + 12000);
            }
         } else {
            this.x.f(--j);
            if (j <= 0) {
               this.x.b(!this.x.o());
            }
         }

         this.i = this.j;
         if (this.x.o()) {
            this.j = (float)(this.j + 0.01);
         } else {
            this.j = (float)(this.j - 0.01);
         }

         if (this.j < 0.0F) {
            this.j = 0.0F;
         }

         if (this.j > 1.0F) {
            this.j = 1.0F;
         }

         this.k = this.l;
         if (this.x.m()) {
            this.l = (float)(this.l + 0.01);
         } else {
            this.l = (float)(this.l - 0.01);
         }

         if (this.l < 0.0F) {
            this.l = 0.0F;
         }

         if (this.l > 1.0F) {
            this.l = 1.0F;
         }
      }
   }

   public void clearWeatherViaCommand() {
      this.L();
   }

   public void handleWeatherCommand() {
      this.x.b(true);
   }

   private void L() {
      this.x.f(0);
      this.x.b(false);
      this.x.e(0);
      this.x.a(false);
   }

   protected void r() {
      this.D.clear();
      lv.a("buildList");

      for (int i = 0; i < this.d.size(); i++) {
         EntityPlayer entityplayer = (EntityPlayer)this.d.get(i);
         long k = MathHelper.d(entityplayer.o / 16.0);
         long i1 = MathHelper.d(entityplayer.q / 16.0);
         byte byte0 = 7;

         for (int l1 = -byte0; l1 <= byte0; l1++) {
            for (int i2 = -byte0; i2 <= byte0; i2++) {
               this.D.add(new ChunkCoordIntPair(l1 + k, i2 + i1));
            }
         }
      }

      lv.b();
      if (this.R > 0) {
         this.R--;
      }

      lv.a("playerCheckLight");
      if (!this.d.isEmpty()) {
         int j = this.r.nextInt(this.d.size());
         EntityPlayer entityplayer1 = (EntityPlayer)this.d.get(j);
         long l = MathHelper.d(entityplayer1.o) + this.r.nextInt(11) - 5L;
         int j1 = MathHelper.c(entityplayer1.p) + this.r.nextInt(11) - 5;
         long k1 = MathHelper.d(entityplayer1.q) + this.r.nextInt(11) - 5L;
         this.updateAllLightTypes(l, j1, k1);
      }

      lv.b();
   }

   protected void func_48458_a(long par1, long par2, Chunk par3Chunk) {
      lv.c("tickChunk");
      par3Chunk.k();
      lv.c("moodSound");
      if (this.R == 0) {
         this.g = this.g * 3 + 1013904223;
         int i = this.g >> 2;
         int jInt = i & 15;
         int kInt = i >> 8 & 15;
         int l = i >> 16 & 127;
         int i1 = par3Chunk.a(jInt, l, kInt);
         long j = jInt + par1;
         long k = kInt + par2;
         if (i1 == 0 && this.getFullBlockLightValue(j, l, k) <= this.r.nextInt(8) && this.getSavedLightValue(wl.a, j, l, k) <= 0) {
            EntityPlayer entityplayer = this.a(j + 0.5, l + 0.5, k + 0.5, 8.0);
            if (entityplayer != null && entityplayer.f(j + 0.5, l + 0.5, k + 0.5) > 4.0) {
               this.a(j + 0.5, l + 0.5, k + 0.5, "ambient.cave.cave", 0.7F, 0.8F + this.r.nextFloat() * 0.2F);
               this.R = this.r.nextInt(12000) + 6000;
            }
         }
      }

      lv.c("checkLight");
      par3Chunk.o();
   }

   protected void f() {
      this.r();
      int i = 0;
      int j = 0;

      for (ChunkCoordIntPair chunkcoordintpair : this.D) {
         long k = chunkcoordintpair.a * 16L;
         long l = chunkcoordintpair.b * 16L;
         if (k >= 9223372036854775744L || k < 9223372036854775744L || l >= 9223372036854775744L || l < 9223372036854775744L) {
            return;
         }

         lv.a("getChunk");
         Chunk chunk = this.getChunkFromChunkCoords(chunkcoordintpair.a, chunkcoordintpair.b);
         this.func_48458_a(k, l, chunk);
         lv.c("thunder");
         if (this.r.nextInt(100000) == 0 && this.G() && this.F()) {
            this.g = this.g * 3 + 1013904223;
            int i1 = this.g >> 2;
            long k1 = k + (i1 & 15);
            long j2 = l + (i1 >> 8 & 15);
            int i3 = this.getPrecipitationHeight(k1, j2);
            if (this.canLightningStrikeAt(k1, i3, j2)) {
               this.e(new d(this, k1, i3, j2));
               this.m = 2;
            }
         }

         lv.c("iceandsnow");
         if (this.r.nextInt(16) == 0) {
            this.g = this.g * 3 + 1013904223;
            int j1 = this.g >> 2;
            long l1 = j1 & 15;
            long k2 = j1 >> 8 & 15;
            int j3 = this.getPrecipitationHeight(k + l1, l + k2);
            if (this.isBlockHydratedIndirectly(k + l1, j3 - 1, l + k2)) {
               this.setBlockWithNotify(k + l1, j3 - 1, l + k2, Block.aT.bO);
            }

            if (this.G() && this.canSnowAt(k + l1, j3, l + k2)) {
               this.setBlockWithNotify(k + l1, j3, l + k2, Block.aS.bO);
            }
         }

         lv.c("tickTiles");

         for (zg extendedblockstorage : chunk.i()) {
            if (extendedblockstorage != null && extendedblockstorage.b()) {
               for (int k3 = 0; k3 < 3; k3++) {
                  this.g = this.g * 3 + 1013904223;
                  int l3 = this.g >> 2;
                  int i4 = l3 & 15;
                  int j4 = l3 >> 8 & 15;
                  int k4 = l3 >> 16 & 15;
                  int l4 = extendedblockstorage.a(i4, k4, j4);
                  j++;
                  Block block = Block.m[l4];
                  if (block != null && block.o()) {
                     i++;
                     block.updateTick(this, k + i4, k4 + extendedblockstorage.c(), l + j4, this.r);
                  }
               }
            }
         }

         lv.b();
      }
   }

   public boolean isBlockHydratedDirectly(long par1, int par2, long par3) {
      return this.isBlockHydrated(par1, par2, par3, false);
   }

   public boolean isBlockHydratedIndirectly(long par1, int par2, long par3) {
      return this.isBlockHydrated(par1, par2, par3, true);
   }

   public boolean isBlockHydrated(long par1, int par2, long par3, boolean par4) {
      BiomeGenBase biomegenbase = this.getBiomeGenForCoords(par1, par3);
      float f = biomegenbase.j();
      if (f > 0.15F) {
         return false;
      }

      if (par2 >= 0 && par2 < 256 && this.getSavedLightValue(wl.b, par1, par2, par3) < 10) {
         int i = this.getBlockId(par1, par2, par3);
         if ((i == Block.B.bO || i == Block.A.bO) && this.getBlockMetadata(par1, par2, par3) == 0) {
            if (!par4) {
               return true;
            }

            boolean flag = true;
            if (flag && this.getBlockMaterial(par1 - 1L, par2, par3) != acn.g) {
               flag = false;
            }

            if (flag && this.getBlockMaterial(par1 + 1L, par2, par3) != acn.g) {
               flag = false;
            }

            if (flag && this.getBlockMaterial(par1, par2, par3 - 1L) != acn.g) {
               flag = false;
            }

            if (flag && this.getBlockMaterial(par1, par2, par3 + 1L) != acn.g) {
               flag = false;
            }

            if (!flag) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean canSnowAt(long par1, int par2, long par3) {
      BiomeGenBase biomegenbase = this.getBiomeGenForCoords(par1, par3);
      float f = biomegenbase.j();
      if (f > 0.15F) {
         return false;
      }

      if (par2 >= 0 && par2 < 256 && this.getSavedLightValue(wl.b, par1, par2, par3) < 10) {
         int i = this.getBlockId(par1, par2 - 1, par3);
         int j = this.getBlockId(par1, par2, par3);
         if (j == 0 && Block.aS.canPlaceBlockAt(this, par1, par2, par3) && i != 0 && i != Block.aT.bO && Block.m[i].cd.c()) {
            return true;
         }
      }

      return false;
   }

   public void updateAllLightTypes(long par1, int par2, long par3) {
      if (!this.t.e) {
         this.updateLightByType(wl.a, par1, par2, par3);
      }

      this.updateLightByType(wl.b, par1, par2, par3);
   }

   private int computeSkyLightValue(int par1, long par2, int par3, long par4, int par5, int par6) {
      int i = 0;
      if (this.canBlockSeeTheSky(par2, par3, par4)) {
         i = 15;
      } else {
         if (par6 == 0) {
            par6 = 1;
         }

         int j = this.getSavedLightValue(wl.a, par2 - 1L, par3, par4) - par6;
         int k = this.getSavedLightValue(wl.a, par2 + 1L, par3, par4) - par6;
         int l = this.getSavedLightValue(wl.a, par2, par3 - 1, par4) - par6;
         int i1 = this.getSavedLightValue(wl.a, par2, par3 + 1, par4) - par6;
         int j1 = this.getSavedLightValue(wl.a, par2, par3, par4 - 1L) - par6;
         int k1 = this.getSavedLightValue(wl.a, par2, par3, par4 + 1L) - par6;
         if (j > i) {
            i = j;
         }

         if (k > i) {
            i = k;
         }

         if (l > i) {
            i = l;
         }

         if (i1 > i) {
            i = i1;
         }

         if (j1 > i) {
            i = j1;
         }

         if (k1 > i) {
            i = k1;
         }
      }

      return i;
   }

   private int computeBlockLightValue(int par1, long par2, int par3, long par4, int par5, int par6) {
      int i = Block.q[par5];
      int j = this.getSavedLightValue(wl.b, par2 - 1L, par3, par4) - par6;
      int k = this.getSavedLightValue(wl.b, par2 + 1L, par3, par4) - par6;
      int l = this.getSavedLightValue(wl.b, par2, par3 - 1, par4) - par6;
      int i1 = this.getSavedLightValue(wl.b, par2, par3 + 1, par4) - par6;
      int j1 = this.getSavedLightValue(wl.b, par2, par3, par4 - 1L) - par6;
      int k1 = this.getSavedLightValue(wl.b, par2, par3, par4 + 1L) - par6;
      if (j > i) {
         i = j;
      }

      if (k > i) {
         i = k;
      }

      if (l > i) {
         i = l;
      }

      if (i1 > i) {
         i = i1;
      }

      if (j1 > i) {
         i = j1;
      }

      if (k1 > i) {
         i = k1;
      }

      return i;
   }

   public void updateLightByType(wl par1EnumSkyBlock, long par2, int par3, long par4) {
      if (this.doChunksNearChunkExist(par2, par3, par4, 17)) {
         int i = 0;
         int j = 0;
         lv.a("getBrightness");
         int k = this.getSavedLightValue(par1EnumSkyBlock, par2, par3, par4);
         int i1 = 0;
         int k1 = k;
         int j2 = this.getBlockId(par2, par3, par4);
         int i3 = this.func_48462_d(par2, par3, par4);
         if (i3 == 0) {
            i3 = 1;
         }

         int l3 = 0;
         if (par1EnumSkyBlock == wl.a) {
            l3 = this.computeSkyLightValue(k1, par2, par3, par4, j2, i3);
         } else {
            l3 = this.computeBlockLightValue(k1, par2, par3, par4, j2, i3);
         }

         i1 = l3;
         if (i1 > k) {
            this.E[j++] = 133152;
         } else if (i1 < k) {
            if (par1EnumSkyBlock == wl.b) {
            }

            this.E[j++] = 133152 + (k << 18);

            while (i < j) {
               int l1 = this.E[i++];
               long k2 = (l1 & 63) - 32 + par2;
               int j3 = (l1 >> 6 & 63) - 32 + par3;
               long i4 = (l1 >> 12 & 63) - 32 + par4;
               int k4 = l1 >> 18 & 15;
               int i5 = this.getSavedLightValue(par1EnumSkyBlock, k2, j3, i4);
               if (i5 == k4) {
                  this.setLightValue(par1EnumSkyBlock, k2, j3, i4, 0);
                  if (k4 > 0) {
                     long l5 = k2 - par2;
                     int j6 = j3 - par3;
                     long l6 = i4 - par4;
                     if (l5 < 0L) {
                        l5 = -l5;
                     }

                     if (j6 < 0) {
                        j6 = -j6;
                     }

                     if (l6 < 0L) {
                        l6 = -l6;
                     }

                     if (l5 + j6 + l6 < 17L) {
                        for (int j7 = 0; j7 < 6; j7++) {
                           int k7 = j7 % 2 * 2 - 1;
                           long l7 = k2 + j7 / 2 % 3 / 2 * k7;
                           int i8 = j3 + (j7 / 2 + 1) % 3 / 2 * k7;
                           long j8 = i4 + (j7 / 2 + 2) % 3 / 2 * k7;
                           int j5 = this.getSavedLightValue(par1EnumSkyBlock, l7, i8, j8);
                           int k8 = Block.o[this.getBlockId(l7, i8, j8)];
                           if (k8 == 0) {
                              k8 = 1;
                           }

                           if (j5 == k4 - k8 && j < this.E.length) {
                              this.E[j++] = (int)(l7 - par2) + 32 + (i8 - par3 + 32 << 6) + ((int)(j8 - par4) + 32 << 12) + (k4 - k8 << 18);
                           }
                        }
                     }
                  }
               }
            }

            i = 0;
         }

         lv.b();
         lv.a("tcp < tcc");

         while (i < j) {
            int l = this.E[i++];
            long j1 = (l & 63) - 32 + par2;
            int i2 = (l >> 6 & 63) - 32 + par3;
            long l2 = (l >> 12 & 63) - 32 + par4;
            int k3 = this.getSavedLightValue(par1EnumSkyBlock, j1, i2, l2);
            int j4 = this.getBlockId(j1, i2, l2);
            int l4 = Block.o[j4];
            if (l4 == 0) {
               l4 = 1;
            }

            int k5 = 0;
            if (par1EnumSkyBlock == wl.a) {
               k5 = this.computeSkyLightValue(k3, j1, i2, l2, j4, l4);
            } else {
               k5 = this.computeBlockLightValue(k3, j1, i2, l2, j4, l4);
            }

            if (k5 != k3) {
               this.setLightValue(par1EnumSkyBlock, j1, i2, l2, k5);
               if (k5 > k3) {
                  long i6 = j1 - par2;
                  int k6 = i2 - par3;
                  long i7 = l2 - par4;
                  if (i6 < 0L) {
                     i6 = -i6;
                  }

                  if (k6 < 0) {
                     k6 = -k6;
                  }

                  if (i7 < 0L) {
                     i7 = -i7;
                  }

                  if (i6 + k6 + i7 < 17L && j < this.E.length - 6) {
                     if (this.getSavedLightValue(par1EnumSkyBlock, j1 - 1L, i2, l2) < k5) {
                        this.E[j++] = (int)(j1 - 1L - par2) + 32 + (i2 - par3 + 32 << 6) + ((int)(l2 - par4) + 32 << 12);
                     }

                     if (this.getSavedLightValue(par1EnumSkyBlock, j1 + 1L, i2, l2) < k5) {
                        this.E[j++] = (int)(j1 + 1L - par2) + 32 + (i2 - par3 + 32 << 6) + ((int)(l2 - par4) + 32 << 12);
                     }

                     if (this.getSavedLightValue(par1EnumSkyBlock, j1, i2 - 1, l2) < k5) {
                        this.E[j++] = (int)(j1 - par2) + 32 + (i2 - 1 - par3 + 32 << 6) + ((int)(l2 - par4) + 32 << 12);
                     }

                     if (this.getSavedLightValue(par1EnumSkyBlock, j1, i2 + 1, l2) < k5) {
                        this.E[j++] = (int)(j1 - par2) + 32 + (i2 + 1 - par3 + 32 << 6) + ((int)(l2 - par4) + 32 << 12);
                     }

                     if (this.getSavedLightValue(par1EnumSkyBlock, j1, i2, l2 - 1L) < k5) {
                        this.E[j++] = (int)(j1 - par2) + 32 + (i2 - par3 + 32 << 6) + ((int)(l2 - 1L - par4) + 32 << 12);
                     }

                     if (this.getSavedLightValue(par1EnumSkyBlock, j1, i2, l2 + 1L) < k5) {
                        this.E[j++] = (int)(j1 - par2) + 32 + (i2 - par3 + 32 << 6) + ((int)(l2 + 1L - par4) + 32 << 12);
                     }
                  }
               }
            }
         }

         lv.b();
      }
   }

   public boolean a(boolean par1) {
      int i = this.H.size();
      if (i != this.I.size()) {
         throw new IllegalStateException("TickNextTick list out of synch");
      }

      if (i > 1000) {
         i = 1000;
      }

      for (int j = 0; j < i; j++) {
         NextTickListEntry nextticklistentry = (NextTickListEntry)this.H.first();
         if (!par1 && nextticklistentry.e > this.x.f()) {
            break;
         }

         this.H.remove(nextticklistentry);
         this.I.remove(nextticklistentry);
         byte byte0 = 8;
         if (this.checkChunksExist(
            nextticklistentry.a - byte0,
            nextticklistentry.b - byte0,
            nextticklistentry.c - byte0,
            nextticklistentry.a + byte0,
            nextticklistentry.b + byte0,
            nextticklistentry.c + byte0
         )) {
            int k = this.getBlockId(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
            if (k == nextticklistentry.d && k > 0) {
               Block.m[k].updateTick(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.r);
            }
         }
      }

      return this.H.size() != 0;
   }

   public List a(Chunk par1Chunk, boolean par2) {
      ArrayList arraylist = null;
      ChunkCoordIntPair chunkcoordintpair = par1Chunk.l();
      long i = chunkcoordintpair.a << 4;
      long j = i + 16L;
      long k = chunkcoordintpair.b << 4;
      long l = k + 16L;
      Iterator iterator = this.I.iterator();

      while (iterator.hasNext()) {
         NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();
         if (nextticklistentry.a >= i && nextticklistentry.a < j && nextticklistentry.c >= k && nextticklistentry.c < l) {
            if (par2) {
               this.H.remove(nextticklistentry);
               iterator.remove();
            }

            if (arraylist == null) {
               arraylist = new ArrayList();
            }

            arraylist.add(nextticklistentry);
         }
      }

      return arraylist;
   }

   public void randomDisplayUpdates(long par1, int par2, long par3) {
      byte byte0 = 16;
      Random random = new Random();

      for (int i = 0; i < 1000; i++) {
         long j = par1 + this.r.nextInt(byte0) - this.r.nextInt(byte0);
         int k = par2 + this.r.nextInt(byte0) - this.r.nextInt(byte0);
         long l = par3 + this.r.nextInt(byte0) - this.r.nextInt(byte0);
         int i1 = this.getBlockId(j, k, l);
         if (i1 == 0 && this.r.nextInt(8) > k && this.t.j()) {
            this.a("depthsuspend", (double)j + this.r.nextFloat(), (double)k + this.r.nextFloat(), (double)l + this.r.nextFloat(), 0.0, 0.0, 0.0);
         } else if (i1 > 0) {
            Block.m[i1].randomDisplayTick(this, j, k, l, random);
         }
      }
   }

   public List b(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB) {
      this.S.clear();
      long i = MathHelper.d((par2AxisAlignedBB.a - 2.0) / 16.0);
      long j = MathHelper.d((par2AxisAlignedBB.d + 2.0) / 16.0);
      long k = MathHelper.d((par2AxisAlignedBB.c - 2.0) / 16.0);
      long l = MathHelper.d((par2AxisAlignedBB.f + 2.0) / 16.0);

      for (long i1 = i; i1 <= j; i1++) {
         for (long j1 = k; j1 <= l; j1++) {
            if (this.chunkExists(i1, j1)) {
               this.getChunkFromChunkCoords(i1, j1).a(par1Entity, par2AxisAlignedBB, this.S);
            }
         }
      }

      return this.S;
   }

   public List a(Class par1Class, AxisAlignedBB par2AxisAlignedBB) {
      long i = MathHelper.d((par2AxisAlignedBB.a - 2.0) / 16.0);
      long j = MathHelper.d((par2AxisAlignedBB.d + 2.0) / 16.0);
      long k = MathHelper.d((par2AxisAlignedBB.c - 2.0) / 16.0);
      long l = MathHelper.d((par2AxisAlignedBB.f + 2.0) / 16.0);
      ArrayList arraylist = new ArrayList();

      for (long i1 = i; i1 <= j; i1++) {
         for (long j1 = k; j1 <= l; j1++) {
            if (this.chunkExists(i1, j1)) {
               this.getChunkFromChunkCoords(i1, j1).a(par1Class, par2AxisAlignedBB, arraylist);
            }
         }
      }

      return arraylist;
   }

   public Entity a(Class par1Class, AxisAlignedBB par2AxisAlignedBB, Entity par3Entity) {
      List list = this.a(par1Class, par2AxisAlignedBB);
      Entity entity = null;
      double d = Double.MAX_VALUE;

      for (Entity entity1 : list) {
         if (entity1 != par3Entity) {
            double d1 = par3Entity.f(entity1);
            if (d1 <= d) {
               entity = entity1;
               d = d1;
            }
         }
      }

      return entity;
   }

   public List s() {
      return this.b;
   }

   public void updateTileEntityChunkAndDoNothing(long par1, int par2, long par3, TileEntity par4TileEntity) {
      if (this.blockExists(par1, par2, par3)) {
         this.getChunkFromBlockCoords(par1, par3).f();
      }

      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).doNothingWithTileEntity(par1, par2, par3, par4TileEntity);
      }
   }

   public int b(Class par1Class) {
      int i = 0;

      for (int j = 0; j < this.b.size(); j++) {
         Entity entity = (Entity)this.b.get(j);
         if (par1Class.isAssignableFrom(entity.getClass())) {
            i++;
         }
      }

      return i;
   }

   public void a(List par1List) {
      this.b.addAll(par1List);

      for (int i = 0; i < par1List.size(); i++) {
         this.c((Entity)par1List.get(i));
      }
   }

   public void b(List par1List) {
      this.G.addAll(par1List);
   }

   public void t() {
      while (this.v.a()) {
      }
   }

   public boolean canBlockBePlacedAt(int par1, long par2, int par3, long par4, boolean par5, int par6) {
      int i = this.getBlockId(par2, par3, par4);
      Block block = Block.m[i];
      Block block1 = Block.m[par1];
      AxisAlignedBB axisalignedbb = block1.getCollisionBoundingBoxFromPool(this, par2, par3, par4);
      if (par5) {
         axisalignedbb = null;
      }

      if (axisalignedbb != null && !this.a(axisalignedbb)) {
         return false;
      }

      if (block != null && (block == Block.A || block == Block.B || block == Block.C || block == Block.D || block == Block.ar || block.cd.i())) {
         block = null;
      }

      return par1 > 0 && block == null && block1.canPlaceBlockOnSide(this, par2, par3, par4, par6);
   }

   public PathEntity a(Entity par1Entity, Entity par2Entity, float par3, boolean par4, boolean par5, boolean par6, boolean par7) {
      lv.a("pathfind");
      long i = MathHelper.d(par1Entity.o);
      int j = MathHelper.c(par1Entity.p + 1.0);
      long k = MathHelper.d(par1Entity.q);
      int l = (int)(par3 + 16.0F);
      long i1 = i - l;
      int j1 = j - l;
      long k1 = k - l;
      long l1 = i + l;
      int i2 = j + l;
      long j2 = k + l;
      ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2);
      PathEntity pathentity = new PathFinder(chunkcache, par4, par5, par6, par7).a(par1Entity, par2Entity, par3);
      lv.b();
      return pathentity;
   }

   public PathEntity getEntityPathToXYZ(Entity par1Entity, long par2, int par3, long par4, float par5, boolean par6, boolean par7, boolean par8, boolean par9) {
      lv.a("pathfind");
      long i = MathHelper.d(par1Entity.o);
      int j = MathHelper.c(par1Entity.p);
      long k = MathHelper.d(par1Entity.q);
      int l = (int)(par5 + 8.0F);
      long i1 = i - l;
      int j1 = j - l;
      long k1 = k - l;
      long l1 = i + l;
      int i2 = j + l;
      long j2 = k + l;
      ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2);
      PathEntity pathentity = new PathFinder(chunkcache, par6, par7, par8, par9).createEntityPathTo(par1Entity, par2, par3, par4, par5);
      lv.b();
      return pathentity;
   }

   public boolean isBlockProvidingPowerTo(long par1, int par2, long par3, int par4) {
      int i = this.getBlockId(par1, par2, par3);
      return i == 0 ? false : Block.m[i].isIndirectlyPoweringTo(this, par1, par2, par3, par4);
   }

   public boolean isBlockGettingPowered(long par1, int par2, long par3) {
      if (this.isBlockProvidingPowerTo(par1, par2 - 1, par3, 0)) {
         return true;
      } else if (this.isBlockProvidingPowerTo(par1, par2 + 1, par3, 1)) {
         return true;
      } else if (this.isBlockProvidingPowerTo(par1, par2, par3 - 1L, 2)) {
         return true;
      } else if (this.isBlockProvidingPowerTo(par1, par2, par3 + 1L, 3)) {
         return true;
      } else {
         return this.isBlockProvidingPowerTo(par1 - 1L, par2, par3, 4) ? true : this.isBlockProvidingPowerTo(par1 + 1L, par2, par3, 5);
      }
   }

   public boolean isBlockIndirectlyProvidingPowerTo(long par1, int par2, long par3, int par4) {
      if (this.isBlockNormalCube(par1, par2, par3)) {
         return this.isBlockGettingPowered(par1, par2, par3);
      }

      int i = this.getBlockId(par1, par2, par3);
      return i == 0 ? false : Block.m[i].isPoweringTo(this, par1, par2, par3, par4);
   }

   public boolean isBlockIndirectlyGettingPowered(long par1, int par2, long par3) {
      if (this.isBlockIndirectlyProvidingPowerTo(par1, par2 - 1, par3, 0)) {
         return true;
      } else if (this.isBlockIndirectlyProvidingPowerTo(par1, par2 + 1, par3, 1)) {
         return true;
      } else if (this.isBlockIndirectlyProvidingPowerTo(par1, par2, par3 - 1L, 2)) {
         return true;
      } else if (this.isBlockIndirectlyProvidingPowerTo(par1, par2, par3 + 1L, 3)) {
         return true;
      } else {
         return this.isBlockIndirectlyProvidingPowerTo(par1 - 1L, par2, par3, 4) ? true : this.isBlockIndirectlyProvidingPowerTo(par1 + 1L, par2, par3, 5);
      }
   }

   public EntityPlayer a(Entity par1Entity, double par2) {
      return this.a(par1Entity.o, par1Entity.p, par1Entity.q, par2);
   }

   public EntityPlayer a(double par1, double par3, double par5, double par7) {
      double d = -1.0;
      EntityPlayer entityplayer = null;

      for (int i = 0; i < this.d.size(); i++) {
         EntityPlayer entityplayer1 = (EntityPlayer)this.d.get(i);
         double d1 = entityplayer1.f(par1, par3, par5);
         if ((par7 < 0.0 || d1 < par7 * par7) && (d == -1.0 || d1 < d)) {
            d = d1;
            entityplayer = entityplayer1;
         }
      }

      return entityplayer;
   }

   public EntityPlayer a(double par1, double par3, double par5) {
      double d = -1.0;
      EntityPlayer entityplayer = null;

      for (int i = 0; i < this.d.size(); i++) {
         EntityPlayer entityplayer1 = (EntityPlayer)this.d.get(i);
         double d1 = entityplayer1.f(par1, entityplayer1.p, par3);
         if ((par5 < 0.0 || d1 < par5 * par5) && (d == -1.0 || d1 < d)) {
            d = d1;
            entityplayer = entityplayer1;
         }
      }

      return entityplayer;
   }

   public EntityPlayer b(Entity par1Entity, double par2) {
      return this.b(par1Entity.o, par1Entity.p, par1Entity.q, par2);
   }

   public EntityPlayer b(double par1, double par3, double par5, double par7) {
      double d = -1.0;
      EntityPlayer entityplayer = null;

      for (int i = 0; i < this.d.size(); i++) {
         EntityPlayer entityplayer1 = (EntityPlayer)this.d.get(i);
         if (!entityplayer1.aT.a) {
            double d1 = entityplayer1.f(par1, par3, par5);
            if ((par7 < 0.0 || d1 < par7 * par7) && (d == -1.0 || d1 < d)) {
               d = d1;
               entityplayer = entityplayer1;
            }
         }
      }

      return entityplayer;
   }

   public EntityPlayer a(String par1Str) {
      for (int i = 0; i < this.d.size(); i++) {
         if (par1Str.equals(((EntityPlayer)this.d.get(i)).aA)) {
            return (EntityPlayer)this.d.get(i);
         }
      }

      return null;
   }

   public void g() {
   }

   public void u() {
      this.w.b();
   }

   public void a(long par1) {
      this.x.a(par1);
   }

   public long v() {
      return this.x.b();
   }

   public long w() {
      return this.x.f();
   }

   public ChunkCoordinates x() {
      return new ChunkCoordinates(this.x.getSpawnX(), this.x.d(), this.x.getSpawnZ());
   }

   public void a(ChunkCoordinates par1ChunkCoordinates) {
      this.x.setSpawnPosition(par1ChunkCoordinates.a, par1ChunkCoordinates.b, par1ChunkCoordinates.c);
   }

   public void g(Entity par1Entity) {
      long i = MathHelper.d(par1Entity.o / 16.0);
      long j = MathHelper.d(par1Entity.q / 16.0);
      byte byte0 = 2;

      for (long k = i - byte0; k <= i + byte0; k++) {
         for (long l = j - byte0; l <= j + byte0; l++) {
            this.getChunkFromChunkCoords(k, l);
         }
      }

      if (!this.b.contains(par1Entity)) {
         this.b.add(par1Entity);
      }
   }

   public boolean canMineBlock(EntityPlayer par1EntityPlayer, long par2, int par3, long i) {
      return true;
   }

   public void a(Entity entity, byte byte0) {
   }

   public void y() {
      this.b.removeAll(this.G);

      for (int i = 0; i < this.G.size(); i++) {
         Entity entity = (Entity)this.G.get(i);
         long l = entity.BlockTNT;
         long j1 = entity.ag;
         if (entity.ad && this.chunkExists(l, j1)) {
            this.getChunkFromChunkCoords(l, j1).b(entity);
         }
      }

      for (int j = 0; j < this.G.size(); j++) {
         this.d((Entity)this.G.get(j));
      }

      this.G.clear();

      for (int k = 0; k < this.b.size(); k++) {
         Entity entity1 = (Entity)this.b.get(k);
         if (entity1.j != null) {
            if (!entity1.j.G && entity1.j.i == entity1) {
               continue;
            }

            entity1.j.i = null;
            entity1.j = null;
         }

         if (entity1.G) {
            long i1 = entity1.BlockTNT;
            long k1 = entity1.ag;
            if (entity1.ad && this.chunkExists(i1, k1)) {
               this.getChunkFromChunkCoords(i1, k1).b(entity1);
            }

            this.b.remove(k--);
            this.d(entity1);
         }
      }
   }

   public IChunkProvider z() {
      return this.v;
   }

   public void playNoteAt(long par1, int par2, long par3, int par4, int par5) {
      int i = this.getBlockId(par1, par2, par3);
      if (i > 0) {
         Block.m[i].powerBlock(this, par1, par2, par3, par4, par5);
      }
   }

   public akp A() {
      return this.w;
   }

   public WorldInfo B() {
      return this.x;
   }

   public void C() {
      this.N = !this.d.isEmpty();

      for (EntityPlayer entityplayer : this.d) {
         if (!entityplayer.TileEntityDispenser()) {
            this.N = false;
            break;
         }
      }
   }

   protected void D() {
      this.N = false;

      for (EntityPlayer entityplayer : this.d) {
         if (entityplayer.TileEntityDispenser()) {
            entityplayer.a(false, false, true);
         }
      }

      this.L();
   }

   public boolean E() {
      if (this.N && !this.F) {
         for (EntityPlayer entityplayer : this.d) {
            if (!entityplayer.aA()) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public float i(float par1) {
      return (this.k + (this.l - this.k) * par1) * this.j(par1);
   }

   public float j(float par1) {
      return this.i + (this.j - this.i) * par1;
   }

   public void k(float par1) {
      this.i = par1;
      this.j = par1;
   }

   public boolean F() {
      return this.i(1.0F) > 0.9;
   }

   public boolean G() {
      return this.j(1.0F) > 0.2;
   }

   public boolean canLightningStrikeAt(long par1, int par2, long par3) {
      if (!this.G()) {
         return false;
      }

      if (!this.canBlockSeeTheSky(par1, par2, par3)) {
         return false;
      }

      if (this.getPrecipitationHeight(par1, par3) > par2) {
         return false;
      }

      BiomeGenBase biomegenbase = this.getBiomeGenForCoords(par1, par3);
      return biomegenbase.c() ? false : biomegenbase.d();
   }

   public boolean isBlockHighHumidity(long par1, int par2, long par3) {
      BiomeGenBase biomegenbase = this.getBiomeGenForCoords(par1, par3);
      return biomegenbase.e();
   }

   public void a(String par1Str, zk par2WorldSavedData) {
      this.z.a(par1Str, par2WorldSavedData);
   }

   public zk a(Class par1Class, String par2Str) {
      return this.z.a(par1Class, par2Str);
   }

   public int b(String par1Str) {
      return this.z.a(par1Str);
   }

   public void playAuxSFX(int par1, long par2, int par3, long par4, int par5) {
      this.playAuxSFXAtEntity(null, par1, par2, par3, par4, par5);
   }

   public void playAuxSFXAtEntity(EntityPlayer par1EntityPlayer, int par2, long par3, int par4, long par5, int par6) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).playAuxSFX(par1EntityPlayer, par2, par3, par4, par5, par6);
      }
   }

   public void stupidFuckingMethodSolelyForSprintingBecauseFuckMeIGuess(Entity entity, int option, long x, int y, long z, int blockID, int metadata) {
      for (int i = 0; i < this.u.size(); i++) {
         ((IWorldAccess)this.u.get(i)).stupidFuckingMethodSolelyForSprintingBecauseFuckMeIGuess(entity, option, x, y, z, blockID, metadata);
      }
   }

   @Override
   public int b() {
      return 256;
   }

   public Random setRandomSeed(long par1, long par2, long par3) {
      long l = par1 * 341873128712L + par2 * 132897987541L + this.B().b() + par3;
      this.r.setSeed(l);
      return this.r;
   }

   public boolean H() {
      return false;
   }

   public bg getRandomMob(acf par1EnumCreatureType, long par2, int par3, long par4) {
      List list = this.z().getPossibleCreatures(par1EnumCreatureType, par2, par3, par4);
      return list != null && !list.isEmpty() ? (bg)pk.a(this.r, list) : null;
   }

   public ChunkPosition findClosestStructure(String par1Str, long par2, int par3, long par4) {
      return this.z().findClosestStructure(this, par1Str, par2, par3, par4);
   }

   @Override
   public boolean a() {
      return false;
   }

   public double I() {
      return this.x.t() != vx.c ? 63.0 : 0.0;
   }
}
