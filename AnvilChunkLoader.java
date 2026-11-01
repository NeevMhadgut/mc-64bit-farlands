import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnvilChunkLoader implements eu, IChunkLoader {
   private List a = new ArrayList();
   private Set b = new HashSet();
   private Object c = new Object();
   private final File d;

   public AnvilChunkLoader(File par1File) {
      this.d = par1File;
   }

   @Override
   public Chunk loadChunk(World par1World, long par2, long par3) throws IOException {
      ady nbttagcompound = null;
      ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(par2, par3);
      synchronized (this.c) {
         if (this.b.contains(chunkcoordintpair)) {
            for (int i = 0; i < this.a.size(); i++) {
               if (((ge)this.a.get(i)).a.equals(chunkcoordintpair)) {
                  nbttagcompound = ((ge)this.a.get(i)).b;
                  break;
               }
            }
         }
      }

      if (nbttagcompound == null) {
         DataInputStream datainputstream = RegionFileCache.getChunkInputStream(this.d, par2, par3);
         if (datainputstream == null) {
            return null;
         }

         nbttagcompound = at.a(datainputstream);
      }

      return this.func_48443_a(par1World, par2, par3, nbttagcompound);
   }

   protected Chunk func_48443_a(World par1World, long par2, long par3, ady par4NBTTagCompound) {
      if (!par4NBTTagCompound.c("Level")) {
         System.out.println("Chunk file at " + par2 + "," + par3 + " EntityAIDoorInteract missing level data, skipping");
         return null;
      }

      if (!par4NBTTagCompound.m("Level").c("Sections")) {
         System.out.println("Chunk file at " + par2 + "," + par3 + " EntityAIDoorInteract missing block data, skipping");
         return null;
      }

      Chunk chunk = this.a(par1World, par4NBTTagCompound.m("Level"));
      if (!chunk.isAtLocation(par2, par3)) {
         System.out
            .println(
               "Chunk file at "
                  + par2
                  + ","
                  + par3
                  + " EntityAIDoorInteract in the wrong location; relocating. (Expected "
                  + par2
                  + ", "
                  + par3
                  + ", got "
                  + chunk.g
                  + ", "
                  + chunk.h
                  + ")"
            );
         par4NBTTagCompound.a("xPos", par2);
         par4NBTTagCompound.a("zPos", par3);
         chunk = this.a(par1World, par4NBTTagCompound.m("Level"));
      }

      chunk.j();
      return chunk;
   }

   @Override
   public void a(World par1World, Chunk par2Chunk) throws IOException {
      par1World.u();

      try {
         ady nbttagcompound = new ady();
         ady nbttagcompound1 = new ady();
         nbttagcompound.a("Level", nbttagcompound1);
         this.a(par2Chunk, par1World, nbttagcompound1);
         this.a(par2Chunk.l(), nbttagcompound);
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }

   protected void a(ChunkCoordIntPair par1ChunkCoordIntPair, ady par2NBTTagCompound) {
      synchronized (this.c) {
         if (this.b.contains(par1ChunkCoordIntPair)) {
            for (int i = 0; i < this.a.size(); i++) {
               if (((ge)this.a.get(i)).a.equals(par1ChunkCoordIntPair)) {
                  this.a.set(i, new ge(par1ChunkCoordIntPair, par2NBTTagCompound));
                  return;
               }
            }
         }

         this.a.add(new ge(par1ChunkCoordIntPair, par2NBTTagCompound));
         this.b.add(par1ChunkCoordIntPair);
         ce.a.a(this);
      }
   }

   public boolean a() {
      ge anvilchunkloaderpending = null;
      synchronized (this.c) {
         if (this.a.size() <= 0) {
            return false;
         }

         anvilchunkloaderpending = (ge)this.a.remove(0);
         this.b.remove(anvilchunkloaderpending.a);
      }

      if (anvilchunkloaderpending != null) {
         try {
            this.a(anvilchunkloaderpending);
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }

      return true;
   }

   private void a(ge par1AnvilChunkLoaderPending) throws IOException {
      DataOutputStream dataoutputstream = RegionFileCache.getChunkOutputStream(this.d, par1AnvilChunkLoaderPending.a.a, par1AnvilChunkLoaderPending.a.b);
      at.a(par1AnvilChunkLoaderPending.b, dataoutputstream);
      dataoutputstream.close();
   }

   @Override
   public void b(World world, Chunk chunk) throws IOException {
   }

   @Override
   public void b() {
   }

   @Override
   public void c() {
   }

   private void a(Chunk par1Chunk, World par2World, ady par3NBTTagCompound) {
      par2World.u();
      par3NBTTagCompound.a("xPos", par1Chunk.g);
      par3NBTTagCompound.a("zPos", par1Chunk.h);
      par3NBTTagCompound.a("LastUpdate", par2World.w());
      par3NBTTagCompound.a("HeightMap", par1Chunk.f);
      par3NBTTagCompound.a("TerrainPopulated", par1Chunk.k);
      zg[] aextendedblockstorage = par1Chunk.i();
      no nbttaglist = new no("Sections");

      for (zg extendedblockstorage : aextendedblockstorage) {
         if (extendedblockstorage != null && extendedblockstorage.f() != 0) {
            ady nbttagcompound = new ady();
            nbttagcompound.a("Y", (byte)(extendedblockstorage.c() >> 4 & 0xFF));
            nbttagcompound.a("Blocks", extendedblockstorage.g());
            if (extendedblockstorage.i() != null) {
               nbttagcompound.a("Add", extendedblockstorage.i().a);
            }

            nbttagcompound.a("Data", extendedblockstorage.j().a);
            nbttagcompound.a("SkyLight", extendedblockstorage.l().a);
            nbttagcompound.a("BlockLight", extendedblockstorage.k().a);
            nbttaglist.a(nbttagcompound);
         }
      }

      par3NBTTagCompound.a("Sections", nbttaglist);
      par3NBTTagCompound.a("Biomes", par1Chunk.m());
      par1Chunk.m = false;
      no nbttaglist1 = new no();

      for (int j = 0; j < par1Chunk.j.length; j++) {
         for (Entity entity : par1Chunk.j[j]) {
            par1Chunk.m = true;
            ady nbttagcompound1 = new ady();
            if (entity.c(nbttagcompound1)) {
               nbttaglist1.a(nbttagcompound1);
            }
         }
      }

      par3NBTTagCompound.a("Entities", nbttaglist1);
      no nbttaglist2 = new no();

      for (TileEntity tileentity : par1Chunk.i.values()) {
         ady nbttagcompound2 = new ady();
         tileentity.b(nbttagcompound2);
         nbttaglist2.a(nbttagcompound2);
      }

      par3NBTTagCompound.a("TileEntities", nbttaglist2);
      List list = par2World.a(par1Chunk, false);
      if (list != null) {
         long l = par2World.w();
         no nbttaglist3 = new no();

         for (NextTickListEntry nextticklistentry : list) {
            ady nbttagcompound3 = new ady();
            nbttagcompound3.a("i", nextticklistentry.d);
            nbttagcompound3.a("x", nextticklistentry.a);
            nbttagcompound3.a("y", nextticklistentry.b);
            nbttagcompound3.a("z", nextticklistentry.c);
            nbttagcompound3.a("t", (int)(nextticklistentry.e - l));
            nbttaglist3.a(nbttagcompound3);
         }

         par3NBTTagCompound.a("TileTicks", nbttaglist3);
      }
   }

   private Chunk a(World par1World, ady par2NBTTagCompound) {
      long i;
      try {
         i = par2NBTTagCompound.g("xPos");
      } catch (ClassCastException ex) {
         i = par2NBTTagCompound.f("xPos");
      }

      long j;
      try {
         j = par2NBTTagCompound.g("zPos");
      } catch (ClassCastException ex) {
         j = par2NBTTagCompound.f("zPos");
      }

      Chunk chunk = new Chunk(par1World, i, j);
      chunk.f = par2NBTTagCompound.l("HeightMap");
      chunk.k = par2NBTTagCompound.o("TerrainPopulated");
      no nbttaglist = par2NBTTagCompound.n("Sections");
      byte byte0 = 16;
      zg[] aextendedblockstorage = new zg[byte0];

      for (int k = 0; k < nbttaglist.d(); k++) {
         ady nbttagcompound = (ady)nbttaglist.a(k);
         byte byte1 = nbttagcompound.d("Y");
         zg extendedblockstorage = new zg(byte1 << 4);
         extendedblockstorage.a(nbttagcompound.k("Blocks"));
         if (nbttagcompound.c("Add")) {
            extendedblockstorage.a(new qq(nbttagcompound.k("Add"), 4));
         }

         extendedblockstorage.b(new qq(nbttagcompound.k("Data"), 4));
         extendedblockstorage.d(new qq(nbttagcompound.k("SkyLight"), 4));
         extendedblockstorage.c(new qq(nbttagcompound.k("BlockLight"), 4));
         extendedblockstorage.d();
         aextendedblockstorage[byte1] = extendedblockstorage;
      }

      chunk.a(aextendedblockstorage);
      if (par2NBTTagCompound.c("Biomes")) {
         chunk.a(par2NBTTagCompound.k("Biomes"));
      }

      no nbttaglist1 = par2NBTTagCompound.n("Entities");
      if (nbttaglist1 != null) {
         for (int l = 0; l < nbttaglist1.d(); l++) {
            ady nbttagcompound1 = (ady)nbttaglist1.a(l);
            Entity entity = EntityList.a(nbttagcompound1, par1World);
            chunk.m = true;
            if (entity != null) {
               chunk.a(entity);
            }
         }
      }

      no nbttaglist2 = par2NBTTagCompound.n("TileEntities");
      if (nbttaglist2 != null) {
         for (int i1 = 0; i1 < nbttaglist2.d(); i1++) {
            ady nbttagcompound2 = (ady)nbttaglist2.a(i1);
            TileEntity tileentity = TileEntity.c(nbttagcompound2);
            if (tileentity != null) {
               chunk.a(tileentity);
            }
         }
      }

      if (par2NBTTagCompound.c("TileTicks")) {
         no nbttaglist3 = par2NBTTagCompound.n("TileTicks");
         if (nbttaglist3 != null) {
            for (int j1 = 0; j1 < nbttaglist3.d(); j1++) {
               ady nbttagcompound3 = (ady)nbttaglist3.a(j1);

               long bULoadX;
               try {
                  bULoadX = nbttagcompound3.g("x");
               } catch (ClassCastException ex) {
                  bULoadX = nbttagcompound3.f("x");
               }

               long bULoadZ;
               try {
                  bULoadZ = nbttagcompound3.g("z");
               } catch (ClassCastException ex) {
                  bULoadZ = nbttagcompound3.f("z");
               }

               par1World.scheduleBlockUpdateFromLoad(bULoadX, nbttagcompound3.f("y"), bULoadZ, nbttagcompound3.f("i"), nbttagcompound3.f("t"));
            }
         }
      }

      return chunk;
   }
}
