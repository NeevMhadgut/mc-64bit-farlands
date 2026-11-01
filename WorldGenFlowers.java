import java.util.Random;

public class WorldGenFlowers extends WorldGenerator {
   private int a;

   public WorldGenFlowers(int par1) {
      this.a = par1;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      for (int i = 0; i < 64; i++) {
         long j = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
         int k = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
         long l = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
         if (par1World.isAirBlock(j, k, l) && ((BlockFlower)Block.m[this.a]).canBlockStay(par1World, j, k, l)) {
            par1World.setBlock(j, k, l, this.a);
         }
      }

      return true;
   }
}
