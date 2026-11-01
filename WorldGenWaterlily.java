import java.util.Random;

public class WorldGenWaterlily extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      for (int i = 0; i < 10; i++) {
         long j = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
         int k = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
         long l = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
         if (par1World.isAirBlock(j, k, l) && Block.EntityXPOrb.canPlaceBlockAt(par1World, j, k, l)) {
            par1World.setBlock(j, k, l, Block.EntityXPOrb.bO);
         }
      }

      return true;
   }
}
