import java.util.List;
import java.util.Random;

public class ChunkProviderFlat implements IChunkProvider {
   private World a;
   private Random b;
   private final boolean c;
   private MapGenVillage d;
   private boolean isWool = false;

   public ChunkProviderFlat(World par1World, long par2, boolean par4) {
      this.d = new MapGenVillage(1);
      this.a = par1World;
      this.c = par4;
      this.b = new Random(par2);
   }

   private void a(byte[] par1ArrayOfByte) {
      int i = par1ArrayOfByte.length / 256;

      for (int j = 0; j < 16; j++) {
         for (int k = 0; k < 16; k++) {
            for (int l = 0; l < i; l++) {
               int i1 = 0;
               if (this.isWool) {
                  if (l == 0) {
                     i1 = Block.ab.bO;
                  }
               } else if (l == 0) {
                  i1 = Block.z.bO;
               } else if (l <= 2) {
                  i1 = Block.v.bO;
               } else if (l == 3) {
                  i1 = Block.u.bO;
               }

               par1ArrayOfByte[j << 11 | k << 7 | l] = (byte)i1;
            }
         }
      }
   }

   @Override
   public Chunk loadChunk(long par1, long par2) {
      return this.provideChunk(par1, par2);
   }

   @Override
   public Chunk provideChunk(long par1, long par2) {
      byte[] abyte0 = new byte[32768];
      this.a(abyte0);
      Chunk chunk = new Chunk(this.a, abyte0, par1, par2);
      if (this.c) {
         this.d.generate(this, this.a, par1, par2, abyte0);
      }

      BiomeGenBase[] abiomegenbase = this.a.i().loadBlockGeneratorData(null, par1 * 16L, par2 * 16L, 16, 16);
      byte[] abyte1 = chunk.m();

      for (int i = 0; i < abyte1.length; i++) {
         abyte1[i] = (byte)abiomegenbase[i].M;
      }

      chunk.b();
      return chunk;
   }

   @Override
   public boolean chunkExists(long par1, long par2) {
      return true;
   }

   @Override
   public void populate(IChunkProvider par1IChunkProvider, long par2, long par3) {
      this.b.setSeed(this.a.v());
      long l = this.b.nextLong() / 2L * 2L + 1L;
      long l1 = this.b.nextLong() / 2L * 2L + 1L;
      this.b.setSeed(par2 * l + par3 * l1 ^ this.a.v());
      if (this.c) {
         this.d.generateStructuresInChunk(this.a, this.b, par2, par3);
      }
   }

   @Override
   public boolean a(boolean par1, rw par2IProgressUpdate) {
      return true;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return true;
   }

   @Override
   public String c() {
      return "FlatLevelSource";
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long par4) {
      BiomeGenBase biomegenbase = this.a.getBiomeGenForCoords(par2, par4);
      return biomegenbase == null ? null : biomegenbase.a(par1EnumCreatureType);
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int i, long j) {
      return null;
   }
}
