import java.util.Random;

public class WorldGenReed extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      for (int i = 0; i < 20; i++) {
         long j = par3 + par2Random.nextInt(4) - par2Random.nextInt(4);
         int k = par4;
         long l = par5 + par2Random.nextInt(4) - par2Random.nextInt(4);
         if (par1World.isAirBlock(j, k, l)
            && (
               par1World.getBlockMaterial(j - 1L, k - 1, l) == acn.g
                  || par1World.getBlockMaterial(j + 1L, k - 1, l) == acn.g
                  || par1World.getBlockMaterial(j, k - 1, l - 1L) == acn.g
                  || par1World.getBlockMaterial(j, k - 1, l + 1L) == acn.g
            )) {
            int i1 = 2 + par2Random.nextInt(par2Random.nextInt(3) + 1);

            for (int j1 = 0; j1 < i1; j1++) {
               if (Block.aX.canBlockStay(par1World, j, k + j1, l)) {
                  par1World.setBlock(j, k + j1, l, Block.aX.bO);
               }
            }
         }
      }

      return true;
   }
}
