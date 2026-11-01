import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class MapGenStructure extends MapGenBase {
   protected HashMap e = new HashMap();

   @Override
   public void generate(IChunkProvider par1IChunkProvider, World par2World, long par3, long par4, byte[] par5ArrayOfByte) {
      super.generate(par1IChunkProvider, par2World, par3, par4, par5ArrayOfByte);
   }

   @Override
   protected void recursiveGenerate(World par1World, long par2, long par3, long par4, long par5, byte[] par6ArrayOfByte) {
      StructureStart testing = (StructureStart)this.e.get(ChunkCoordIntPair.chunkXZ2Int(par2, par3));
      if (testing != null) {
         StructureBoundingBox bruh = testing.a();
         if (bruh.a >> 4 <= par2 && bruh.d >> 4 >= par2 && bruh.c >> 4 <= par4 && bruh.f >> 4 >= par4) {
            return;
         }

         this.e.remove(ChunkCoordIntPair.chunkXZ2Int(par2, par3));
      }

      this.c.nextInt();
      if (this.canSpawnStructureAtCoords(par2, par3)) {
         StructureStart structurestart = this.getStructureStart(par2, par3);
         this.e.put(ChunkCoordIntPair.chunkXZ2Int(par2, par3), structurestart);
      }
   }

   public boolean generateStructuresInChunk(World par1World, Random par2Random, long par3, long par4) {
      long i = (par3 << 4) + 8L;
      long j = (par4 << 4) + 8L;
      boolean flag = false;

      for (StructureStart structurestart : this.e.values()) {
         try {
            ;
         } catch (ConcurrentModificationException ex) {
            structurestart = null;
            break;
         }

         if (structurestart != null && structurestart.d() && structurestart.a().intersectsWith(i, j, i + 15L, j + 15L)) {
            structurestart.a(par1World, par2Random, new StructureBoundingBox(i, j, i + 15L, j + 15L));
            flag = true;
         }
      }

      return flag;
   }

   public boolean func_40483_a(long par1, int par2, long par3) {
      for (StructureStart structurestart : this.e.values()) {
         if (structurestart.d() && structurestart.a().intersectsWith(par1, par3, par1, par3)) {
            for (StructureComponent structurecomponent : structurestart.b()) {
               if (structurecomponent.b().isVecInside(par1, par2, par3)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public ChunkPosition getNearestInstance(World par1World, long par2, int par3, long par4) {
      this.d = par1World;
      this.c.setSeed(par1World.v());
      long l = this.c.nextLong();
      long l1 = this.c.nextLong();
      long l2 = (par2 >> 4) * l;
      long l3 = (par4 >> 4) * l1;
      this.c.setSeed(l2 ^ l3 ^ par1World.v());
      this.recursiveGenerate(par1World, par2 >> 4, par4 >> 4, 0L, 0L, null);
      double d = Double.MAX_VALUE;
      ChunkPosition chunkposition = null;
      Object obj = this.e.values().iterator();

      while (((Iterator)obj).hasNext()) {
         StructureStart structurestart = (StructureStart)((Iterator)obj).next();
         if (structurestart.d()) {
            StructureComponent structurecomponent = (StructureComponent)structurestart.b().get(0);
            ChunkPosition chunkposition2 = structurecomponent.a_();
            long i = chunkposition2.a - par2;
            int k = chunkposition2.b - par3;
            long j1 = chunkposition2.c - par4;
            double d1 = i + i * k * k + j1 * j1;
            if (d1 < d) {
               d = d1;
               chunkposition = chunkposition2;
            }
         }
      }

      if (chunkposition != null) {
         return chunkposition;
      }

      Object var29 = this.a();
      if (var29 != null) {
         ChunkPosition chunkposition1 = null;

         for (ChunkPosition chunkposition3 : var29) {
            long j = chunkposition3.a - par2;
            int i1 = chunkposition3.b - par3;
            long k1 = chunkposition3.c - par4;
            double d2 = j + j * i1 * i1 + k1 * k1;
            if (d2 < d) {
               d = d2;
               chunkposition1 = chunkposition3;
            }
         }

         return chunkposition1;
      } else {
         return null;
      }
   }

   protected List a() {
      return null;
   }

   protected abstract boolean canSpawnStructureAtCoords(long var1, long var3);

   protected abstract StructureStart getStructureStart(long var1, long var3);
}
