import java.util.Random;

public class WorldGenVines extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      long i = par3;
      long j = par5;

      while (par4 < 128) {
         if (par1World.isAirBlock(par3, par4, par5)) {
            for (int k = 2; k <= 5; k++) {
               if (Block.bu.canPlaceBlockOnSide(par1World, par3, par4, par5, k)) {
                  par1World.setBlockAndMetadata(par3, par4, par5, Block.bu.bO, 1 << aav.d[qs.a[k]]);
                  break;
               }
            }
         } else {
            par3 = i + par2Random.nextInt(4) - par2Random.nextInt(4);
            par5 = j + par2Random.nextInt(4) - par2Random.nextInt(4);
         }

         par4++;
      }

      return true;
   }
}
