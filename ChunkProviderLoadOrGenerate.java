import java.io.IOException;
import java.util.List;

public class ChunkProviderLoadOrGenerate implements IChunkProvider {
   private Chunk c;
   private IChunkProvider d;
   private IChunkLoader e;
   private Chunk[] f;
   private World g;
   long a;
   long b;
   private Chunk h;
   private long i;
   private long j;

   public void setCurrentChunkOver(long par1, long par2) {
      this.i = par1;
      this.j = par2;
   }

   public boolean canChunkExist(long par1, long par2) {
      byte byte0 = 15;
      return par1 >= this.i - byte0 && par2 >= this.j - byte0 && par1 <= this.i + byte0 && par2 <= this.j + byte0;
   }

   @Override
   public boolean chunkExists(long par1, long par2) {
      if (!this.canChunkExist(par1, par2)) {
         return false;
      }

      if (par1 == this.a && par2 == this.b && this.h != null) {
         return true;
      }

      int i = (int)(par1 & 31L);
      int j = (int)(par2 & 31L);
      int k = i + j * 32;
      return this.f[k] != null && (this.f[k] == this.c || this.f[k].isAtLocation(par1, par2));
   }

   @Override
   public Chunk loadChunk(long par1, long par2) {
      return this.provideChunk(par1, par2);
   }

   @Override
   public Chunk provideChunk(long par1, long par2) {
      if (par1 == this.a && par2 == this.b && this.h != null) {
         return this.h;
      }

      if (!this.g.y && !this.canChunkExist(par1, par2)) {
         return this.c;
      }

      int i = (int)(par1 & 31L);
      int j = (int)(par2 & 31L);
      int k = i + j * 32;
      if (!this.chunkExists(par1, par2)) {
         if (this.f[k] != null) {
            this.f[k].e();
            this.b(this.f[k]);
            this.a(this.f[k]);
         }

         Chunk chunk = this.func_542_c(par1, par2);
         if (chunk == null) {
            if (this.d == null) {
               chunk = this.c;
            } else {
               chunk = this.d.provideChunk(par1, par2);
               chunk.j();
            }
         }

         this.f[k] = chunk;
         chunk.c();
         if (this.f[k] != null) {
            this.f[k].d();
         }

         this.f[k].populateChunk(this, this, par1, par2);
      }

      this.a = par1;
      this.b = par2;
      this.h = this.f[k];
      return this.f[k];
   }

   private Chunk func_542_c(long par1, long par2) {
      if (this.e == null) {
         return this.c;
      }

      try {
         Chunk chunk = this.e.loadChunk(this.g, par1, par2);
         if (chunk != null) {
            chunk.n = this.g.w();
         }

         return chunk;
      } catch (Exception exception) {
         exception.printStackTrace();
         return this.c;
      }
   }

   private void a(Chunk par1Chunk) {
      if (this.e != null) {
         try {
            this.e.b(this.g, par1Chunk);
         } catch (Exception exception) {
            exception.printStackTrace();
         }
      }
   }

   private void b(Chunk par1Chunk) {
      if (this.e != null) {
         try {
            par1Chunk.n = this.g.w();
            this.e.a(this.g, par1Chunk);
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
         if (this.d != null) {
            this.d.populate(par1IChunkProvider, par2, par3);
            chunk.f();
         }
      }
   }

   @Override
   public boolean a(boolean par1, rw par2IProgressUpdate) {
      int i = 0;
      int j = 0;
      if (par2IProgressUpdate != null) {
         for (int k = 0; k < this.f.length; k++) {
            if (this.f[k] != null && this.f[k].a(par1)) {
               j++;
            }
         }
      }

      int l = 0;

      for (int i1 = 0; i1 < this.f.length; i1++) {
         if (this.f[i1] != null) {
            if (par1) {
               this.a(this.f[i1]);
            }

            if (this.f[i1].a(par1)) {
               this.b(this.f[i1]);
               this.f[i1].l = false;
               if (++i == 2 && !par1) {
                  return false;
               }

               if (par2IProgressUpdate != null) {
                  if (++l % 10 == 0) {
                     par2IProgressUpdate.a(l * 100 / j);
                  }
               }
            }
         }
      }

      if (par1) {
         if (this.e == null) {
            return true;
         }

         this.e.c();
      }

      return true;
   }

   @Override
   public boolean a() {
      if (this.e != null) {
         this.e.b();
      }

      return this.d.a();
   }

   @Override
   public boolean b() {
      return true;
   }

   @Override
   public String c() {
      return "ChunkCache: " + this.f.length;
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long par4) {
      return this.d.getPossibleCreatures(par1EnumCreatureType, par2, par3, par4);
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int par4, long par5) {
      return this.d.findClosestStructure(par1World, par2Str, par3, par4, par5);
   }
}
