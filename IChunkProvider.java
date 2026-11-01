import java.util.List;

public interface IChunkProvider {
   boolean chunkExists(long var1, long var3);

   Chunk provideChunk(long var1, long var3);

   Chunk loadChunk(long var1, long var3);

   void populate(IChunkProvider var1, long var2, long var4);

   boolean a(boolean var1, rw var2);

   boolean a();

   boolean b();

   String c();

   List getPossibleCreatures(acf var1, long var2, int var4, long var5);

   ChunkPosition findClosestStructure(World var1, String var2, long var3, int var5, long var6);
}
