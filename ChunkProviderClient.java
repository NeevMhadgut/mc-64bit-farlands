import java.util.ArrayList;
import java.util.List;

public class ChunkProviderClient implements IChunkProvider {
   private Chunk a;
   private en b = new en();
   private List c = new ArrayList();
   private World d;

   public ChunkProviderClient(World par1World) {
      this.a = new EmptyChunk(par1World, 0L, 0L);
      this.d = par1World;
   }

   @Override
   public boolean chunkExists(long par1, long par2) {
      return true;
   }

   public void func_539_c(long par1, long par2) {
      Chunk chunk = this.provideChunk(par1, par2);
      if (!chunk.g()) {
         chunk.e();
      }

      this.b.d(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
      this.c.remove(chunk);
   }

   @Override
   public Chunk loadChunk(long par1, long par2) {
      Chunk chunk = new Chunk(this.d, par1, par2);
      this.b.a(ChunkCoordIntPair.chunkXZ2Int(par1, par2), chunk);
      chunk.d = true;
      return chunk;
   }

   @Override
   public Chunk provideChunk(long par1, long par2) {
      Chunk chunk = (Chunk)this.b.a(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
      boolean preChunkTest = false;
      if (chunk != null && (chunk.g != par1 || chunk.h != par2)) {
         chunk.e();
         preChunkTest = true;
      }

      return chunk == null ? this.a : chunk;
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
      return false;
   }

   @Override
   public void populate(IChunkProvider ichunkprovider, long i, long j) {
   }

   @Override
   public String c() {
      return "MultiplayerChunkCache: " + this.b.a();
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long i) {
      return null;
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int i, long j) {
      return null;
   }
}
