import java.io.IOException;

public interface IChunkLoader {
   Chunk loadChunk(World var1, long var2, long var4) throws IOException;

   void a(World var1, Chunk var2) throws IOException;

   void b(World var1, Chunk var2) throws IOException;

   void b();

   void c();
}
