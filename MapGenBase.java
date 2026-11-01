import java.util.Random;

public class MapGenBase {
   protected int b = 8;
   protected Random c = new Random();
   protected World d;

   public void generate(IChunkProvider par1IChunkProvider, World par2World, long par3, long par4, byte[] par5ArrayOfByte) {
      int i = this.b;
      this.d = par2World;
      this.c.setSeed(par2World.v());
      long l = this.c.nextLong();
      long l1 = this.c.nextLong();

      for (long j = par3 - i; j <= par3 + i; j++) {
         for (long k = par4 - i; k <= par4 + i; k++) {
            long l2 = j * l;
            long l3 = k * l1;
            this.c.setSeed(l2 ^ l3 ^ par2World.v());
            this.recursiveGenerate(par2World, j, k, par3, par4, par5ArrayOfByte);
         }
      }
   }

   protected void recursiveGenerate(World world, long i, long j, long k, long l, byte[] abyte0) {
   }
}
