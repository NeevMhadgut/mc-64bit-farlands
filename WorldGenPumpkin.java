import java.util.Random;

public class WorldGenPumpkin extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      for (int i = 0; i < 64; i++) {
         long j = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
         int k = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
         long l = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
         if (par1World.isAirBlock(j, k, l) && par1World.getBlockId(j, k - 1, l) == Block.u.bO && Block.ba.canPlaceBlockAt(par1World, j, k, l)) {
            par1World.setBlockAndMetadata(j, k, l, Block.ba.bO, par2Random.nextInt(4));
         }
      }

      return true;
   }
}
