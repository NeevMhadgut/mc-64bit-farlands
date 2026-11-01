import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WorldClient extends World {
   private LinkedList G = new LinkedList();
   private NetClientHandler H;
   private ChunkProviderClient I;
   private abh J = new abh();
   private Set K = new HashSet();
   private Set L = new HashSet();

   public WorldClient(NetClientHandler par1NetClientHandler, fj par2WorldSettings, int par3, int par4) {
      super(new akx(), "MpServer", WorldProvider.a(par3), par2WorldSettings);
      this.H = par1NetClientHandler;
      this.q = par4;
      this.a(new ChunkCoordinates(8L, 64, 8L));
      this.z = par1NetClientHandler.b;
   }

   @Override
   public void c() {
      this.a(this.w() + 1L);

      for (int i = 0; i < 10 && !this.L.isEmpty(); i++) {
         Entity entity = (Entity)this.L.iterator().next();
         this.L.remove(entity);
         if (!this.b.contains(entity)) {
            this.a(entity);
         }
      }

      this.H.b();

      for (int j = 0; j < this.G.size(); j++) {
         WorldBlockPositionType worldblockpositiontype = (WorldBlockPositionType)this.G.get(j);
         if (--worldblockpositiontype.d == 0) {
            super.setBlockAndMetadata(
               worldblockpositiontype.a, worldblockpositiontype.b, worldblockpositiontype.c, worldblockpositiontype.e, worldblockpositiontype.f
            );
            super.markBlockNeedsUpdate(worldblockpositiontype.a, worldblockpositiontype.b, worldblockpositiontype.c);
            this.G.remove(j--);
         }
      }

      this.I.a();
      this.f();
   }

   public void invalidateBlockReceiveRegion(long par1, int par2, long par3, long par4, int par5, long par6) {
      for (int i = 0; i < this.G.size(); i++) {
         WorldBlockPositionType worldblockpositiontype = (WorldBlockPositionType)this.G.get(i);
         if (worldblockpositiontype.a >= par1
            && worldblockpositiontype.b >= par2
            && worldblockpositiontype.c >= par3
            && worldblockpositiontype.a <= par4
            && worldblockpositiontype.b <= par5
            && worldblockpositiontype.c <= par6) {
            this.G.remove(i--);
         }
      }
   }

   @Override
   protected IChunkProvider d() {
      this.I = new ChunkProviderClient(this);
      return this.I;
   }

   @Override
   public void e() {
      this.a(new ChunkCoordinates(8L, 64, 8L));
   }

   @Override
   protected void f() {
      this.r();

      for (ChunkCoordIntPair chunkcoordintpair : this.D) {
         long i = chunkcoordintpair.a * 16L;
         long j = chunkcoordintpair.b * 16L;
         lv.a("getChunk");
         Chunk chunk = this.getChunkFromChunkCoords(chunkcoordintpair.a, chunkcoordintpair.b);
         this.func_48458_a(i, j, chunk);
         lv.b();
      }
   }

   @Override
   public void scheduleBlockUpdate(long i, int j, long k, int l, int i1) {
   }

   @Override
   public boolean a(boolean par1) {
      return false;
   }

   public void doPreChunk(long par1, long par2, boolean par3) {
      if (par3) {
         this.I.loadChunk(par1, par2);
      } else {
         this.I.func_539_c(par1, par2);
      }

      if (!par3) {
         this.markBlocksDirty(par1 * 16L, 0, par2 * 16L, par1 * 16L + 15L, 256, par2 * 16L + 15L);
      }
   }

   @Override
   public boolean a(Entity par1Entity) {
      boolean flag = super.a(par1Entity);
      this.K.add(par1Entity);
      if (!flag) {
         this.L.add(par1Entity);
      }

      return flag;
   }

   @Override
   public void b(Entity par1Entity) {
      super.b(par1Entity);
      this.K.remove(par1Entity);
   }

   @Override
   protected void c(Entity par1Entity) {
      super.c(par1Entity);
      if (this.L.contains(par1Entity)) {
         this.L.remove(par1Entity);
      }
   }

   @Override
   protected void d(Entity par1Entity) {
      super.d(par1Entity);
      if (this.K.contains(par1Entity)) {
         if (par1Entity.M()) {
            this.L.add(par1Entity);
         } else {
            this.K.remove(par1Entity);
         }
      }
   }

   public void a(int par1, Entity par2Entity) {
      Entity entity = this.a(par1);
      if (entity != null) {
         this.b(entity);
      }

      this.K.add(par2Entity);
      par2Entity.f = par1;
      if (!this.a(par2Entity)) {
         this.L.add(par2Entity);
      }

      this.J.a(par1, par2Entity);
   }

   public Entity a(int par1) {
      return (Entity)this.J.a(par1);
   }

   public Entity b(int par1) {
      Entity entity = (Entity)this.J.d(par1);
      if (entity != null) {
         this.K.remove(entity);
         this.b(entity);
      }

      return entity;
   }

   public boolean setBlockAndMetadataAndInvalidate(long par1, int par2, long par3, int par4, int par5) {
      this.invalidateBlockReceiveRegion(par1, par2, par3, par1, par2, par3);
      return super.setBlockAndMetadataWithNotify(par1, par2, par3, par4, par5);
   }

   @Override
   public void g() {
      this.H.b(new amg("Quitting"));
   }

   @Override
   protected void h() {
      if (!this.t.e) {
         if (this.m > 0) {
            this.m--;
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
}
