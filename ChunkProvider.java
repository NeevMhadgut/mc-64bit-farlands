import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChunkProvider implements IChunkProvider {
   private Set a = new HashSet();
   private Chunk b;
   private IChunkProvider c;
   private IChunkLoader d;
   private en e = new en();
   private List f = new ArrayList();
   private World g;
   private int h;

   public ChunkProvider(World par1World, IChunkLoader par2IChunkLoader, IChunkProvider par3IChunkProvider) {
      this.b = new EmptyChunk(par1World, 0L, 0L);
      this.g = par1World;
      this.d = par2IChunkLoader;
      this.c = par3IChunkProvider;
   }

   @Override
   public boolean chunkExists(long par1, long par2) {
      Chunk tempChunk = (Chunk)this.e.a(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
      return tempChunk != null && tempChunk.g == par1 && tempChunk.h == par2;
   }

   public void dropChunk(long par1, long par2) {
      ChunkCoordinates chunkcoordinates = this.g.x();
      long i = par1 * 16L + 8L - chunkcoordinates.a;
      long j = par2 * 16L + 8L - chunkcoordinates.c;
      char c = 128;
      long c2 = c;
      if (i < -c2 || i > c2 || j < -c2 || j > c2) {
         this.a.add(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
      }
   }

   @Override
   public Chunk loadChunk(long par1, long par2) {
      long l = ChunkCoordIntPair.chunkXZ2Int(par1, par2);
      this.a.remove(l);
      Chunk chunk = (Chunk)this.e.a(l);
      boolean preChunkTest = false;
      if (chunk != null && (chunk.g != par1 || chunk.h != par2)) {
         chunk.e();
         this.b(chunk);
         this.a(chunk);
         this.e.d(l);
         preChunkTest = true;
      }

      if (chunk == null || preChunkTest) {
         chunk = this.loadChunkFromFile(par1, par2);
         if (chunk == null) {
            if (this.c == null) {
               chunk = this.b;
            } else {
               chunk = this.c.provideChunk(par1, par2);
            }
         }

         this.e.a(l, chunk);
         this.f.add(chunk);
         if (chunk != null) {
            chunk.c();
            chunk.d();
         }

         chunk.populateChunk(this, this, par1, par2);
      }

      return chunk;
   }

   @Override
   public Chunk provideChunk(long par1, long par2) {
      Chunk chunk = (Chunk)this.e.a(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
      boolean preChunkTest = false;
      if (chunk != null && (chunk.g != par1 || chunk.h != par2)) {
         chunk.e();
         this.b(chunk);
         this.a(chunk);
         this.e.d(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
         preChunkTest = true;
      }

      return chunk != null && !preChunkTest ? chunk : this.loadChunk(par1, par2);
   }

   private Chunk loadChunkFromFile(long par1, long par2) {
      if (this.d == null) {
         return null;
      }

      try {
         Chunk chunk = this.d.loadChunk(this.g, par1, par2);
         if (chunk != null) {
            chunk.n = this.g.w();
         }

         return chunk;
      } catch (Exception exception) {
         exception.printStackTrace();
         return null;
      }
   }

   private void a(Chunk par1Chunk) {
      if (this.d != null) {
         try {
            this.d.b(this.g, par1Chunk);
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }
   }

   private void b(Chunk par1Chunk) {
      if (this.d != null) {
         try {
            par1Chunk.n = this.g.w();
            this.d.a(this.g, par1Chunk);
         } catch (IOException ioexception) {
            ioexception.printStackTrace();
         }
      }
   }

   @Override
   public void populate(IChunkProvider par1IChunkProvider, long par2, long par3) {
      Chunk chunk = this.provideChunk(par2, par3);
      if (!chunk.k) {
         chunk.k = true;
         if (this.c != null) {
            this.c.populate(par1IChunkProvider, par2, par3);
            chunk.f();
         }
      }
   }

   @Override
   public boolean a(boolean par1, rw par2IProgressUpdate) {
      int i = 0;

      for (int j = 0; j < this.f.size(); j++) {
         Chunk chunk = (Chunk)this.f.get(j);
         if (par1) {
            this.a(chunk);
         }

         if (chunk.a(par1)) {
            this.b(chunk);
            chunk.l = false;
            if (++i == 24 && !par1) {
               return false;
            }
         }
      }

      if (par1) {
         if (this.d == null) {
            return true;
         }

         this.d.c();
      }

      return true;
   }

   @Override
   public boolean a() {
      for (int i = 0; i < 100; i++) {
         if (!this.a.isEmpty()) {
            Long long1 = (Long)this.a.iterator().next();
            Chunk chunk1 = (Chunk)this.e.a(long1);
            if (chunk1 != null) {
               chunk1.e();
               this.b(chunk1);
               this.a(chunk1);
            }

            this.a.remove(long1);
            this.e.d(long1);
            this.f.remove(chunk1);
         }
      }

      for (int j = 0; j < 10; j++) {
         if (this.h >= this.f.size()) {
            this.h = 0;
            break;
         }

         Chunk chunk = (Chunk)this.f.get(this.h++);
         EntityPlayer entityplayer = this.g.a((chunk.g << 4) + 8.0, (chunk.h << 4) + 8.0, 288.0);
         if (entityplayer == null) {
            this.dropChunk(chunk.g, chunk.h);
         }
      }

      if (this.d != null) {
         this.d.b();
      }

      return this.c.a();
   }

   @Override
   public boolean b() {
      return true;
   }

   @Override
   public String c() {
      return "ServerChunkCache: " + this.e.a() + " Drop: " + this.a.size();
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long par4) {
      return this.c.getPossibleCreatures(par1EnumCreatureType, par2, par3, par4);
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int par4, long par5) {
      return this.c.findClosestStructure(par1World, par2Str, par3, par4, par5);
   }
}
