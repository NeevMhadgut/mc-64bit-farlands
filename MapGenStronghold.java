import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenStronghold extends MapGenStructure {
   private BiomeGenBase[] a = new BiomeGenBase[]{BiomeGenBase.d, BiomeGenBase.f, BiomeGenBase.e, BiomeGenBase.h, BiomeGenBase.g, BiomeGenBase.n, BiomeGenBase.o, BiomeGenBase.s, BiomeGenBase.t, BiomeGenBase.v, BiomeGenBase.w, BiomeGenBase.x};
   private boolean f;
   private ChunkCoordIntPair[] g = new ChunkCoordIntPair[3];

   @Override
   protected boolean canSpawnStructureAtCoords(long par1, long par2) {
      if (!this.f) {
         Random random = new Random();
         random.setSeed(this.d.v());
         double d = random.nextDouble() * Math.PI * 2.0;

         for (int k = 0; k < this.g.length; k++) {
            double d1 = (1.25 + random.nextDouble()) * 32.0;
            long l = Math.round(Math.cos(d) * d1);
            long i1 = Math.round(Math.sin(d) * d1);
            ArrayList arraylist = new ArrayList();

            for (BiomeGenBase biomegenbase : this.a) {
               arraylist.add(biomegenbase);
            }

            ChunkPosition chunkposition = this.d.i().findBiomePosition((l << 4) + 8L, (i1 << 4) + 8L, 112, arraylist, random);
            if (chunkposition != null) {
               l = chunkposition.a >> 4;
               i1 = chunkposition.c >> 4;
            } else {
               System.out.println("Placed stronghold in INVALID biome at (" + l + ", " + i1 + ")");
            }

            this.g[k] = new ChunkCoordIntPair(l, i1);
            d += (Math.PI * 2) / this.g.length;
         }

         this.f = true;
      }

      for (ChunkCoordIntPair chunkcoordintpair : this.g) {
         if (par1 == chunkcoordintpair.a && par2 == chunkcoordintpair.b) {
            System.out.println(par1 + ", " + par2);
            return true;
         }
      }

      return false;
   }

   @Override
   protected List a() {
      ArrayList arraylist = new ArrayList();

      for (ChunkCoordIntPair chunkcoordintpair : this.g) {
         if (chunkcoordintpair != null) {
            arraylist.add(chunkcoordintpair.a(64));
         }
      }

      return arraylist;
   }

   @Override
   protected StructureStart getStructureStart(long par1, long par2) {
      StructureStrongholdStart structurestrongholdstart = new StructureStrongholdStart(this.d, this.c, par1, par2);

      while (structurestrongholdstart.b().isEmpty() || ((s)structurestrongholdstart.b().get(0)).b == null) {
         structurestrongholdstart = new StructureStrongholdStart(this.d, this.c, par1, par2);
      }

      return structurestrongholdstart;
   }
}
