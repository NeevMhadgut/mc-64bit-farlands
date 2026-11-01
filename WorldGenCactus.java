import java.util.Random;

public class WorldGenCactus extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      for (int i = 0; i < 10; i++) {
         long j = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
         int k = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
         long l = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
         if (par1World.isAirBlock(j, k, l)) {
            int i1 = 1 + par2Random.nextInt(par2Random.nextInt(3) + 1);

            for (int j1 = 0; j1 < i1; j1++) {
               if (Block.aV.canBlockStay(par1World, j, k + j1, l)) {
                  par1World.setBlock(j, k + j1, l, Block.aV.bO);
               }
            }
         }
      }

      return true;
   }
}
