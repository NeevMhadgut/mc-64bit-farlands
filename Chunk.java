import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Chunk {
   public static boolean a;
   private zg[] q = new zg[16];
   private byte[] r = new byte[256];
   public int[] b = new int[256];
   public boolean[] c = new boolean[256];
   public boolean d;
   public World e;
   public int[] f;
   public final long g;
   public final long h;
   private boolean s = false;
   public Map i = new HashMap();
   public List[] j;
   public boolean k = false;
   public boolean l = false;
   public boolean m = false;
   public long n = 0L;
   public boolean o = false;
   private int t = 4096;
   boolean p = false;

   public Chunk(World par1World, long par2, long par3) {
      this.j = new List[16];
      this.e = par1World;
      this.g = par2;
      this.h = par3;
      this.f = new int[256];

      for (int i = 0; i < this.j.length; i++) {
         this.j[i] = new ArrayList();
      }

      Arrays.fill(this.b, -999);
      Arrays.fill(this.r, (byte)-1);
   }

   public Chunk(World par1World, byte[] par2ArrayOfByte, long par3, long par4) {
      this(par1World, par3, par4);
      int i = par2ArrayOfByte.length / 256;

      for (int j = 0; j < 16; j++) {
         for (int k = 0; k < 16; k++) {
            for (int l = 0; l < i; l++) {
               byte byte0 = par2ArrayOfByte[j << 11 | k << 7 | l];
               if (byte0 != 0) {
                  int i1 = l >> 4;
                  if (this.q[i1] == null) {
                     this.q[i1] = new zg(i1 << 4);
                  }

                  this.q[i1].a(j, l & 15, k, byte0);
               }
            }
         }
      }
   }

   public boolean isAtLocation(long par1, long par2) {
      return par1 == this.g && par2 == this.h;
   }

   public int b(int par1, int par2) {
      return this.f[par2 << 4 | par1];
   }

   public int h() {
      for (int i = this.q.length - 1; i >= 0; i--) {
         if (this.q[i] != null) {
            return this.q[i].c();
         }
      }

      return 0;
   }

   public zg[] i() {
      return this.q;
   }

   public void a() {
      int i = this.h();

      for (int j = 0; j < 16; j++) {
         for (int k = 0; k < 16; k++) {
            this.b[j + (k << 4)] = -999;

            for (int l = i + 16 - 1; l > 0; l--) {
               int i1 = this.a(j, l - 1, k);
               if (Block.o[i1] != 0) {
                  this.f[k << 4 | j] = l;
                  break;
               }
            }
         }
      }

      this.l = true;
   }

   public void b() {
      int i = this.h();

      for (int j = 0; j < 16; j++) {
         for (int l = 0; l < 16; l++) {
            this.b[j + (l << 4)] = -999;

            for (int j1 = i + 16 - 1; j1 > 0; j1--) {
               if (this.b(j, j1 - 1, l) != 0) {
                  this.f[l << 4 | j] = j1;
                  break;
               }
            }

            if (!this.e.t.e) {
               int var9 = 15;
               int k1 = i + 16 - 1;

               while (true) {
                  var9 -= this.b(j, k1, l);
                  if (var9 > 0) {
                     zg extendedblockstorage = this.q[k1 >> 4];
                     if (extendedblockstorage != null) {
                        extendedblockstorage.c(j, k1 & 15, l, var9);
                        this.e.func_48464_p((this.g << 4) + j, k1, (this.h << 4) + l);
                     }
                  }

                  if (--k1 <= 0 || var9 <= 0) {
                     break;
                  }
               }
            }
         }
      }

      this.l = true;

      for (int k = 0; k < 16; k++) {
         for (int i1 = 0; i1 < 16; i1++) {
            this.e(k, i1);
         }
      }
   }

   public void c() {
   }

   private void e(int par1, int par2) {
      this.c[par1 + par2 * 16] = true;
      this.s = true;
   }

   private void p() {
      lv.a("recheckGaps");
      if (this.e.doChunksNearChunkExist(this.g * 16L + 8L, 0, this.h * 16L + 8L, 16)) {
         for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
               if (this.c[i + j * 16]) {
                  this.c[i + j * 16] = false;
                  int k = this.b(i, j);
                  long l = this.g * 16L + i;
                  long i1 = this.h * 16L + j;
                  int j1 = this.e.getHeightValue(l - 1L, i1);
                  int k1 = this.e.getHeightValue(l + 1L, i1);
                  int l1 = this.e.getHeightValue(l, i1 - 1L);
                  int i2 = this.e.getHeightValue(l, i1 + 1L);
                  if (k1 < j1) {
                     j1 = k1;
                  }

                  if (l1 < j1) {
                     j1 = l1;
                  }

                  if (i2 < j1) {
                     j1 = i2;
                  }

                  this.checkSkylightNeighborHeight(l, i1, j1);
                  this.checkSkylightNeighborHeight(l - 1L, i1, k);
                  this.checkSkylightNeighborHeight(l + 1L, i1, k);
                  this.checkSkylightNeighborHeight(l, i1 - 1L, k);
                  this.checkSkylightNeighborHeight(l, i1 + 1L, k);
               }
            }
         }

         this.s = false;
      }

      lv.b();
   }

   private void checkSkylightNeighborHeight(long par1, long par2, int par3) {
      int i = this.e.getHeightValue(par1, par2);
      if (i > par3) {
         this.updateSkylightNeighborHeight(par1, par2, par3, i + 1);
      } else if (i < par3) {
         this.updateSkylightNeighborHeight(par1, par2, i, par3 + 1);
      }
   }

   private void updateSkylightNeighborHeight(long par1, long par2, int par3, int par4) {
      if (par4 > par3 && this.e.doChunksNearChunkExist(par1, 0, par2, 16)) {
         for (int i = par3; i < par4; i++) {
            this.e.updateLightByType(wl.a, par1, i, par2);
         }

         this.l = true;
      }
   }

   private void h(int par1, int par2, int par3) {
      int i = this.f[par3 << 4 | par1] & 0xFF;
      int j = i;
      if (par2 > i) {
         j = par2;
      }

      while (j > 0 && this.b(par1, j - 1, par3) == 0) {
         j--;
      }

      if (j != i) {
         this.e.markBlocksDirtyVertical(par1, par3, j, i);
         this.f[par3 << 4 | par1] = j;
         long k = this.g * 16L + par1;
         long l = this.h * 16L + par3;
         if (!this.e.t.e) {
            if (j < i) {
               for (int i1 = j; i1 < i; i1++) {
                  zg extendedblockstorage = this.q[i1 >> 4];
                  if (extendedblockstorage != null) {
                     extendedblockstorage.c(par1, i1 & 15, par3, 15);
                     this.e.func_48464_p((this.g << 4) + par1, i1, (this.h << 4) + par3);
                  }
               }
            } else {
               for (int j1 = i; j1 < j; j1++) {
                  zg extendedblockstorage1 = this.q[j1 >> 4];
                  if (extendedblockstorage1 != null) {
                     extendedblockstorage1.c(par1, j1 & 15, par3, 0);
                     this.e.func_48464_p((this.g << 4) + par1, j1, (this.h << 4) + par3);
                  }
               }
            }

            int k1 = 15;

            while (j > 0 && k1 > 0) {
               int i2 = this.b(par1, --j, par3);
               if (i2 == 0) {
                  i2 = 1;
               }

               k1 -= i2;
               if (k1 < 0) {
                  k1 = 0;
               }

               zg extendedblockstorage2 = this.q[j >> 4];
               if (extendedblockstorage2 != null) {
                  extendedblockstorage2.c(par1, j & 15, par3, k1);
               }
            }
         }

         int l1 = this.f[par3 << 4 | par1];
         int j2 = i;
         int k2 = l1;
         if (k2 < j2) {
            int l2 = j2;
            j2 = k2;
            k2 = l2;
         }

         if (!this.e.t.e) {
            this.updateSkylightNeighborHeight(k - 1L, l, j2, k2);
            this.updateSkylightNeighborHeight(k + 1L, l, j2, k2);
            this.updateSkylightNeighborHeight(k, l - 1L, j2, k2);
            this.updateSkylightNeighborHeight(k, l + 1L, j2, k2);
            this.updateSkylightNeighborHeight(k, l, j2, k2);
         }

         this.l = true;
      }
   }

   public int b(int par1, int par2, int par3) {
      return Block.o[this.a(par1, par2, par3)];
   }

   public int a(int par1, int par2, int par3) {
      if (par2 >> 4 >= this.q.length) {
         return 0;
      }

      zg extendedblockstorage = this.q[par2 >> 4];
      return extendedblockstorage != null ? extendedblockstorage.a(par1, par2 & 15, par3) : 0;
   }

   public int c(int par1, int par2, int par3) {
      if (par2 >> 4 >= this.q.length) {
         return 0;
      }

      zg extendedblockstorage = this.q[par2 >> 4];
      return extendedblockstorage != null ? extendedblockstorage.b(par1, par2 & 15, par3) : 0;
   }

   public boolean a(int par1, int par2, int par3, int par4) {
      return this.a(par1, par2, par3, par4, 0);
   }

   public boolean a(int par1, int par2, int par3, int par4, int par5) {
      int i = par3 << 4 | par1;
      if (par2 >= this.b[i] - 1) {
         this.b[i] = -999;
      }

      int j = this.f[i];
      int k = this.a(par1, par2, par3);
      if (k == par4 && this.c(par1, par2, par3) == par5) {
         return false;
      }

      zg extendedblockstorage = this.q[par2 >> 4];
      boolean flag = false;
      if (extendedblockstorage == null) {
         if (par4 == 0) {
            return false;
         }

         extendedblockstorage = this.q[par2 >> 4] = new zg(par2 >> 4 << 4);
         flag = par2 >= j;
      }

      extendedblockstorage.a(par1, par2 & 15, par3, par4);
      long l = this.g * 16L + par1;
      long i1 = this.h * 16L + par3;
      if (k != 0) {
         if (!this.e.F) {
            Block.m[k].onBlockRemoval(this.e, l, par2, i1);
         } else if (Block.m[k] instanceof BlockContainer && k != par4) {
            this.e.removeBlockTileEntity(l, par2, i1);
         }
      }

      if (extendedblockstorage.a(par1, par2 & 15, par3) != par4) {
         return false;
      }

      extendedblockstorage.b(par1, par2 & 15, par3, par5);
      if (flag) {
         this.b();
      } else {
         if (Block.o[par4 & 4095] > 0) {
            if (par2 >= j) {
               this.h(par1, par2 + 1, par3);
            }
         } else if (par2 == j - 1) {
            this.h(par1, par2, par3);
         }

         this.e(par1, par3);
      }

      if (par4 != 0) {
         if (!this.e.F) {
            Block.m[par4].onBlockAdded(this.e, l, par2, i1);
         }

         if (Block.m[par4] instanceof BlockContainer) {
            TileEntity tileentity = this.e(par1, par2, par3);
            if (tileentity == null) {
               tileentity = ((BlockContainer)Block.m[par4]).u_();
               this.e.setBlockTileEntity(l, par2, i1, tileentity);
            }

            if (tileentity != null) {
               tileentity.b();
            }
         }
      } else if (k > 0 && Block.m[k] instanceof BlockContainer) {
         TileEntity tileentity1 = this.e(par1, par2, par3);
         if (tileentity1 != null) {
            tileentity1.b();
         }
      }

      this.l = true;
      return true;
   }

   public boolean b(int par1, int par2, int par3, int par4) {
      zg extendedblockstorage = this.q[par2 >> 4];
      if (extendedblockstorage == null) {
         return false;
      }

      int i = extendedblockstorage.b(par1, par2 & 15, par3);
      if (i == par4) {
         return false;
      }

      this.l = true;
      extendedblockstorage.b(par1, par2 & 15, par3, par4);
      int j = extendedblockstorage.a(par1, par2 & 15, par3);
      if (j > 0 && Block.m[j] instanceof BlockContainer) {
         TileEntity tileentity = this.e(par1, par2, par3);
         if (tileentity != null) {
            tileentity.b();
            tileentity.n = par4;
         }
      }

      return true;
   }

   public int a(wl par1EnumSkyBlock, int par2, int par3, int par4) {
      zg extendedblockstorage = this.q[par3 >> 4];
      if (extendedblockstorage == null) {
         return par1EnumSkyBlock.c;
      } else if (par1EnumSkyBlock == wl.a) {
         return extendedblockstorage.c(par2, par3 & 15, par4);
      } else {
         return par1EnumSkyBlock == wl.b ? extendedblockstorage.d(par2, par3 & 15, par4) : par1EnumSkyBlock.c;
      }
   }

   public void a(wl par1EnumSkyBlock, int par2, int par3, int par4, int par5) {
      zg extendedblockstorage = this.q[par3 >> 4];
      if (extendedblockstorage == null) {
         extendedblockstorage = this.q[par3 >> 4] = new zg(par3 >> 4 << 4);
         this.b();
      }

      this.l = true;
      if (par1EnumSkyBlock == wl.a) {
         if (!this.e.t.e) {
            extendedblockstorage.c(par2, par3 & 15, par4, par5);
         }
      } else {
         if (par1EnumSkyBlock != wl.b) {
            return;
         }

         extendedblockstorage.d(par2, par3 & 15, par4, par5);
      }
   }

   public int c(int par1, int par2, int par3, int par4) {
      zg extendedblockstorage = this.q[par2 >> 4];
      if (extendedblockstorage == null) {
         return !this.e.t.e && par4 < wl.a.c ? wl.a.c - par4 : 0;
      }

      int i = this.e.t.e ? 0 : extendedblockstorage.c(par1, par2 & 15, par3);
      if (i > 0) {
         a = true;
      }

      i -= par4;
      int j = extendedblockstorage.d(par1, par2 & 15, par3);
      if (j > i) {
         i = j;
      }

      return i;
   }

   public void a(Entity par1Entity) {
      this.m = true;
      long i = MathHelper.d(par1Entity.o / 16.0);
      long j = MathHelper.d(par1Entity.q / 16.0);
      if (i != this.g || j != this.h) {
         System.out.println("Wrong location! " + par1Entity);
         System.out.println(i + " " + this.g + ", " + j + " " + this.h);
         Thread.dumpStack();
      }

      int k = MathHelper.c(par1Entity.p / 16.0);
      if (k < 0) {
         k = 0;
      }

      if (k >= this.j.length) {
         k = this.j.length - 1;
      }

      par1Entity.ad = true;
      par1Entity.BlockTNT = this.g;
      par1Entity.TileEntityMobSpawnerRenderer = k;
      par1Entity.ag = this.h;
      this.j[k].add(par1Entity);
   }

   public void b(Entity par1Entity) {
      this.a(par1Entity, par1Entity.TileEntityMobSpawnerRenderer);
   }

   public void a(Entity par1Entity, int par2) {
      if (par2 < 0) {
         par2 = 0;
      }

      if (par2 >= this.j.length) {
         par2 = this.j.length - 1;
      }

      this.j[par2].remove(par1Entity);
   }

   public boolean d(int par1, int par2, int par3) {
      return par2 >= this.f[par3 << 4 | par1];
   }

   public TileEntity e(int par1, int par2, int par3) {
      ChunkPosition chunkposition = new ChunkPosition(par1, par2, par3);
      TileEntity tileentity = (TileEntity)this.i.get(chunkposition);
      if (tileentity == null) {
         int i = this.a(par1, par2, par3);
         if (i <= 0 || !Block.m[i].p()) {
            return null;
         }

         if (tileentity == null) {
            tileentity = ((BlockContainer)Block.m[i]).u_();
            this.e.setBlockTileEntity(this.g * 16L + par1, par2, this.h * 16L + par3, tileentity);
         }

         tileentity = (TileEntity)this.i.get(chunkposition);
      }

      if (tileentity != null && tileentity.l()) {
         this.i.remove(chunkposition);
         return null;
      } else {
         return tileentity;
      }
   }

   public void a(TileEntity par1TileEntity) {
      int i = (int)(par1TileEntity.j - this.g * 16L);
      int j = par1TileEntity.k;
      int k = (int)(par1TileEntity.l - this.h * 16L);
      this.a(i, j, k, par1TileEntity);
      if (this.d) {
         this.e.c.add(par1TileEntity);
      }
   }

   public void a(int par1, int par2, int par3, TileEntity par4TileEntity) {
      ChunkPosition chunkposition = new ChunkPosition(par1, par2, par3);
      par4TileEntity.i = this.e;
      par4TileEntity.j = this.g * 16L + par1;
      par4TileEntity.k = par2;
      par4TileEntity.l = this.h * 16L + par3;
      if (this.a(par1, par2, par3) != 0 && Block.m[this.a(par1, par2, par3)] instanceof BlockContainer) {
         par4TileEntity.m();
         this.i.put(chunkposition, par4TileEntity);
      }
   }

   public void f(int par1, int par2, int par3) {
      ChunkPosition chunkposition = new ChunkPosition(par1, par2, par3);
      if (this.d) {
         TileEntity tileentity = (TileEntity)this.i.remove(chunkposition);
         if (tileentity != null) {
            tileentity.h();
         }
      }
   }

   public void d() {
      this.d = true;
      this.e.a(this.i.values());

      for (int i = 0; i < this.j.length; i++) {
         this.e.a(this.j[i]);
      }
   }

   public void e() {
      this.d = false;

      for (TileEntity tileentity : this.i.values()) {
         this.e.a(tileentity);
      }

      for (int i = 0; i < this.j.length; i++) {
         this.e.b(this.j[i]);
      }
   }

   public void f() {
      this.l = true;
   }

   public void a(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB, List par3List) {
      int i = MathHelper.c((par2AxisAlignedBB.b - 2.0) / 16.0);
      int j = MathHelper.c((par2AxisAlignedBB.e + 2.0) / 16.0);
      if (i < 0) {
         i = 0;
      }

      if (j >= this.j.length) {
         j = this.j.length - 1;
      }

      for (int k = i; k <= j; k++) {
         List list = this.j[k];

         for (int l = 0; l < list.size(); l++) {
            Entity entity = (Entity)list.get(l);
            if (entity != par1Entity && entity.y.a(par2AxisAlignedBB)) {
               par3List.add(entity);
               Entity[] aentity = entity.Z();
               if (aentity != null) {
                  for (int i1 = 0; i1 < aentity.length; i1++) {
                     Entity entity1 = aentity[i1];
                     if (entity1 != par1Entity && entity1.y.a(par2AxisAlignedBB)) {
                        par3List.add(entity1);
                     }
                  }
               }
            }
         }
      }
   }

   public void a(Class par1Class, AxisAlignedBB par2AxisAlignedBB, List par3List) {
      int i = MathHelper.c((par2AxisAlignedBB.b - 2.0) / 16.0);
      int j = MathHelper.c((par2AxisAlignedBB.e + 2.0) / 16.0);
      if (i < 0) {
         i = 0;
      } else if (i >= this.j.length) {
         i = this.j.length - 1;
      }

      if (j >= this.j.length) {
         j = this.j.length - 1;
      } else if (j < 0) {
         j = 0;
      }

      for (int k = i; k <= j; k++) {
         List list = this.j[k];

         for (int l = 0; l < list.size(); l++) {
            Entity entity = (Entity)list.get(l);
            if (par1Class.isAssignableFrom(entity.getClass()) && entity.y.a(par2AxisAlignedBB)) {
               par3List.add(entity);
            }
         }
      }
   }

   public boolean a(boolean par1) {
      if (par1) {
         if (this.m && this.e.w() != this.n) {
            return true;
         }
      } else if (this.m && this.e.w() >= this.n + 600L) {
         return true;
      }

      return this.l;
   }

   public Random a(long par1) {
      return new Random(this.e.v() + this.g * this.g * 4987142L + this.g * 5947611L + this.h * this.h * 4392871L + this.h * 389711L ^ par1);
   }

   public boolean g() {
      return false;
   }

   public void j() {
      for (zg extendedblockstorage : this.q) {
         if (extendedblockstorage != null) {
            extendedblockstorage.e();
         }
      }
   }

   public void populateChunk(IChunkProvider par1IChunkProvider, IChunkProvider par2IChunkProvider, long par3, long par4) {
      if (!this.k
         && par1IChunkProvider.chunkExists(par3 + 1L, par4 + 1L)
         && par1IChunkProvider.chunkExists(par3, par4 + 1L)
         && par1IChunkProvider.chunkExists(par3 + 1L, par4)) {
         par1IChunkProvider.populate(par2IChunkProvider, par3, par4);
      }

      if (par1IChunkProvider.chunkExists(par3 - 1L, par4)
         && !par1IChunkProvider.provideChunk(par3 - 1L, par4).k
         && par1IChunkProvider.chunkExists(par3 - 1L, par4 + 1L)
         && par1IChunkProvider.chunkExists(par3, par4 + 1L)
         && par1IChunkProvider.chunkExists(par3 - 1L, par4 + 1L)) {
         par1IChunkProvider.populate(par2IChunkProvider, par3 - 1L, par4);
      }

      if (par1IChunkProvider.chunkExists(par3, par4 - 1L)
         && !par1IChunkProvider.provideChunk(par3, par4 - 1L).k
         && par1IChunkProvider.chunkExists(par3 + 1L, par4 - 1L)
         && par1IChunkProvider.chunkExists(par3 + 1L, par4 - 1L)
         && par1IChunkProvider.chunkExists(par3 + 1L, par4)) {
         par1IChunkProvider.populate(par2IChunkProvider, par3, par4 - 1L);
      }

      if (par1IChunkProvider.chunkExists(par3 - 1L, par4 - 1L)
         && !par1IChunkProvider.provideChunk(par3 - 1L, par4 - 1L).k
         && par1IChunkProvider.chunkExists(par3, par4 - 1L)
         && par1IChunkProvider.chunkExists(par3 - 1L, par4)) {
         par1IChunkProvider.populate(par2IChunkProvider, par3 - 1L, par4 - 1L);
      }
   }

   public int d(int par1, int par2) {
      int i = par1 | par2 << 4;
      int j = this.b[i];
      if (j == -999) {
         int k = this.h() + 15;
         j = -1;

         while (k > 0 && j == -1) {
            int l = this.a(par1, k, par2);
            acn material = l != 0 ? Block.m[l].cd : acn.a;
            if (!material.c() && !material.d()) {
               k--;
            } else {
               j = k + 1;
            }
         }

         this.b[i] = j;
      }

      return j;
   }

   public void k() {
      if (this.s && !this.e.t.e) {
         this.p();
      }
   }

   public ChunkCoordIntPair l() {
      return new ChunkCoordIntPair(this.g, this.h);
   }

   public boolean c(int par1, int par2) {
      if (par1 < 0) {
         par1 = 0;
      }

      if (par2 >= 256) {
         par2 = 255;
      }

      for (int i = par1; i <= par2; i += 16) {
         zg extendedblockstorage = this.q[i >> 4];
         if (extendedblockstorage != null && !extendedblockstorage.a()) {
            return false;
         }
      }

      return true;
   }

   public void a(zg[] par1ArrayOfExtendedBlockStorage) {
      this.q = par1ArrayOfExtendedBlockStorage;
   }

   public void a(byte[] par1ArrayOfByte, int par2, int par3, boolean par4) {
      int i = 0;

      for (int j = 0; j < this.q.length; j++) {
         if ((par2 & 1 << j) != 0) {
            if (this.q[j] == null) {
               this.q[j] = new zg(j << 4);
            }

            byte[] abyte0 = this.q[j].g();
            System.arraycopy(par1ArrayOfByte, i, abyte0, 0, abyte0.length);
            i += abyte0.length;
         } else if (par4 && this.q[j] != null) {
            this.q[j] = null;
         }
      }

      for (int k = 0; k < this.q.length; k++) {
         if ((par2 & 1 << k) != 0 && this.q[k] != null) {
            qq nibblearray = this.q[k].j();
            System.arraycopy(par1ArrayOfByte, i, nibblearray.a, 0, nibblearray.a.length);
            i += nibblearray.a.length;
         }
      }

      for (int l = 0; l < this.q.length; l++) {
         if ((par2 & 1 << l) != 0 && this.q[l] != null) {
            qq nibblearray1 = this.q[l].k();
            System.arraycopy(par1ArrayOfByte, i, nibblearray1.a, 0, nibblearray1.a.length);
            i += nibblearray1.a.length;
         }
      }

      for (int i1 = 0; i1 < this.q.length; i1++) {
         if ((par2 & 1 << i1) != 0 && this.q[i1] != null) {
            qq nibblearray2 = this.q[i1].l();
            System.arraycopy(par1ArrayOfByte, i, nibblearray2.a, 0, nibblearray2.a.length);
            i += nibblearray2.a.length;
         }
      }

      for (int j1 = 0; j1 < this.q.length; j1++) {
         if ((par3 & 1 << j1) != 0) {
            if (this.q[j1] == null) {
               i += 2048;
            } else {
               qq nibblearray3 = this.q[j1].i();
               if (nibblearray3 == null) {
                  nibblearray3 = this.q[j1].m();
               }

               System.arraycopy(par1ArrayOfByte, i, nibblearray3.a, 0, nibblearray3.a.length);
               i += nibblearray3.a.length;
            }
         } else if (par4 && this.q[j1] != null && this.q[j1].i() != null) {
            this.q[j1].h();
         }
      }

      if (par4) {
         System.arraycopy(par1ArrayOfByte, i, this.r, 0, this.r.length);
         i += this.r.length;
      }

      for (int k1 = 0; k1 < this.q.length; k1++) {
         if (this.q[k1] != null && (par2 & 1 << k1) != 0) {
            this.q[k1].d();
         }
      }

      this.a();

      for (TileEntity tileentity : this.i.values()) {
         tileentity.b();
      }
   }

   public BiomeGenBase a(int par1, int par2, WorldChunkManager par3WorldChunkManager) {
      int i = this.r[par2 << 4 | par1] & 255;
      if (i == 255) {
         BiomeGenBase biomegenbase = par3WorldChunkManager.getBiomeGenAt((this.g << 4) + par1, (this.h << 4) + par2);
         i = biomegenbase.M;
         this.r[par2 << 4 | par1] = (byte)(i & 0xFF);
      }

      return BiomeGenBase.a[i] == null ? BiomeGenBase.c : BiomeGenBase.a[i];
   }

   public byte[] m() {
      return this.r;
   }

   public void a(byte[] par1ArrayOfByte) {
      this.r = par1ArrayOfByte;
   }

   public void n() {
      this.t = 0;
   }

   public void o() {
      for (int i = 0; i < 8; i++) {
         if (this.t >= 4096) {
            return;
         }

         int j = this.t % 16;
         int k = this.t / 16 % 16;
         int l = this.t / 256;
         this.t++;
         long i1 = (this.g << 4) + k;
         long j1 = (this.h << 4) + l;

         for (int k1 = 0; k1 < 16; k1++) {
            int l1 = (j << 4) + k1;
            if (this.q[j] == null && (k1 == 0 || k1 == 15 || k == 0 || k == 15 || l == 0 || l == 15) || this.q[j] != null && this.q[j].a(k, k1, l) == 0) {
               if (Block.q[this.e.getBlockId(i1, l1 - 1, j1)] > 0) {
                  this.e.updateAllLightTypes(i1, l1 - 1, j1);
               }

               if (Block.q[this.e.getBlockId(i1, l1 + 1, j1)] > 0) {
                  this.e.updateAllLightTypes(i1, l1 + 1, j1);
               }

               if (Block.q[this.e.getBlockId(i1 - 1L, l1, j1)] > 0) {
                  this.e.updateAllLightTypes(i1 - 1L, l1, j1);
               }

               if (Block.q[this.e.getBlockId(i1 + 1L, l1, j1)] > 0) {
                  this.e.updateAllLightTypes(i1 + 1L, l1, j1);
               }

               if (Block.q[this.e.getBlockId(i1, l1, j1 - 1L)] > 0) {
                  this.e.updateAllLightTypes(i1, l1, j1 - 1L);
               }

               if (Block.q[this.e.getBlockId(i1, l1, j1 + 1L)] > 0) {
                  this.e.updateAllLightTypes(i1, l1, j1 + 1L);
               }

               this.e.updateAllLightTypes(i1, l1, j1);
            }
         }
      }
   }
}
